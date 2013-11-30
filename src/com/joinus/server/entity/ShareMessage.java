package com.joinus.server.entity;

import java.util.Date;

/**
 * 活动分享消息<br>
 * FriendShareMessage or PlazaShareMessage
 * @author henrybit
 * @version 1.1
 * @since 2013-11-22
 */
public class ShareMessage {
	/**消息主键*/
	private long id;
	/**活动id*/
	private long aid;
	/**发消息的用户id*/
	private String shareUid;
	/**消息文本内容*/
	private String content;
	/**图片*/
	private String pic;
	/**分享时间：Date*/
	private Date shareTime;
	/**分享时间：Longs*/
	private Long shareTimeLong;
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
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
	 * @return the shareUid
	 */
	public String getShareUid() {
		return shareUid;
	}
	/**
	 * @param shareUid the shareUid to set
	 */
	public void setShareUid(String shareUid) {
		this.shareUid = shareUid;
	}
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * @return the pic
	 */
	public String getPic() {
		return pic;
	}
	/**
	 * @param pic the pic to set
	 */
	public void setPic(String pic) {
		this.pic = pic;
	}
	/**
	 * @return the shareTime
	 */
	public Date getShareTime() {
		return shareTime;
	}
	/**
	 * @param shareTime the shareTime to set
	 */
	public void setShareTime(Date shareTime) {
		this.shareTime = shareTime;
	}
	/**
	 * @return the shareTimeLong
	 */
	public Long getShareTimeLong() {
		return shareTimeLong;
	}
	/**
	 * @param shareTimeLong the shareTimeLong to set
	 */
	public void setShareTimeLong(Long shareTimeLong) {
		this.shareTimeLong = shareTimeLong;
	}
}
