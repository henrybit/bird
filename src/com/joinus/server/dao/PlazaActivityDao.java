package com.joinus.server.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.joinus.server.entity.PlazaActivity;
import com.joinus.server.tools.Tools;

/**
 * 广场活动数据库操作层<br>
 * @author
 * <ul> 
 * <li><a href="mailto:qipenghui3056@gmail.com">henrybit</a></li>
 * </ul>
 * @version 1.0
 * @since 2013-4-4
 */
public class PlazaActivityDao extends BaseDao<PlazaActivity> {
	/**广场活动Dao实例*/
	private final static PlazaActivityDao plazaActivityDao = new PlazaActivityDao();
	
	/**查询SQL前缀*/
	private final static String QUERY_PLAZA_ACTIVITY = "select * from plaza_activity ";
	/**插入SQL前缀*/
	private final static String INSERT_PLAZA_ACTIVITY = "insert into plaza_activity values(";
	/**PLAZA_ACTIVITY表所有字段（按顺序排列）*/
	private final String[] columns = new String[]{"id","name","tag","content","createUserId","joinUsersId","lat","lng","address","startTime","headPic"};
	/**PLAZA_ACTIVITY表所有字段类型（按顺序排列）*/
	private final String[] columnsType = new String[]{"long","string","int","string","string","string","string","string","string","long","string"};
	
	private PlazaActivityDao(){
	}
	
	/**
	 * 获取plazaActivityDao实例<br>
	 * @return plazaActivityDao
	 */
	public static PlazaActivityDao getInstance() {
		return plazaActivityDao;
	}
	
	/**
	 * 创建一个广场活动<br>
	 * @param name 广场活动名
	 * @param tag 广场活动类型
	 * @param content 广场活动内容
	 * @param createUserId 广场活动发起者
	 * @param joinUsersId 广场活动参与者
	 * @param lat 纬度
	 * @param lng 经度
	 * @param address 地址
	 * @param startTime 开始时间
	 * @param headPic 活动图片
	 * @return long-广场活动ID
	 */
	public long createPlazaActivity(String name, int tag, String content, String createUserId, 
			String joinUsersId, double lat, double lng, String address, long startTime ,String headPic) {
		StringBuilder sql = new StringBuilder(INSERT_PLAZA_ACTIVITY);
		sql.append("null,");
		sql.append("'").append(name).append("',");
		sql.append(tag).append(",");
		sql.append("'").append(content).append("',");
		sql.append("'").append(createUserId).append("',");
		sql.append("'").append(joinUsersId).append("',");
		sql.append(lat).append(",");
		sql.append(lng).append(",");
		sql.append("'").append(address).append("',");
		sql.append(startTime).append(",");
		sql.append("'").append(headPic).append("'");
		sql.append(")");
		
		ResultSet resultSet = super.insert(sql.toString());
		long id = -1;
		try {
			id = resultSet.getLong(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return id;
	}
	
	/**
	 * 创建一个广场活动<br>
	 * @param plazaActivity
	 * @return PlazaActivity-广场活动ID
	 */
	public PlazaActivity createPlazaActivity(PlazaActivity plazaActivity) {
		StringBuilder sql = new StringBuilder(INSERT_PLAZA_ACTIVITY);
		sql.append("null,");
		sql.append("'").append(plazaActivity.getName()).append("',");
		sql.append(plazaActivity.getTag()).append(",");
		sql.append("'").append(plazaActivity.getContent()).append("',");
		sql.append("'").append(plazaActivity.getCreateUserId()).append("',");
		sql.append("'").append(plazaActivity.getJoinUsersId()).append("',");
		sql.append(plazaActivity.getLatitude()).append(",");
		sql.append(plazaActivity.getLongitude()).append(",");
		sql.append("'").append(plazaActivity.getAddress()).append("',");
		sql.append(plazaActivity.getStartTimeLong()).append(",");
		sql.append("'").append(plazaActivity.getHeadPic()).append("'");
		sql.append(")");
		
		ResultSet resultSet = super.insert(sql.toString());
		plazaActivity.setId(0);
		try {
			long id = resultSet.getLong(0);
			plazaActivity.setId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return plazaActivity;
	}
	
	/**
	 * 获取在指定时间以后的所有活动信息(注意：如果该时间未指定，强制使用当天0点时间)<br>
	 * @param startTime 指定时间
	 * @return List
	 */
	public List<PlazaActivity> getPlazaActivityList(Date startTime) {
		List<PlazaActivity> plazaActivityList = new ArrayList<PlazaActivity>();
		
		if(startTime == null) {
			startTime = Tools.getCurrentDay();
		}
		long startTimeLong = startTime.getTime();
		StringBuilder sql = new StringBuilder(QUERY_PLAZA_ACTIVITY);
		sql.append("where ").append(columns[9]).append(">=").append(startTimeLong);
		
		ResultSet rs = super.query(sql.toString());
		
		plazaActivityList = parseResultSet(rs);
		
		return plazaActivityList;
	}
	
	/**
	 * 获取指定id的广场活动信息<br>
	 * @param id 广场活动id
	 * @return List
	 */
	public List<PlazaActivity> getPlazaActivityById(long id) {
		List<PlazaActivity> plazaActivityList = new ArrayList<PlazaActivity>();
		
		StringBuilder sql = new StringBuilder(QUERY_PLAZA_ACTIVITY);
		sql.append("where ").append(columns[0]).append("=").append(id);
		
		ResultSet rs = super.query(sql.toString());
		
		plazaActivityList = parseResultSet(rs);
		
		return plazaActivityList;
	}
	
	/**
	 * 解析活动查询结果信息组装成活动对象List返回<br>
	 * @param rs
	 * @return List
	 */
	@Override
	protected List<PlazaActivity> parseResultSet(ResultSet rs) {
		List<PlazaActivity> activityList = new ArrayList<PlazaActivity>();
		
		try {
			while(rs.next()) {
				long id = rs.getLong("id");
				String name = rs.getString("name");
				int tag = rs.getInt("tag");
				String content = rs.getString("content");
				String createUserId = rs.getString("createUserId");
				String joinUsersId = rs.getString("joinUsersId");
				Set<String> joinUserSet = Tools.split(joinUsersId, "#");
				String latitude = rs.getString("lat");
				String longitude = rs.getString("lng");
				String address = rs.getString("address");
				long startTimeLong = rs.getLong("startTime");
				Date startTime = new Date(startTimeLong);
				String headPic = rs.getString("headPic");
				
				
				PlazaActivity activity = new PlazaActivity(); 
				activity.setId(id);
				activity.setName(name);
				activity.setTag(tag);
				activity.setContent(content);
				activity.setCreateUserId(createUserId);
				activity.setJoinUsersId(joinUsersId);
				activity.setJoinUserSet(joinUserSet);
				activity.setLatitude(latitude);
				activity.setLongitude(longitude);
				activity.setAddress(address);
				activity.setStartTime(startTime);
				activity.setStartTimeLong(startTimeLong);
				activity.setHeadPic(headPic);
				
				activityList.add(activity);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return activityList;
	}
}
