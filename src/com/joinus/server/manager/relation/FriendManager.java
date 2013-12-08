package com.joinus.server.manager.relation;

import java.util.HashMap;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.joinus.server.constant.Constant;
import com.joinus.server.dao.UserInfoDao;
import com.joinus.server.dao.UserRelationDao;
import com.joinus.server.entity.User;

/**
 * 用户关系管理<br>
 * @author henrybit
 * @version 1.0
 * @since 2013-4-18
 */
public class FriendManager {
	/**活动Manager实例*/
	private final static FriendManager friendManager = new FriendManager();
	/**用户关系Dao实例*/
	private final static UserRelationDao usersRelationDao = UserRelationDao.getInstance();
	/**用户Dao实例*/
	private final static UserInfoDao usersDao = UserInfoDao.getInstance();
	
	private FriendManager() {
	}
	
	/**
	 * 获取用户关系Manager实例<br>
	 * @return FriendManager
	 */
	public static FriendManager getInstance() {
		return friendManager;
	}
	
	/**
	 * 
	 * @param parameters
	 * @return {"friends ": [
	 * {"id":"33458","name":"小k","phoneNo":"138114488"},
	 * {"id":"44564","name":"harry","phoneNo":"18841987"}
	 * ]"num":2,"totalNum":10}
	 */
	public String friendList(HashMap<String, String> parameters) {
		/*
		JSONObject jsonObject = new JSONObject();
		String uid = parameters.get("uid");
		String beginStr = parameters.get("begin");
		String limitStr = parameters.get("limit");
		int begin = 0;
		int limit = 5;
		if(beginStr!=null && !beginStr.isEmpty()) {
			begin = Integer.valueOf(beginStr);
		}
		if(limitStr!=null && !limitStr.isEmpty()) {
			limit = Integer.valueOf(limitStr);
		}
		String fields = parameters.get("fields");
		String[] resultNames = null;
		if(fields==null || fields.isEmpty()) {
			//id
			resultNames = new String[1];
			resultNames[0] = "id";
			
			//好友总数
			int totalNum = usersRelationDao.getFriendTotal(uid);
			
			//获取用户好友ID列表
			List<String> friendIdList = usersRelationDao.getFriendList(uid, begin, limit);
			JSONArray jsonArray = new JSONArray();
			for(int i=0; i<friendIdList.size(); i++) {
				JSONObject friendJson = new JSONObject();
				friendJson.accumulate("id", friendIdList.get(i));
				jsonArray.add(friendJson);
			}
			jsonObject.accumulate("friends", jsonArray);
			jsonObject.accumulate("num", friendIdList.size());
			jsonObject.accumulate("totalNum", totalNum);
		} else {
			resultNames = fields.split("#");
			//获取用户好友ID列表
			List<String> friendIdList = usersRelationDao.getFriendList(uid, begin, limit);
			//好友信息列表
			List<HashMap<String, String>> friendList = usersDao.getUserInfoMap(friendIdList);
			//好友总数
			int totalNum = usersRelationDao.getFriendTotal(uid);
			
			JSONArray jsonArray = new JSONArray();
			for(int i=0; friendList!=null&&i<friendList.size(); i++) {
				HashMap<String, String> friendInfo = friendList.get(i);
				JSONObject friendJson = new JSONObject();
				for(int j=0; resultNames!=null&&j<resultNames.length; j++) {
					String value = friendInfo.get(resultNames[j]);
					friendJson.accumulate(resultNames[j], value);
				}
				jsonArray.add(friendJson);
			}
			
			jsonObject.accumulate("friends", jsonArray);
			jsonObject.accumulate("num", friendIdList.size());
			jsonObject.accumulate("totalNum", totalNum);
		}
		
		return jsonObject.toString();
		*/
		return "";
	}
	
	/**
	 * 同一建立好友关系<br>
	 * @param parameters
	 * @return {"status":1,"error_code":""}
	 */
	public String agreeFriend(HashMap<String, String> parameters) {
		/*
		String uid = parameters.get("uid");
		String friendId = parameters.get("friend_id");
		
		boolean isSuccess = usersRelationDao.makeFriend(friendId, uid);
		
		JSONObject jsonObject = new JSONObject();
		if(isSuccess) {
			jsonObject.accumulate("status", 1);
			jsonObject.accumulate("error_code", "");
		} else {
			jsonObject.accumulate("status", -1);
			jsonObject.accumulate("error_code", "failed");
		}
		return jsonObject.toString();
		*/
		return "";
	}
	
	/**
	 * 添加好友关系<br>
	 * @param parameters
	 * @return {"status":1,"error_code":""}
	 */
	public String addFriend(HashMap<String, String> parameters) {
		/*
		String uid = parameters.get("uid");
		String friendId = parameters.get("friend_id");
		String phoneNo = parameters.get("phone_no");
		if(friendId==null || friendId.isEmpty()) {
			User user = usersDao.getUserInfoByPhoneNo(phoneNo);
			if(user == null)
				friendId = phoneNo;
			else
				friendId = user.getId();
		}
		
		long id = usersRelationDao.createNewUserRelation(uid, friendId, Constant.USERRELATION_STATUS_INVITE, 0f);
		
		JSONObject jsonObject = new JSONObject();
		if(id > 0) {
			jsonObject.accumulate("status", 1);
			jsonObject.accumulate("error_code", "");
		} else {
			jsonObject.accumulate("status", -1);
			jsonObject.accumulate("error_code", "failed");
		}
		return jsonObject.toString();
		*/
		return "";
	}
}
