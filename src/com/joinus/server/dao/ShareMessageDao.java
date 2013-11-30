package com.joinus.server.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.joinus.server.entity.ShareMessage;

/**
 * 好友活动分享消息Dao<br>
 * @author
 * <ul> 
 * <li><a href="mailto:qipenghui3056@gmail.com">henrybit</a></li>
 * </ul>
 * @version 1.1
 * @since 2013-11-22
 */
public class ShareMessageDao extends BaseDao<ShareMessage> {
	
	private final static ShareMessageDao shareMessageDao = new ShareMessageDao();
	/**PLAZA_SHARE_MESSAGE or FRIEND_SHARE_MESSAGE表所有字段（按顺序排列）*/
	protected final String[] columns = new String[]{"id","aid","shareUid","content","pic","shareTime"};
	/**PLAZA_SHARE_MESSAGE or FRIEND_SHARE_MESSAGE表所有字段类型（按顺序排列）*/
	protected final String[] columnsType = new String[]{"long","long","string","string","string","long"};
	
	protected ShareMessageDao() {
	}
	/**
	 * 获取好友活动分享消息Dao<br>
	 * @return shareMessageDao
	 */
	public static ShareMessageDao getInstance() {
		return shareMessageDao;
	}
	
	/* (non-Javadoc)
	 * @see com.joinus.server.dao.BaseDao#parseResultSet(java.sql.ResultSet)
	 */
	@Override
	protected List<ShareMessage> parseResultSet(ResultSet rs) throws SQLException {
		List<ShareMessage> shareMessageList = new ArrayList<ShareMessage>();
		if(rs == null)
			return shareMessageList;
		
		while(rs.next()) {
			ShareMessage shareMessage = new ShareMessage();
			try {
				long id = rs.getLong("id");
				long aid = rs.getLong("aid");
				String shareUid = rs.getString("shareUid");
				String content = rs.getString("content");
				String pic = rs.getString("pic");
				long shareTimeLong = rs.getLong("shareTime");
				Date shareTime = new Date(shareTimeLong);
				
				shareMessage.setId(id);
				shareMessage.setAid(aid);
				shareMessage.setShareUid(shareUid);
				shareMessage.setContent(content);
				shareMessage.setPic(pic);
				shareMessage.setShareTime(shareTime);
				shareMessage.setShareTimeLong(shareTimeLong);
			} catch (Exception e) {
				e.printStackTrace();
				continue;
			}
			shareMessageList.add(shareMessage);
		}
		
		return shareMessageList;
	}
}
