package com.joinus.server.cache;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.joinus.server.dao.UserInfoDao;
import com.joinus.server.dao.UserRelationDao;
import com.joinus.server.entity.User;
import com.joinus.server.entity.UserRelation;

/**
 * 用户信息缓存<br>
 * @author henrybit
 * @version 1.1
 * @since 2013-11-25
 */
public class UserCache implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8281212381051118524L;
	/**用户Dao实例*/
	private static final UserInfoDao userInfoDao = UserInfoDao.getInstance();
	/**用户关系Dao实例*/
	private static final UserRelationDao userRelationDao = UserRelationDao.getInstance();
	
	/**用户信息*/
	protected static HashMap<String, User> userMap = new HashMap<String, User>();
	/**用户关系*/
	protected static HashMap<String, List<String>> userRelationMap = new HashMap<String, List<String>>(); 
	
	/**
	 * 初始化装载用户信息与用户关系信息<br>
	 */
	protected static void load() {
		List<User> userList = userInfoDao.getAllUser();
		for(int i=0; i<userList.size(); i++) {
			User user = userList.get(i);
			String uid = user.getId();
			userMap.put(uid, user);
			
			List<String> friendIdList = userRelationMap.get(uid);
			if(friendIdList == null)
				friendIdList = new ArrayList<String>();
			List<UserRelation> userRelationList = userRelationDao.getUserRelation(uid);
			for(int j=0; j<userRelationList.size(); j++) {
				UserRelation userRelation = userRelationList.get(j);
				String friendId = userRelation.getFriendId();
				friendIdList.add(friendId);
			}
			
			userRelationMap.put(uid, friendIdList);
		}
	}
}
