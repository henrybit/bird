package com.joinus.server.entity;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * 活动信息<br>
 * @author henrybit
 * @version 1.0
 * @since 2013-4-5
 * @updateDate 2013/11/18
 */
public class Activity {
	/**活动ID*/
	private long id;
	/**活动名*/
	private String name;
	/**活动类型:1-购物,2-运动,3-会议,4-聚餐,5-游戏*/
	private int tag;
	/**活动内容*/
	private String content;
	/**活动发起者*/
	private String createUserId;
	/**活动参加者列表*/
	private String joinUsersId;
	/**活动参加者ID列表*/
	private Set<String> joinUserSet;
	/**活动状态:1-活动预备,2-活动进行中,3-活动完成,4-活动撤销*/
	private int status;
	/**位置信息：纬度*/
	private String latitude;
	/**位置信息：经度*/
	private String longitude;
	/**活动地址*/
	private String address;
	/**活动开始时间:LONG*/
	private long startTimeLong;
	/**活动开始时间:DATE*/
	private Date startTime;
	/**活动图片地址*/
	private String headPic;
	/**活动公开状态：1-所有人公开，2-同城公开，0-好友可见，-1-私人*/
	private int pubStatus;
	/**活动创建时间:LONG*/
	private long createTimeLong;
	/**活动创建时间:DATE*/
	private Date createTime;
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
	 * @return the tag
	 */
	public int getTag() {
		return tag;
	}
	/**
	 * @param tag the tag to set
	 */
	public void setTag(int tag) {
		this.tag = tag;
	}
	/**
	 * @return the startTimeLong
	 */
	public long getStartTimeLong() {
		return startTimeLong;
	}
	/**
	 * @param startTimeLong the startTimeLong to set
	 */
	public void setStartTimeLong(long startTimeLong) {
		this.startTimeLong = startTimeLong;
	}
	/**
	 * @return the startTime
	 */
	public Date getStartTime() {
		return startTime;
	}
	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
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
	 * @return the createUserId
	 */
	public String getCreateUserId() {
		return createUserId;
	}
	/**
	 * @param createUserId the createUserId to set
	 */
	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}
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
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the createTimeLong
	 */
	public long getCreateTimeLong() {
		return createTimeLong;
	}
	/**
	 * @param createTimeLong the createTimeLong to set
	 */
	public void setCreateTimeLong(long createTimeLong) {
		this.createTimeLong = createTimeLong;
	}
	/**
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the joinUsersId
	 */
	public String getJoinUsersId() {
		return joinUsersId;
	}
	/**
	 * @param joinUsersId the joinUsersId to set
	 */
	public void setJoinUsersId(String joinUsersId) {
		this.joinUsersId = joinUsersId;
	}
	/**
	 * @return the latitude
	 */
	public String getLatitude() {
		return latitude;
	}
	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	/**
	 * @return the longitude
	 */
	public String getLongitude() {
		return longitude;
	}
	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	/**
	 * @return the headPic
	 */
	public String getHeadPic() {
		return headPic;
	}
	/**
	 * @param headPic the headPic to set
	 */
	public void setHeadPic(String headPic) {
		this.headPic = headPic;
	}
	/**
	 * @return the joinUserSet
	 */
	public Set<String> getJoinUserSet() {
		return joinUserSet;
	}
	/**
	 * @param joinUserSet the joinUserSet to set
	 */
	public void setJoinUserSet(Set<String> joinUserSet) {
		this.joinUserSet = joinUserSet;
	}
	/**
	 * @return the pubStatus
	 */
	public int getPubStatus() {
		return pubStatus;
	}
	/**
	 * @param pubStatus the pubStatus to set
	 */
	public void setPubStatus(int pubStatus) {
		this.pubStatus = pubStatus;
	}
	
}
