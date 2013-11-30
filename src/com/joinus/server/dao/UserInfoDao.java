package com.joinus.server.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.joinus.server.constant.Constant;
import com.joinus.server.entity.User;
import com.joinus.server.tools.Tools;

/**
 * 用户数据库操作层<br>
 * @author
 * <ul> 
 * <li><a href="mailto:qipenghui3056@gmail.com">henrybit</a></li>
 * </ul>
 * @version 1.0
 * @since 2013-4-4
 */
public class UserInfoDao extends BaseDao<User>{
	/**用户DAO单例*/
	private final static UserInfoDao userInfoDao = new UserInfoDao();
	/**查询用户信息*/
	private final static String QUERY_USER = "select * from user_info ";
	/**USER_INFO表所有字段（按顺序排列）*/
	private final String[] columns = new String[]{"uid","name","password","sex","localPicUrl","picUrl","phoneNo","deviceNo","createTime","updateTime"};
	/**USER_INFO表所有字段类型（按顺序排列）*/
	private final String[] columnsType = new String[]{"string","string","string","int","string","string","string","string","long","long"};
	
	private UserInfoDao() {
	}
	
	/**
	 * 用户单例<br>
	 * @return userInfoDao 用户信息Dao
	 */
	public static UserInfoDao getInstance() {
		return userInfoDao;
	}
	
	/**
	 * 获取所有用户<br>
	 * @return List
	 */
	public List<User> getAllUser() {
		List<User> userList = new ArrayList<User>();
		StringBuilder sql = new StringBuilder(QUERY_USER);
		ResultSet rs = super.query(sql.toString());
		try {
			userList = parseResultSet(rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userList;
	}
	
	/**
	 * 获取某个指定用户的信息<br>
	 * @param uid 用户id
	 * @return List
	 */
	public List<User> getUserInfo(String uid) {
		List<User> userList = new ArrayList<User>();
		StringBuilder sql = new StringBuilder(QUERY_USER);
		sql.append(columns[0]).append("='").append(uid).append("'");
		ResultSet rs = super.query(sql.toString());
		try {
			userList = parseResultSet(rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userList;
	}
	
	/**
	 * 从结果集中取出用户数据<br>
	 * @return user-用户信息实体
	 */
	@Override
	protected List<User> parseResultSet(ResultSet resultSet) throws SQLException {
		List<User> userInfoList = new ArrayList<User>();
		if(resultSet == null)
			return userInfoList;
		while(resultSet.next()) {
			User user = new User();
			try {
				String id = resultSet.getString("uid");
				String name = resultSet.getString("name");
				String password = resultSet.getString("password");
				int sex = resultSet.getInt("sex");
				String picUrl = resultSet.getString("picUrl");
				String phoneNo = resultSet.getString("phoneNo");
				String deviceNo = resultSet.getString("deviceNo");
				Date createTime = resultSet.getDate("createTime");
				Date updateTime = resultSet.getDate("updateTime");
				
				user.setId(id);
				user.setName(name);
				user.setPassword(password);
				user.setPhoneNo(phoneNo);
				user.setDeviceNo(deviceNo);
				user.setSex(sex);
				user.setPicUrl(picUrl);
				user.setCreateTime(createTime);
				user.setCreateTimeLong(createTime.getTime());
				user.setUpdateTime(updateTime);
				user.setUpdateTimeLong(updateTime.getTime());
			} catch (Exception e) {
				e.printStackTrace();
				continue;
			}
			userInfoList.add(user);
		}
		
		return userInfoList;
	}
}
