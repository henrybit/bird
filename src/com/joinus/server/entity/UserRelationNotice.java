package com.joinus.server.entity;

/**
 * 用户关系更新通知<br>
 * @author henrybit
 * @version 1.1
 * @since 2013-11-22
 */
public class UserRelationNotice {
	/**用户id*/
	private String uid;
	/**好友id*/
	private String friendId;
	/**操作行为：1-受邀好友关系，2-对方接受好友关系，-1-解除好友关系*/
	private int behavior;
	/**相关说明*/
	private String message;
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
	 * @return the behavior
	 */
	public int getBehavior() {
		return behavior;
	}
	/**
	 * @param behavior the behavior to set
	 */
	public void setBehavior(int behavior) {
		this.behavior = behavior;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
}
