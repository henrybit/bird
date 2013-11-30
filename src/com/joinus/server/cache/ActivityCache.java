package com.joinus.server.cache;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.joinus.server.dao.ActivityDao;
import com.joinus.server.dao.FriendShareMessageDao;
import com.joinus.server.dao.PlazaActivityDao;
import com.joinus.server.dao.PlazaShareMessageDao;
import com.joinus.server.entity.Activity;
import com.joinus.server.entity.PlazaActivity;
import com.joinus.server.entity.ShareMessage;
import com.joinus.server.tools.Tools;

/**
 * 活动信息列表缓存<br>
 * @author henrybit
 * @version 1.0
 * @since 2013-4-17
 */
public class ActivityCache implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 52097346333885897L;
	/**好友活动Dao*/
	private static final ActivityDao activityDao = ActivityDao.getInstance();
	/**广场活动Dao*/
	private static final PlazaActivityDao plazaActivityDao = PlazaActivityDao.getInstance();
	/**好友活动分享消息Dao*/
	private static final FriendShareMessageDao friendShareMessageDao = FriendShareMessageDao.getInstance();
	/**广场活动分享消息Dao*/
	private static final PlazaShareMessageDao plazaShareMessageDao = PlazaShareMessageDao.getInstance();
	
	
	/**好友分享消息集合*/
	protected static HashMap<Long, ShareMessage> friendShareMessageMap = new HashMap<Long, ShareMessage>();
	/**好友活动与其消息集合关系*/
	protected static HashMap<Long, List<Long>> activityMessageMap = new HashMap<Long, List<Long>>();
	/**广场分享消息集合*/
	protected static HashMap<Long, ShareMessage> plazaShareMessageMap = new HashMap<Long, ShareMessage>();
	/**广场活动与其消息集合关系*/
	protected static HashMap<Long, List<Long>> plazaActivityMessageMap = new HashMap<Long, List<Long>>();
	/**普通好友与自己创建的活动信息：key-活动id，value-活动信息*/
	protected static HashMap<Long, Activity> activityMap = new HashMap<Long, Activity>();
	/**广场创建的活动信息：key-活动id，value-活动信息*/
	protected static HashMap<Long, PlazaActivity> plazaActivityMap = new HashMap<Long, PlazaActivity>();
	/**用户与普通活动关联关系：key-用户id，value-活动id集合*/
	protected static HashMap<String, List<Long>> userActivityMap = new HashMap<String, List<Long>>();
	/**用户与广场活动关联关系：key-用户id，value-活动id集合*/
	protected static HashMap<String, List<Long>> userPlazaActivityMap = new HashMap<String, List<Long>>();
	
	/**
	 * 初始化装载活动信息、活动与用户关联关系<br>
	 */
	protected static void load() {
		Date currentDay = Tools.getCurrentDay();
		//1.装载好友活动信息 and 装载用户与普通活动关联关系
		initActivity(currentDay);
		//2.装载广场活动信息
		initPlazaActivity(currentDay);
	}
	
	private static void initActivity(Date day) {
		List<Activity> activityList = activityDao.getActivityList(day);
		for(int i=0; i<activityList.size(); i++) {
			Activity activity = activityList.get(i);
			long aid = activity.getId();
			activityMap.put(aid, activity);
			
			//初始化用户与普通活动关联关系
			Set<String> userSet = activity.getJoinUserSet();
			Iterator<String> iterator = userSet.iterator();
			while(iterator.hasNext()) {
				String uid = iterator.next();
				List<Long> aidList = userActivityMap.get(uid);
				if(aidList == null)
					aidList = new ArrayList<Long>();
				aidList.add(aid);
				userActivityMap.put(uid, aidList);
			}
			
			//初始化普通活动的分享消息集合
			List<Long> shareMessageIdList = activityMessageMap.get(aid);
			if(shareMessageIdList == null)
				shareMessageIdList = new ArrayList<Long>();
			List<ShareMessage> shareMessageList = friendShareMessageDao.getShareMessageList(aid);
			for(int j=0; j<shareMessageList.size(); j++) {
				ShareMessage shareMessage = shareMessageList.get(j);
				long shareMessageId = shareMessage.getId();
				friendShareMessageMap.put(shareMessageId, shareMessage);
				shareMessageIdList.add(shareMessageId);
			}
			
			activityMessageMap.put(aid, shareMessageIdList);
		}
	}
	
	private static void initPlazaActivity(Date day) {
		List<PlazaActivity> plazaActivityList = plazaActivityDao.getPlazaActivityList(day);
		for(int i=0; i<plazaActivityList.size(); i++) {
			PlazaActivity plazaActivity = plazaActivityList.get(i);
			long aid = plazaActivity.getId();
			plazaActivityMap.put(aid, plazaActivity);
			
			//初始化用户与广场活动关联关系
			Set<String> userSet = plazaActivity.getJoinUserSet();
			Iterator<String> iterator = userSet.iterator();
			while(iterator.hasNext()) {
				String uid = iterator.next();
				List<Long> aidList = userPlazaActivityMap.get(uid);
				if(aidList == null)
					aidList = new ArrayList<Long>();
				aidList.add(aid);
				userPlazaActivityMap.put(uid, aidList);
			}
			
			//初始化广场活动的分享消息集合
			List<Long> shareMessageIdList = plazaActivityMessageMap.get(aid);
			if(shareMessageIdList == null)
				shareMessageIdList = new ArrayList<Long>();
			List<ShareMessage> shareMessageList = plazaShareMessageDao.getShareMessageList(aid);
			for(int j=0; j<shareMessageList.size(); j++) {
				ShareMessage shareMessage = shareMessageList.get(j);
				long shareMessageId = shareMessage.getId();
				plazaShareMessageMap.put(shareMessageId, shareMessage);
				shareMessageIdList.add(shareMessageId);
			}
			
			plazaActivityMessageMap.put(aid, shareMessageIdList);
		}
	}
}
