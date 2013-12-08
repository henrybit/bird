package com.joinus.server.manager.activity;

import java.util.HashMap;

import com.joinus.server.dao.ActivityDao;

/**
 * 活动管理<br>
 * @author henrybit
 * @version 1.0
 * @since 2013-4-7
 */
public class ActivityManager {
	/**活动Dao实例*/
	private final static ActivityDao meetingDao = ActivityDao.getInstance();
	/**活动Manager实例*/
	private final static ActivityManager meetingManager = new ActivityManager();
	
	private ActivityManager() {
	}
	
	/**
	 * 获取活动Manager实例<br>
	 * @return MeetingManager
	 */
	public static ActivityManager getInstance() {
		return meetingManager;
	}
	
	/**
	 * 发送活动邀请<br>
	 * @param parameters 请求参数
	 * @return {"status":1,"error_code":"","meeting_id":123}
	 */
	public String sendMeeting(HashMap<String, String> parameters) {
		/*
		String tagStr = parameters.get("tag");
		int tag = ActivityConstant.ACTIVITY_TAG_ACTIVE;
		try {
			tag = Integer.valueOf(tagStr);
		} catch (Exception e){
			e.printStackTrace();
		}
		String startTime = parameters.get("start_time");
		String content = parameters.get("content");
		String createUserId = parameters.get("uid");
		String address = parameters.get("address");
		String userList = parameters.get("user_list");
		
		long meetingId = -1L;
		long meetingUsersId = -1L;
		if(userList!=null&&userList.isEmpty()) {
			//1.创建活动信息
			meetingId = meetingDao.createNewMessage(tag, startTime, content, createUserId, ActivityConstant.MEETING_STATUS_PREPARE, address);
		}
		
		JSONObject jsonObject = new JSONObject();
		if(meetingId==-1 || meetingUsersId==-1) {
			jsonObject.accumulate("status", Constant.CREATENEWMEETING_STATUS_FAILED);
		} else {
			jsonObject.accumulate("status", Constant.CREATENEWMEETING_STATUS_SUCCESS);
		}
		jsonObject.accumulate("error_code", "1");
		jsonObject.accumulate("meeting_id", meetingId);
		
		return jsonObject.toString();
		*/
		return "";
	}
	
	/**
	 * 获取活动信息<br>
	 * @param parameters 请求参数
	 * @return 
	 * {"meetings":[
	 * 		{"id":1,"tag":3,"content":"今晚参加john的party","create_user_id":"44553","status":1,"address":" 13141,48008","start_time":" 1364545652460"},
	 * 		{"id":2,"tag":4,"content":"哲学研讨论会","create_user_id":"44543","status":2,"address":" 14334,14993","start_time":" 1364545652460"},
	 * 		{"id":3,"tag":4,"content":"哲学研讨论会","create_user_id":"44543","status":2,"address":" 14334,14993","start_time":" 1364545652460"}
	 * 		],
	 * "meetings_num":3,
	 * "update_time":1364545652460
	 * }
	 */
	public String getMeeting(HashMap<String, String> parameters) {
		/*
		JSONObject jsonObject = new JSONObject();
		String uid = parameters.get("uid");
		//id#tag#content#create_user_id#status#address#start_time
		String fields = parameters.get("fields");
		String[] resultNames = null;
		if(fields==null || fields.isEmpty()) {
			//id#status
			resultNames = new String[2];
			resultNames[0] = "id";
			resultNames[1] = "status";
		} else {
			resultNames = fields.split("#");
		}
		String updateTime = parameters.get("update_time");
		
		//获取参加的活动列表
		List<ActivityUsers> meetingUsersList = meetingUsersdao.getMeetingUsersList(uid, Tools.getDateFormate(updateTime, Constant.DATE_YYYY_MM_DD_HH_MM_SS));
		List<Long> meetingIdList = new ArrayList<Long>();
		HashMap<Long, ActivityUsers> meetingUsersMap = new HashMap<Long, ActivityUsers>();
		for(int i=0; i<meetingUsersList.size(); i++) {
			ActivityUsers meetingUsers = meetingUsersList.get(i);
			if(meetingUsers == null)
				continue;
			long meetingId = meetingUsers.getMeetingId();
			meetingIdList.add(meetingId);
			meetingUsersMap.put(meetingId, meetingUsers);
		}
		
		//获取活动的详细信息
		List<HashMap<String, String>> meetingList = meetingDao.getMeetingMap(meetingIdList);
		JSONArray jsonArray = new JSONArray();
		for(int i=0; meetingList!=null&&i<meetingList.size(); i++) {
			HashMap<String, String> meetingInfo = meetingList.get(i);
			JSONObject meetingJson = new JSONObject();
			for(int j=0; resultNames!=null&&j<resultNames.length; j++) {
				String value = meetingInfo.get(resultNames[j]);
				meetingJson.accumulate(resultNames[j], value);
			}
			jsonArray.add(meetingJson);
		}
		
		jsonObject.accumulate("meetings", jsonArray);
		jsonObject.accumulate("meetings_num", meetingList.size());
		jsonObject.accumulate("update_time", (new Date()).getTime());
		return jsonObject.toString();
		*/
		return "";
	}
	
	/**
	 * 确认加入活动<br>
	 * @param parameters 请求参数
	 * @return {"status":1,"error_code":""}
	 */
	public String agreeMeeting(HashMap<String, String> parameters) {
		/*
		String uid = parameters.get("uid");
		String meetingIdStr = parameters.get("meeting_id");
		long meetingId = -1;
		try {
			meetingId = Long.valueOf(meetingIdStr);
		} catch (Exception e) { 
			e.printStackTrace();
		}
		
		long id = userMeetingJoinDao.createNew(uid, meetingId);
		JSONObject jsonObject = new JSONObject();
		
		if(id!=-1L) {
			jsonObject.accumulate("status", Constant.AGREEMEETING_STATUS_SUCCESS);
			jsonObject.accumulate("error_code", "");
		} else {
			jsonObject.accumulate("status", Constant.AGREEMEETING_STATUS_FAILED);
			jsonObject.accumulate("error_code", "insert error");
		}
		return jsonObject.toString();
		*/
		return "";
	}
}
