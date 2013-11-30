package com.joinus.server.constant;

/**
 * 活动相关常量状态<br>
 * @author henrybit
 * @version 1.0
 * @since 2013-4-5
 */
public class ActivityConstant {
	/**1-购物*/
	public final static int ACTIVITY_TAG_SHOPPING = 1;
	/**2-运动*/
	public final static int ACTIVITY_TAG_ACTIVE = 2;
	/**3-会议*/
	public final static int ACTIVITY_TAG_ACTIVITY = 3;
	/**4-聚餐*/
	public final static int ACTIVITY_TAG_EATING = 4;
	/**5-游戏*/
	public final static int ACTIVITY_TAG_GAME = 5;
	
	/**1-活动预备*/
	public final static int ACTIVITY_STATUS_PREPARE = 1;
	/**2-活动进行中*/
	public final static int ACTIVITY_STATUS_ACTIVING = 2;
	/**3-活动完成*/
	public final static int ACTIVITY_STATUS_FINISH = 3;
	/**4-活动撤销*/
	public final static int ACTIVITY_STATUS_CANCEL = 4;
	
	/**1-男*/
	public final static int SEX_MALE = 1;
	/**2-女*/
	public final static int SEX_FEMALE = 2;
	/**3-人妖*/
	public final static int SEX_LADYBOY = 3;
	
	/**1-邀请中*/
	public final static int USERRELATION_STATUS_STRANGER = 1;
	/**2-好友*/
	public final static int USERRELATION_STATUS_FRIEND = 2;
	/**3-推荐好友*/
	public final static int USERRELATION_STATUS_MAYBE = 3;
	
	/**1-有效*/
	public final static int USERACTIVITYJOIN_STATUS_ENABLE = 1;
	/**-1-无效*/
	public final static int USERACTIVITYJOIN_STATUS_DISABLE = -1;
}
