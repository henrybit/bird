package com.joinus.server.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.joinus.server.entity.UserRelationNotice;

/**
 * 用户关系更新通知<br>
 * @author henrybit
 * @version 1.1
 * @since 2013-11-28
 */
public class UserRelationNoticeDao extends BaseDao<UserRelationNotice> {

	private static final UserRelationNoticeDao userRelationNoticeDao = new UserRelationNoticeDao();
	
	private static final String QUERY_USER_RELATION_NOTICE = "select * from user_relation_notice ";
	
	/**USER_RELATION_NOTICE表所有字段（按顺序排列）*/
	private static final String[] columns = new String[]{"uid","friendId","behavior","message"};
	/**USER_RELATION_NOTICE表所有字段类型（按顺序排列）*/
	private static final String[] columnsType = new String[]{"string","string","int","string"};
	
	protected UserRelationNoticeDao() {
	}
	
	public static UserRelationNoticeDao getInstance() {
		return userRelationNoticeDao;
	}
	
	/**
	 * 获取所有用户关系更新通知<br>
	 * @return List
	 */
	public List<UserRelationNotice> getAllUserRelationNotice() {
		List<UserRelationNotice> userRelationNoticeList = new ArrayList<UserRelationNotice>();
		StringBuilder sql = new StringBuilder(QUERY_USER_RELATION_NOTICE);
		ResultSet rs = super.query(sql.toString());
		try {
			userRelationNoticeList = parseResultSet(rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userRelationNoticeList;
	}
	
	/* (non-Javadoc)
	 * @see com.joinus.server.dao.BaseDao#parseResultSet(java.sql.ResultSet)
	 */
	@Override
	protected List<UserRelationNotice> parseResultSet(ResultSet rs) throws SQLException {
		List<UserRelationNotice> userRelationNoticeList = new ArrayList<UserRelationNotice>();
		if(rs == null)
			return userRelationNoticeList;
		
		while(rs.next()) {
			UserRelationNotice userRelationNotice = new UserRelationNotice();
			try {
				String uid = rs.getString("uid");
				String friendId = rs.getString("friendId");
				int behavior = rs.getInt("behavior");
				String message = rs.getString("message");
				
				userRelationNotice.setUid(uid);
				userRelationNotice.setFriendId(friendId);
				userRelationNotice.setBehavior(behavior);
				userRelationNotice.setMessage(message);
			} catch (Exception e) {
				e.printStackTrace();
				continue;
			}
			userRelationNoticeList.add(userRelationNotice);
		}
		
		return userRelationNoticeList;
	}

}
