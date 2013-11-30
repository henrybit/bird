package com.joinus.server.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.joinus.server.entity.ActivityNotice;

/**
 * 用户活动通知Dao<br>
 * @author henrybit
 * @version 1.1
 * @since 2013-11-27
 */
public class UserActivityNoticeDao extends ActivityNoticeDao {
	
	private static final UserActivityNoticeDao userActivityNoticeDao = new UserActivityNoticeDao();
	/**查询SQL*/
	private static final String QUERY_USER_ACTIVITY_NOTICE = "select * from user_activity_notice ";
	
	/**USER_ACTIVITY_NOTICE表所有字段（按顺序排列）*/
	private final String[] columns = new String[]{"uid","aid","sid"};
	/**USER_ACTIVITY_NOTICE表所有字段类型（按顺序排列）*/
	private final String[] columnsType = new String[]{"string","long","long"};
	
	protected UserActivityNoticeDao() {
	}
	
	public static UserActivityNoticeDao getInstance() {
		return userActivityNoticeDao;
	}
	
	/**
	 * 获取所有通知数据<br>
	 * @return List
	 */
	public List<ActivityNotice> getAllNotice() {
		List<ActivityNotice> activityNoticeList = new ArrayList<ActivityNotice>();
		StringBuilder sql = new StringBuilder(QUERY_USER_ACTIVITY_NOTICE);
		ResultSet rs = super.query(sql.toString());
		try {
			activityNoticeList = parseResultSet(rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return activityNoticeList;
	}
}
