package com.joinus.server.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.joinus.server.entity.ShareMessage;
import com.joinus.server.tools.Tools;

/**
 * 广场活动分享消息集合<br>
 * @author henrybit
 * @version 1.1
 * @since 2013-11-27
 */
public class PlazaShareMessageDao extends ShareMessageDao {
	
	private final static PlazaShareMessageDao plazaShareMessageDao = new PlazaShareMessageDao();
	/**查询SQL前缀*/
	protected final static String QUERY_SHARE_MESSAGE = "select * from plaza_share_message ";
	/**插入SQL前缀*/
	protected final static String INSERT_SHARE_MESSAGE = "insert into plaza_share_message values(";
	
	protected PlazaShareMessageDao() {
	}
	
	/**
	 * 获取广场分享活动Dao实例<br>
	 * @return plazaShareMessageDao
	 */
	public static PlazaShareMessageDao getInstance() {
		return plazaShareMessageDao;
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
		sql.append(" where ").append(columns[1]).append("=").append(aid);
		sql.append(" and ").append(columns[5]).append(">=").append(shareTimeLong);
		
		ResultSet rs = super.query(sql.toString());
		try {
			shareMessageList = parseResultSet(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return shareMessageList;
	}
	
	/**
	 * 创建一个广场活动分享信息<br>
	 * @param shareMessage
	 * @return shareMessage
	 */
	public ShareMessage createShareMessage(ShareMessage shareMessage) {
		StringBuilder sql = new StringBuilder(INSERT_SHARE_MESSAGE);
		sql.append("null,");
		sql.append(shareMessage.getAid()).append(",");
		sql.append("'").append(shareMessage.getShareUid()).append("',");
		sql.append("'").append(shareMessage.getContent()).append("',");
		sql.append("'").append(shareMessage.getPic()).append("',");
		sql.append(shareMessage.getShareTimeLong());
		sql.append(")");
		
		ResultSet resultSet = super.insert(sql.toString());
		shareMessage.setId(0);
		try {
			long id = resultSet.getLong(0);
			shareMessage.setId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return shareMessage;
	}
}
