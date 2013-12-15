package com.joinus.server.manager.activity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.joinus.server.constant.Constant;
import com.joinus.server.dao.PlazaActivityDao;
import com.joinus.server.dao.PlazaShareMessageDao;
import com.joinus.server.entity.PlazaActivity;
import com.joinus.server.entity.ShareMessage;

/**
 * 广场活动服务Manager<br>
 * @author henrybit
 * @version 1.1
 * @since 2013-12-3
 */
public class PlazaActivityManager {
	/**广场活动唯一实例*/
	private final static PlazaActivityManager plazaActivityManager = new PlazaActivityManager();
	/**广场活动Dao实例*/
	private final static PlazaActivityDao plazaActivityDao = PlazaActivityDao.getInstance();
	/**广场评论Dao实例*/
	private final static PlazaShareMessageDao plazaShareMessageDao = PlazaShareMessageDao.getInstance();
	/**日期格式*/
	private final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	protected PlazaActivityManager() {
	}
	
	/**获取广场活动唯一实例*/
	public static PlazaActivityManager getInstance() {
		return plazaActivityManager;
	}
	
	/**
	 * 创建一个广场活动<br>
	 * @param parameters
	 * @return String-创建广场活动返回的Json
	 */
	public String createPlazaActivity(HashMap<String, String> parameters) {
		PlazaActivity plazaAcitivity = new PlazaActivity();
		try {
			String name = parameters.get("name");
			int tag = Integer.valueOf(parameters.get("tag"));
			String content = parameters.get("content");
			String createUserId = parameters.get("createUserId");
			String joinUsersId = parameters.get("joinUsersId");
			String lat = parameters.get("lat");
			String lng = parameters.get("lng");
			String address = parameters.get("address");
			String startTime = parameters.get("startTime");
			String headPic = parameters.get("headPic");
			
			plazaAcitivity.setName(name);
			plazaAcitivity.setTag(tag);
			plazaAcitivity.setContent(content);
			plazaAcitivity.setCreateUserId(createUserId);
			plazaAcitivity.setJoinUsersId(joinUsersId);
			plazaAcitivity.setLatitude(lat);
			plazaAcitivity.setLongitude(lng);
			plazaAcitivity.setAddress(address);
			plazaAcitivity.setStartTimeLong(Long.parseLong(startTime));
			plazaAcitivity.setHeadPic(headPic);
			
			plazaAcitivity = plazaActivityDao.createPlazaActivity(plazaAcitivity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JSONObject jsonObject = new JSONObject();
		if(plazaAcitivity.getId()<=0) {
			jsonObject.accumulate("status", Constant.CREATE_NEW_ACTIVITY_STATUS_FAILED);
		} else {
			jsonObject.accumulate("status", Constant.CREATE_NEW_ACTIVITY_STATUS_SUCCESS);
		}
		jsonObject.accumulate("error_code", "1");
		jsonObject.accumulate("aid", plazaAcitivity.getId());
		
		return jsonObject.toString();
	}
	
	/**
	 * 获取某个活动<br>
	 * @param parameters
	 * @return string-活动的json格式数据
	 */
	public String getPlazaActivity(HashMap<String, String> parameters) {
		String id = parameters.get("id");
		JSONObject jsonObject = new JSONObject();
		try {
			List<PlazaActivity> plazaActivityList = plazaActivityDao.getPlazaActivityById(Long.parseLong(id));
			if(plazaActivityList!=null) {
				PlazaActivity plazaActivity = plazaActivityList.get(0);
				HashMap<String, String> plazaMap = plazaActivity.toHashMap();
				
				Iterator<String> iterator = plazaMap.keySet().iterator();
				while(iterator.hasNext()) {
					String key = iterator.next();
					String value = plazaMap.get(key);
					jsonObject.accumulate(key, value);
				}
				
				String shareMessageJson = getShareMessageList(id);
				jsonObject.accumulate("comments", shareMessageJson);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return jsonObject.toString();
	}
	
	/**
	 * 获取广场活动列表<br>
	 * @param parameters 查询参数
	 * @return String-广场活动列表Json
	 */
	public String getPlazaActivityList(HashMap<String, String> parameters) {
		String day = parameters.get("day");
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		try {
			Date startTime = sdf.parse(day);
			List<PlazaActivity> plazaActivityList = plazaActivityDao.getPlazaActivityList(startTime);
			for(int i=0; plazaActivityList!=null&&i<plazaActivityList.size(); i++) {
				PlazaActivity plazaActivity = plazaActivityList.get(i);
				if(plazaActivity != null) {
					HashMap<String, String> plazaMap = plazaActivity.toHashMap();
					Iterator<String> iterator = plazaMap.keySet().iterator();
					JSONObject dataObject = new JSONObject();
					while(iterator.hasNext()) {
						String key = iterator.next();
						String value = plazaMap.get(key);
						dataObject.accumulate(key, value);
					}
					
					jsonArray.add(dataObject);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		jsonObject.accumulate("activitys", jsonArray);
		
		return jsonObject.toString();
	}
	
	/*
	public String getShareMessage(HashMap<String, String> parameters) {
	}
	*/
	
	/**
	 * 根据广场id获取相关评论列表<br>
	 * @param aid 广场id
	 * @return 评论列表json
	 */
	public String getShareMessageList(String aid) {
		HashMap<String, String> parameters = new HashMap<String, String>();
		return getShareMessageList(parameters);
	}
	
	/**
	 * 获取评论消息列表<br>
	 * @param parameters
	 * @return string-评论列表json
	 */
	public String getShareMessageList(HashMap<String, String> parameters) {
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		int shareMessageCount = 0;
		try {
			String aid = parameters.get("aid");
			List<ShareMessage> shareMessageList = plazaShareMessageDao.getShareMessageList(Long.parseLong(aid));
			shareMessageCount = shareMessageList.size();
			for(int i=0; i<shareMessageCount; i++) {
				ShareMessage shareMessage = shareMessageList.get(i);
				if(shareMessage != null) {
					HashMap<String, String> shareMessageMap = shareMessage.toHashMap();
					Iterator<String> iterator = shareMessageMap.keySet().iterator();
					JSONObject dataObject = new JSONObject();
					while(iterator.hasNext()) {
						String key = iterator.next();
						String value = shareMessageMap.get(key);
						dataObject.accumulate(key, value);
					}
					jsonArray.add(dataObject);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		jsonObject.accumulate("shareMesages", jsonArray);
		jsonObject.accumulate("count", shareMessageCount);
		return jsonObject.toString();
	}
	
	/**
	 * 创建一个评论<br>
	 * @param parameters 评论信息
	 * @return String-评论Json
	 */
	public String addShareMessage(HashMap<String, String> parameters) {
		ShareMessage shareMessage = new ShareMessage();
		JSONObject jsonObject = new JSONObject();
		try {
			Long aid = Long.parseLong(parameters.get("aid"));
			String shareUid = parameters.get("shareUid");
			String content = parameters.get("content");
			String pic = parameters.get("pic");
			Long shareTimeLong = Long.parseLong(parameters.get("shareTime"));
			Date shareTime = new Date(shareTimeLong);
			
			shareMessage.setAid(aid);
			shareMessage.setShareUid(shareUid);
			shareMessage.setContent(content);
			shareMessage.setPic(pic);
			shareMessage.setShareTimeLong(shareTimeLong);
			shareMessage.setShareTime(shareTime);
			
			shareMessage = plazaShareMessageDao.createShareMessage(shareMessage);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(shareMessage.getId() > 0) {
			jsonObject.accumulate("status", Constant.CREATE_NEW_SHARE_MESSAGE_SUCCESS);
		} else {
			jsonObject.accumulate("status", Constant.CREATE_NEW_SHARE_MESSAGE_FAILED);
		}
		
		jsonObject.accumulate("error_code", "1");
		jsonObject.accumulate("sid", shareMessage.getId());
		
		return jsonObject.toString();
	}
}
