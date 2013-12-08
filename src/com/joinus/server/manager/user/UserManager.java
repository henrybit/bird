package com.joinus.server.manager.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.sf.json.JSONObject;

import com.joinus.server.constant.Constant;
import com.joinus.server.dao.UserInfoDao;
import com.joinus.server.entity.User;

/**
 * 用户管理相应操作(控制单例)<br>
 * @author henrybit
 * @version 1.0
 * @since 2013-4-6
 */
public class UserManager {
	
	/**用户DAO实例*/
	private final static UserInfoDao userDao = UserInfoDao.getInstance();
	/**用户管理实例*/
	private final static UserManager userManager = new UserManager();
	/***/
	private static final String[] createNewUserParametersName = {"name","uid","phone_no","device_no","password"};
	
	/**
	 * 禁止外部创建实例
	 */
	private UserManager() {
	}
	
	public static UserManager getInstance() {
		return userManager;
	}
	
	/**
	 * 应用第一次打开后，获取一个新用户ID，用来唯一标识该用户在该设备上的应用编号<br>
	 * @param parameters 请求参数
	 * @return {“status”:1,"uid ": “223497”}
	 */
	public String createNewUser(HashMap<String, String> parameters) {
		/*
		String id = parameters.get("uid");
		String name = parameters.get("name");
		String phoneNo = parameters.get("phone_no");
		String deviceNo = parameters.get("device_no");
		String password = parameters.get("password");
		int status = Constant.CREATENEWUSER_STATUS_INIT;
		if(!isExsitUser(id)) {
			id = userDao.createNewUser(id, name, phoneNo, deviceNo, password);
			status = Constant.CREATENEWUSER_STATUS_SUCCESS;
		} else {
			status = Constant.CREATENEWUSER_STATUS_EXSIT;
		}
		if(id==null || id.isEmpty())
			status = Constant.CREATENEWUSER_STATUS_FAILED;
		JSONObject jsonObject = new JSONObject();
		jsonObject.accumulate("status", status);
		jsonObject.accumulate("uid", id);
		String json = jsonObject.toString();
		return json;
		*/
		return "";
	}
	
	/**
	 * 用户是否存在<br>
	 * @param uid 用户ID
	 * @return boolean-如果用户存在，返回true;否则返回false.
	 */
	public boolean isExsitUser(String uid) {
		/*
		if(uid==null || uid.isEmpty())
			return false;
		User user = userDao.getUserInfo(uid);
		if(user != null)
			return true;
		return false;
		*/
		return false;
	}
	
	/**
	 * 根据用户ID返回用户信息
	 * @param parameters 请求参数
	 * @return {"uid":"121jf","name":"henrybit","sex":1,"picUrl":"http://1.jpg","phoneNo":"12128139018","deviceNo":"i190219090","create_time":"1232019831980"}
	 */
	public String getUserInfo(HashMap<String, String> parameters) {
		/*
		String userInfo = "";
		String uid = parameters.get("uid");
		if(uid==null || uid.isEmpty())
			return userInfo;
		User user = userDao.getUserInfo(uid);
		if(user != null) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.accumulate("uid", user.getId());
			jsonObject.accumulate("name", user.getName());
			jsonObject.accumulate("sex", user.getSex());
			jsonObject.accumulate("picUrl", user.getPicUrl());
			jsonObject.accumulate("phoneNo", user.getPhoneNo());
			jsonObject.accumulate("deviceNo", user.getDeviceNo());
			jsonObject.accumulate("create_time", user.getCreateTimeLong());
			userInfo = jsonObject.toString();
		}
		return userInfo;
		*/
		return "";
	}
	
	/**
	 * 上传通讯录<br>
	 * @param parametersList 请求参数列表
	 * @return {"status":1,"error_code":""}
	 */
	public String uploadContactList(List<HashMap<String, String>> parametersList) {
		/*
		int insertCount = -1;
		if(parametersList!=null && parametersList.size()>0) {
			List<UserContactList> list = new ArrayList<UserContactList>();
			for(HashMap<String, String> parameters : parametersList) {
				String uid = parameters.get("uid");
				String friendId = parameters.get("friend_id");
				String phoneNo = parameters.get("phoneNo");
				String deviceNo = parameters.get("deviceNo");
				String name = parameters.get("name");
				
				UserContactList userContactList = new UserContactList();
				userContactList.setOwnerId(uid);
				userContactList.setFriendId(friendId);
				userContactList.setPhoneNo(phoneNo);
				userContactList.setDeviceNo(deviceNo);
				userContactList.setName(name);
				
				list.add(userContactList);
			}
			insertCount = userContactListDao.addAllContact(list);
		}
		JSONObject jsonObject = new JSONObject();
		if(insertCount > 0) {
			jsonObject.accumulate("status", 1);
			jsonObject.accumulate("error_code", "");
		} else {
			jsonObject.accumulate("status", -1);
			jsonObject.accumulate("error_code", "");
		}
		return jsonObject.toString();
		*/
		return "";
	}
}
