package com.joinus.server.entity;

import java.util.Date;
import java.util.Set;

/**
 * 广场活动类<br>
 * @author henrybit
 * @version 1.1
 * @since 2013-11-18
 */
public class PlazaActivity {
	/**广场活动id*/
	private long id;
	/**广场活动名*/
	private String name;
	/**广场活动类别*/
	private int tag;
	/**活动类型*/
	private String content;
	/**活动创建者*/
	private String createUserId;
	/**活动参加者ID集合*/
	private String joinUsersId;
	/**活动用户集合*/
	private Set<String> joinUserSet;
	/**位置信息：纬度*/
	private String latitude;
	/**位置信息：经度*/
	private String longitude;
	/**活动地点描述*/
	private String address;
	/**活动开始时间:Date*/
	private Date startTime;
	/**活动开始时间:Long*/
	private long startTimeLong;
	/**活动配图*/
	private String headPic;
	/**活动显示大图*/
	private String bigPic;
	/**活动显示序列*/
	private int seq;
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
	 * @return the bigPic
	 */
	public String getBigPic() {
		return bigPic;
	}
	/**
	 * @param bigPic the bigPic to set
	 */
	public void setBigPic(String bigPic) {
		this.bigPic = bigPic;
	}
	/**
	 * @return the seq
	 */
	public int getSeq() {
		return seq;
	}
	/**
	 * @param seq the seq to set
	 */
	public void setSeq(int seq) {
		this.seq = seq;
	}
}
