package com.joinus.server.entity;

/**
 * 活动更新通知<br>
 * user_plaza_notice or user_activity_notice
 * @author henrybit
 * @version 1.1
 * @since 2013-11-22
 */
public class ActivityNotice {
	private String uid;
	private long aid;
	private long sid;
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
	 * @return the aid
	 */
	public long getAid() {
		return aid;
	}
	/**
	 * @param aid the aid to set
	 */
	public void setAid(long aid) {
		this.aid = aid;
	}
	/**
	 * @return the sid
	 */
	public long getSid() {
		return sid;
	}
	/**
	 * @param sid the sid to set
	 */
	public void setSid(long sid) {
		this.sid = sid;
	}
}
