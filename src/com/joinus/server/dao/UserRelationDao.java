package com.joinus.server.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.joinus.server.entity.UserRelation;

/**
 * 用户人脉关系数据库操作层<br>
 * @author
 * <ul> 
 * <li><a href="mailto:qipenghui3056@gmail.com">henrybit</a></li>
 * </ul>
 * @version 1.0
 * @since 2013-4-4
 */
public class UserRelationDao extends BaseDao {
	/**用户DAO单例*/
	private final static UserRelationDao usersRelationDao = new UserRelationDao();
	/**更新关系SQL前缀*/
	private final static String UPDATE_RELATION_STATUS = "update user_relation ";
	/**查询关系SQL前缀*/
	private final static String QUERY_USER_RELATION = "select * from user_relation ";
	/**查询关系总数SQL前缀*/
	private final static String QUERY_USER_RELATION_COUNT = "select count(0) from user_relation ";
	
	/**USER_RELATION表所有字段（按顺序排列）*/
	private final String[] columns = new String[]{"uid","friendId","hasUpdate","status","relationValue"};
	/**USER_RELATION表所有字段类型（按顺序排列）*/
	private final String[] columnsType = new String[]{"string","string","int","int","int"};
	
	private UserRelationDao() {
	}
	
	/**
	 * 用户关系单例<br>
	 * @return UsersRelationDao 用户关系Dao
	 */
	public static UserRelationDao getInstance() {
		return usersRelationDao;
	}
	
	/**
	 * 获取某个用户的所有好友关系列表<br>
	 * @param uid 用户id
	 * @return List
	 */
	public List<UserRelation> getUserRelation(String uid) {
		List<UserRelation> userRelationList = new ArrayList<UserRelation>();
		StringBuilder sql = new StringBuilder(QUERY_USER_RELATION);
		sql.append(columns[0]).append("='").append(uid).append("'");
		ResultSet rs = super.query(sql.toString());
		try {
			userRelationList = parseResultSet(rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userRelationList;
	}
	
	/* (non-Javadoc)
	 * @see com.joinus.server.dao.BaseDao#parseResultSet(java.sql.ResultSet)
	 */
	@Override
	protected List<UserRelation> parseResultSet(ResultSet rs) throws SQLException {
		List<UserRelation> userRelationList = new ArrayList<UserRelation>();
		if(rs == null)
			return userRelationList;
		while(rs.next()) {
			UserRelation userRelation = new UserRelation();
			try {
				String uid = rs.getString("uid");
				String friendId = rs.getString("friendId");
				int hasUpdate = rs.getInt("hasUpdate");
				int status = rs.getInt("status");
				int relationValue = rs.getInt("relationValue");
				
				userRelation.setUid(uid);
				userRelation.setFriendId(friendId);
				userRelation.setHasUpdate(hasUpdate);
				userRelation.setStatus(status);
				userRelation.setRelationValue(relationValue);
			} catch (Exception e) {
				e.printStackTrace();
				continue;
			}
			userRelationList.add(userRelation);
		}
		return userRelationList;
	}
	
}
