package com.joinus.server.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.joinus.server.entity.ShareMessage;
import com.joinus.server.tools.Tools;

/**
 * 好友活动分享消息Dao<br>
 * @author henrybit
 * @version 1.1
 * @since 2013-11-26
 */
public class FriendShareMessageDao extends ShareMessageDao {
	
	private final static FriendShareMessageDao friendShareMessageDao = new FriendShareMessageDao();
	/**查询SQL前缀*/
	protected final static String QUERY_SHARE_MESSAGE = "select * from friend_share_message";
	
	protected FriendShareMessageDao() {
	}
	
	/**
	 * 获取好友活动分享消息Dao实例<br>
	 * @return friendShareMessageDao
	 */
	public static FriendShareMessageDao getInstance() {
		return friendShareMessageDao;
	}
	
	/**
	 * 返回某个活动大于等于今天0点的分享消息集合<br>
	 * @param aid 活动id
	 * @return List-分享消息集合
	 */
	public List<ShareMessage> getShareMessageList(long aid) {
		return getShareMessageList(aid, Tools.getCurrentDay());
	}
	
	/**
	 * 返回某个活动的在指定时间的分享消息集合<br>
	 * @param aid 活动id
	 * @param shareTime 分享时间
	 * @return List-分享消息集合
	 */
	public List<ShareMessage> getShareMessageList(long aid, Date shareTime) {
		List<ShareMessage> shareMessageList = new ArrayList<ShareMessage>();
		
		if(shareTime == null) {
			shareTime = Tools.getCurrentDay();
		}
		long shareTimeLong = shareTime.getTime();
		StringBuilder sql = new StringBuilder(QUERY_SHARE_MESSAGE);
		sql.append(columns[5]).append(">=").append(shareTimeLong);
		
		ResultSet rs = super.query(sql.toString());
		try {
			shareMessageList = parseResultSet(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return shareMessageList;
	}
	
	
}
