package com.joinus.server.dao.db;

/**
 * 数据库连接，查询，关闭等操作管理<br>
 * @author henrybit
 * @version 1.0
 * @since 2013-4-4
 */
public interface DBManager {
	
	/**查询操作*/
	public final static int EXCUTETYPE_QUERY = 1;
	/**插入操作（普通）*/
	public final static int EXCUTETYPE_INSERT = 2;
	/**插入操作（无主键插入操作）*/
	public final static int EXCUTETYPE_INSERT_NOT_AUTOINCREATEMENT = 5;
	/**更新操作*/
	public final static int EXCUTETYPE_UPDATE = 3;
	/**删除操作*/
	public final static int EXCUTETYPE_DELETE = 4;
	/**
	 * 初始化DB连接环境<br>
	 * @param url DB连接地址
	 * @param user DB连接用户名
	 * @param password DB连接密码
	 * @return boolean-如果初始化失败，返回false;否则返回true.
	 */
	boolean initDB(String url, String user, String password);
	
	/**
	 * 初始化DB连接环境<br>
	 * @return boolean-如果初始化失败，返回false;否则返回true.
	 */
	boolean initDB();
	
	/**
	 * 创建一个数据库连接<br>
	 * @return Object-返回一个数据库连接
	 */
	Object openConnection();
	
	/**
	 * 关闭一个制定的数据库连接<br>
	 * @param connection 需要关闭的数据库连接
	 */
	void closeConnection(Object connection);
	
	/**
	 * 执行一条SQL语句<br>
	 * @param connection 执行SQL的数据库连接
	 * @param sql 需要执行的SQL语句
	 * @param excuteType 需要执行的操作类型：1-query,2-insert,3-update,4-delete
	 * @return Object-执行SQL返回的结果
	 */
	Object excuteSql(Object connection, String sql, int excuteType);
}
