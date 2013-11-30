package com.joinus.server.cache;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.joinus.server.dao.UserActivityNoticeDao;
import com.joinus.server.dao.UserPlazaNoticeDao;
import com.joinus.server.dao.UserRelationNoticeDao;
import com.joinus.server.entity.ActivityNotice;
import com.joinus.server.entity.UserRelationNotice;

/**
 * 通知缓存<br>
 * @author henrybit
 * @version 1.1
 * @since 2013-11-27
 */
public class NoticeCache implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9163620534577462080L;
	/**用户普通活动通知Dao*/
	private final static UserActivityNoticeDao userActivityNoticeDao = UserActivityNoticeDao.getInstance();
	/**用户广场活动通知Dao*/
	private final static UserPlazaNoticeDao userPlazaNoticeDao = UserPlazaNoticeDao.getInstance();
	/**用户关系更新通知Dao*/
	private final static UserRelationNoticeDao userRelationNoticeDao = UserRelationNoticeDao.getInstance();
	
	/**普通活动通知*/
	protected static HashMap<Long, List<Long>> activityNoticeMap = new HashMap<Long, List<Long>>();
	/**广场活动通知*/
	protected static HashMap<Long, List<Long>> plazaNoticeMap = new HashMap<Long, List<Long>>();
	/**用户关系通知*/
	protected static HashMap<String, List<UserRelationNotice>> userRelationNoticeMap = new HashMap<String, List<UserRelationNotice>>();
	
	public static void load() {
		List<ActivityNotice> activityNoticeList = userActivityNoticeDao.getAllNotice();
		for(int i=0; i<activityNoticeList.size(); i++) {
			ActivityNotice activityNotice = activityNoticeList.get(i);
			long aid = activityNotice.getAid();
			long sid = activityNotice.getSid();
			
			List<Long> sidList = activityNoticeMap.get(aid);
			if(sidList == null)
				sidList = new ArrayList<Long>();
			sidList.add(sid);
			activityNoticeMap.put(aid, sidList);
		}
		
		List<ActivityNotice> plazaNoticeList = userPlazaNoticeDao.getAllNotice();
		for(int i=0; i<plazaNoticeList.size(); i++) {
			ActivityNotice plazaNotice = plazaNoticeList.get(i);
			long aid = plazaNotice.getAid();
			long sid = plazaNotice.getSid();
			
			List<Long> sidList = plazaNoticeMap.get(aid);
			if(sidList == null)
				sidList = new ArrayList<Long>();
			sidList.add(sid);
			plazaNoticeMap.put(aid, sidList);
		}
		
		List<UserRelationNotice> userRelationNoticeList = userRelationNoticeDao.getAllUserRelationNotice();
		for(int i=0; i<userRelationNoticeList.size(); i++) {
			UserRelationNotice userRelationNotice = userRelationNoticeList.get(i);
			String uid = userRelationNotice.getUid();
			
			List<UserRelationNotice> noticeList = userRelationNoticeMap.get(uid);
			if(noticeList == null)
				noticeList = new ArrayList<UserRelationNotice>();
			
			noticeList.add(userRelationNotice);
			userRelationNoticeMap.put(uid, noticeList);
		}
	}
}
