package com.joinus.server.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.joinus.server.entity.ActivityNotice;

/**
 * 活动通知Dao<br>
 * @author henrybit
 * @version 1.1
 * @since 2013-11-27
 */
public class ActivityNoticeDao extends BaseDao<ActivityNotice> {
	
	private static final ActivityNoticeDao activityNoticeDao = new ActivityNoticeDao();
	
	protected ActivityNoticeDao() {
	}
	
	/**
	 *获取活动通知Dao实例<br>
	 * @return ActivityNoticeDao
	 */
	public static ActivityNoticeDao getInstance() {
		return activityNoticeDao;
	}
	

	/* (non-Javadoc)
	 * @see com.joinus.server.dao.BaseDao#parseResultSet(java.sql.ResultSet)
	 */
	@Override
	protected List<ActivityNotice> parseResultSet(ResultSet rs) throws SQLException {
		List<ActivityNotice> activityNoticeList = new ArrayList<ActivityNotice>();
		if(rs == null)
			return activityNoticeList;
		
		while(rs.next()) {
			ActivityNotice activityNotice = new ActivityNotice();
			try {
				String uid = rs.getString("uid");
				long aid = rs.getLong("aid");
				long sid = rs.getLong("sid");
				
				activityNotice.setUid(uid);
				activityNotice.setAid(aid);
				activityNotice.setSid(sid);
			} catch (Exception e) {
				e.printStackTrace();
				continue;
			}
			activityNoticeList.add(activityNotice);
		}
		
		return activityNoticeList;
	}

}
