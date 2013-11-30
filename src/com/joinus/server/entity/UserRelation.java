package com.joinus.server.entity;

import java.util.Date;

/**
 * 用户关系<br>
 * @author henrybit
 * @version 1.0
 * @since 2013-4-5
 */
public class UserRelation {
	/**用户id*/
	private String uid;
	/**好友id*/
	private String friendId;
	/**好友关系是否有更新：1-有更新，0-无更新*/
	private int hasUpdate;
	/**关系状态:1-邀请中,2-好友,3-推荐好友*/
	private int status;
	/**关系程度:1<=>100*/
	private float relationValue;
	
	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}
	/**
	 * @return the relationValue
	 */
	public float getRelationValue() {
		return relationValue;
	}
	/**
	 * @param relationValue the relationValue to set
	 */
	public void setRelationValue(float relationValue) {
		this.relationValue = relationValue;
	}
	/**
	 * @return the uid
	 */
	public String getUid() {
		return uid;
	}
	/**
	 * @param uid the uid to set
	 */
	public void setUid(String uid) {
		this.uid = uid;
	}
	/**
	 * @return the friendId
	 */
	public String getFriendId() {
		return friendId;
	}
	/**
	 * @param friendId the friendId to set
	 */
	public void setFriendId(String friendId) {
		this.friendId = friendId;
	}
	/**
	 * @return the hasUpdate
	 */
	public int getHasUpdate() {
		return hasUpdate;
	}
	/**
	 * @param hasUpdate the hasUpdate to set
	 */
	public void setHasUpdate(int hasUpdate) {
		this.hasUpdate = hasUpdate;
	}
}
