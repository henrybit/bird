package com.joinus.server.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.joinus.server.entity.ActivityNotice;

/**
 * 用户广场活动通知<br>
 * @author henrybit
 * @version 1.1
 * @since 2013-11-27
 */
public class UserPlazaNoticeDao extends ActivityNoticeDao {
	
	private static final UserPlazaNoticeDao userPlazaNoticeDao = new UserPlazaNoticeDao();
	/**查询SQL*/
	private static final String QUERY_USER_PLAZA_NOTICE = "select * from user_plaza_notice ";
	
	protected UserPlazaNoticeDao() {
	}
	
	/**
	 * 获取UserPlazaNoticeDao实例<br>
	 * @return UserPlazaNoticeDao
	 */
	public static UserPlazaNoticeDao getInstance() {
		return userPlazaNoticeDao;
	}
	
	/**
	 * 获取所有通知数据<br>
	 * @return List
	 */
	public List<ActivityNotice> getAllNotice() {
		List<ActivityNotice> activityNoticeList = new ArrayList<ActivityNotice>();
		StringBuilder sql = new StringBuilder(QUERY_USER_PLAZA_NOTICE);
		ResultSet rs = super.query(sql.toString());
		try {
			activityNoticeList = parseResultSet(rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return activityNoticeList;
	}
}
