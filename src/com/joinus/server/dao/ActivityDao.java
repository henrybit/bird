package com.joinus.server.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.joinus.server.constant.Constant;
import com.joinus.server.entity.Activity;
import com.joinus.server.tools.Tools;

/**
 * 好友活动数据库操作层<br>
 * @author
 * <ul> 
 * <li><a href="mailto:qipenghui3056@gmail.com">henrybit</a></li>
 * </ul>
 * @version 1.0
 * @since 2013-4-4
 */
public class ActivityDao extends BaseDao<Activity> {
	/**活动Dao实例*/
	private final static ActivityDao activityDao = new ActivityDao();
	/**插入SQL前缀*/
	private final static String INSERT_NEW_ACTIVITY = "insert into activity values ";
	/**查询SQL前缀*/
	private final static String QUERY_ACTIVITY = "select * from activity ";
	/**ACTIVITY表所有字段（按顺序排列）*/
	private final String[] columns = new String[]{"id","name","tag","content","createUserId","joinUsersId","status","lat","lng","address","startTime","headPic","pubStatus"};
	/**ACTIVITY表所有字段类型（按顺序排列）*/
	private final String[] columnsType = new String[]{"long","string","int","string","string","string","int","string","string","string","long","string","int"};
	
	protected ActivityDao() {
	}
	
	/**
	 * 获取activityDao实例<br>
	 * @return activityDao
	 */
	public static ActivityDao getInstance() {
		return activityDao;
	}
	
	/**
	 * 获取在指定时间以后的所有活动信息(注意：如果该时间未指定，强制使用当天0点时间)<br>
	 * @param startTime 指定时间
	 * @return List
	 */
	public List<Activity> getActivityList(Date startTime) {
		List<Activity> activityList = new ArrayList<Activity>();
		
		if(startTime == null) {
			startTime = Tools.getCurrentDay();
		}
		long startTimeLong = startTime.getTime();
		StringBuilder sql = new StringBuilder(QUERY_ACTIVITY);
		sql.append(columns[10]).append(">=").append(startTimeLong);
		
		ResultSet rs = super.query(sql.toString());
		try {
			activityList = parseResultSet(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return activityList;
	}
	
	/**
	 * @deprecated
	 * 创建一条新的活动<br>
	 * @param tag 活动类型(1-购物,2-运动,3-会议,4-聚餐,5-游戏)
	 * @param startTime 活动开始时间(可以为空)
	 * @param content 活动内容(可以为空)
	 * @param createUserId 活动创建者
	 * @param status 活动状态(1-活动预备,2-活动进行中,3-活动完成,4-活动撤销)
	 * @param address 活动地址(可以为空)
	 * @return long-如果创建成功返回创建成功的主键ID;否则返回-1.
	 */
	public long createNewMessage(int tag, String startTime, String content, String createUserId, int status, String address) {
		return this.createNewMessage(tag, startTime, content, createUserId, status, address, null, null);
	}
	
	/**
	 * @deprecated
	 * 创建一条新的活动<br>
	 * @param tag 活动类型(1-购物,2-运动,3-会议,4-聚餐,5-游戏)
	 * @param startTime 活动开始时间(可以为空)
	 * @param content 活动内容(可以为空)
	 * @param createUserId 活动创建者
	 * @param status 活动状态(1-活动预备,2-活动进行中,3-活动完成,4-活动撤销)
	 * @param address 活动地址(可以为空)
	 * @param createTime 创建时间
	 * @param updateTime 更新时间
	 * @return long-如果创建成功返回创建成功的主键ID;否则返回-1.
	 */
	public long createNewMessage(int tag, String startTime, String content, String createUserId, int status, String address, String createTime, String updateTime) {
		StringBuilder sql = new StringBuilder(INSERT_NEW_ACTIVITY);
		//id auto increatement by db
		sql.append("(null");
		//tag
		sql.append(",").append(tag);
		//startTime
		if(startTime == null)
			sql.append(",").append(startTime).append("");
		else
			sql.append(",'").append(startTime).append("'");
		
		//content
		sql.append(",'").append(content).append("'");
		
		//createUserId
		sql.append(",'").append(createUserId).append("'");
		
		//status
		sql.append(",").append(status);
		
		//address
		sql.append(",'").append(address).append("'");
		
		//createTime and updateTime
		Date now = new Date();
		if(createTime == null) {
			createTime = Tools.getDateFormat(now, Constant.DATE_YYYY_MM_DD_HH_MM_SS);
		}
		if(updateTime == null) {
			updateTime = Tools.getDateFormat(now, Constant.DATE_YYYY_MM_DD_HH_MM_SS);
		}
		sql.append(",'").append(createTime).append("'");
		sql.append(",'").append(updateTime).append("'");
		
		sql.append(")");
		
		ResultSet rs = super.insert(sql.toString());
		long id = -1L;
		try {
			rs.next();
			id = rs.getLong(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}
	
	/**
	 * 解析活动查询结果信息组装成活动对象List返回<br>
	 * @param rs
	 * @return List
	 * @throws SQLException
	 */
	@Override
	protected List<Activity> parseResultSet(ResultSet rs) throws SQLException{
		List<Activity> activityList = new ArrayList<Activity>();
		if(rs == null)
			return activityList;
		while(rs.next()) {
			Activity activity = new Activity(); 
			try {
				long id = rs.getLong("id");
				String name = rs.getString("name");
				int tag = rs.getInt("tag");
				String content = rs.getString("content");
				String createUserId = rs.getString("createUserId");
				String joinUsersId = rs.getString("joinUsersId");
				Set<String> joinUserSet = Tools.split(joinUsersId, "#");
				int status = rs.getInt("status");
				String latitude = rs.getString("lat");
				String longitude = rs.getString("lng");
				String address = rs.getString("address");
				long startTimeLong = rs.getLong("startTime");
				Date startTime = new Date(startTimeLong);
				String headPic = rs.getString("headPic");
				int pubStatus = rs.getInt("pubStatus");
				
				activity.setId(id);
				activity.setName(name);
				activity.setTag(tag);
				activity.setContent(content);
				activity.setCreateUserId(createUserId);
				activity.setJoinUsersId(joinUsersId);
				activity.setJoinUserSet(joinUserSet);
				activity.setStatus(status);
				activity.setLatitude(latitude);
				activity.setLongitude(longitude);
				activity.setAddress(address);
				activity.setStartTime(startTime);
				activity.setStartTimeLong(startTimeLong);
				activity.setHeadPic(headPic);
				activity.setPubStatus(pubStatus);
			} catch (Exception e) {
				e.printStackTrace();
				continue;
			}	
			activityList.add(activity);
		}
		
		return activityList;
	}
}
