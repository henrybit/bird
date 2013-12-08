package com.joinus.server.manager.activity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.joinus.server.constant.Constant;
import com.joinus.server.dao.PlazaActivityDao;
import com.joinus.server.entity.PlazaActivity;

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
			
			long id = plazaActivityDao.createPlazaActivity(plazaAcitivity);
			plazaAcitivity.setId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JSONObject jsonObject = new JSONObject();
		if(plazaAcitivity.getId()==-1) {
			jsonObject.accumulate("status", Constant.CREATE_NEW_ACTIVITY_STATUS_FAILED);
		} else {
			jsonObject.accumulate("status", Constant.CREATE_NEW_ACTIVITY_STATUS_SUCCESS);
		}
		jsonObject.accumulate("error_code", "1");
		jsonObject.accumulate("aid", plazaAcitivity.getId());
		
		return jsonObject.toString();
	}
	
	public String getPlazaActivity(HashMap<String, String> parameters) {
		String id = parameters.get("id");
		JSONObject jsonObject = new JSONObject();
		try {
			JSONArray jsonArray = new JSONArray();
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
}
