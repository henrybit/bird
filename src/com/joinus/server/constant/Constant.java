package com.joinus.server.constant;

/**
 * 常用常量<br>
 * @author henrybit
 * @version 1.0
 * @since 2013-4-5
 */
public class Constant {
	/**时间格式：yyyy-MM-dd HH:mm:ss*/
	public final static String DATE_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
	/**时间格式：yyyy-MM-dd*/
	public final static String DATE_YYYY_MM_DD = "yyyy-MM-dd";
	
	/**创建新用户成功:1*/
	public final static int CREATENEWUSER_STATUS_SUCCESS = 1;
	/**创建新用户失败:用户已存在*/
	public final static int CREATENEWUSER_STATUS_EXSIT = 2;
	/**创建新用户失败:-1*/
	public final static int CREATENEWUSER_STATUS_FAILED = -1;
	/**创建新用户:初始化*/
	public final static int CREATENEWUSER_STATUS_INIT = 0;
	
	/**创建新活动成功:1*/
	public final static int CREATENEWMEETING_STATUS_SUCCESS = 1;
	/**创建新活动失败:-1*/
	public final static int CREATENEWMEETING_STATUS_FAILED = -1;
	
	/**加入新活动成功:1*/
	public final static int AGREEMEETING_STATUS_SUCCESS = 1;
	/**加入新活动失败:1*/
	public final static int AGREEMEETING_STATUS_FAILED = -1;
	
	/**1-邀请成为好友*/
	public final static int USERRELATION_STATUS_INVITE = 1;
	/**2-好友*/
	public final static int USERRELATION_STATUS_FRIEND = 2;
	/**3-推荐可能好友*/
	public final static int USERRELATION_STATUS_RECOMMENDFRIEND = 3;
	/**4-陌生人*/
	public final static int USERRELATION_STATUS_STRANGER = 4;
}
