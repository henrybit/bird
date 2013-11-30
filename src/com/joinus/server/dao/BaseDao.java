package com.joinus.server.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.joinus.server.dao.db.DBManager;
import com.joinus.server.dao.db.MysqlDBManager;

/**
 * 基本DB操作类<br>
 * @author henrybit
 * @version 1.0
 * @since 2013-4-5
 */
public abstract class BaseDao<T> {
	/**DB管理实例*/
	protected final static DBManager dbManager = MysqlDBManager.getInstance();
	/***/
	protected static Connection connection = (Connection)dbManager.openConnection();
	
	/**
	 * 插入一批SQL数据<br>
	 * @param sqlList sql列表
	 * @return int-成功插入的记录条数
	 */
	public int insertAll(List<String> sqlList) {
		int successSqlNum = 0;
		if(connection == null) {
			connection = (Connection)dbManager.openConnection();
		}
		if(sqlList==null || sqlList.size()<=0)
			return 0;
		for(String sql : sqlList) {
			ResultSet rs = this.insert(sql);
			try {
				long id = rs.getLong(1);
				if(id > 0)
					successSqlNum++;
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return successSqlNum;
	}
	
	/***
	 * 执行更新操作<br>
	 * @param sql 需要执行的SQL语句
	 * @return boolean-如果SQL语句为空或者SQL语句不是UPDATE操作，则直接返回false，不执行SQL.
	 */
	public boolean update(String sql) {
		if(connection == null) {
			connection = (Connection)dbManager.openConnection();
		}
		if(sql==null || !sql.toLowerCase().startsWith("update"))
			return false;
		return (Boolean)dbManager.excuteSql(connection, sql, dbManager.EXCUTETYPE_UPDATE);
	}
	
	/***
	 * 执行插入操作<br>
	 * @param sql 需要执行的SQL语句
	 * @return ResultSet-如果SQL语句为空或者SQL语句不是INSERT操作，则直接返回主键ID为空，不执行SQL.
	 */
	public ResultSet insert(String sql) {
		if(connection == null) {
			connection = (Connection)dbManager.openConnection();
		}
		if(sql==null || !sql.toLowerCase().startsWith("insert"))
			return null;
		return (ResultSet)dbManager.excuteSql(connection, sql, dbManager.EXCUTETYPE_INSERT);
	}
	
	/***
	 * 执行插入操作(无主键)<br>
	 * @param sql 需要执行的SQL语句
	 * @return ResultSet-如果SQL语句为空或者SQL语句不是INSERT操作，则直接返回主键ID为空，不执行SQL.
	 */
	public boolean insertNotAutoIncreateMent(String sql) {
		if(connection == null) {
			connection = (Connection)dbManager.openConnection();
		}
		if(sql==null || !sql.toLowerCase().startsWith("insert"))
			return false;
		return (Boolean)dbManager.excuteSql(connection, sql, dbManager.EXCUTETYPE_INSERT_NOT_AUTOINCREATEMENT);
	}
	
	/**
	 * 执行删除操作<br>
	 * @param sql 需要执行的SQL语句
	 * @return boolean-如果SQL语句为空或者SQL语句不是DELETE操作，则直接返回false，不执行SQL.
	 */
	public boolean delete(String sql) {
		if(connection == null) {
			connection = (Connection)dbManager.openConnection();
		}
		if(sql==null || !sql.toLowerCase().startsWith("delete"))
			return false;
		return (Boolean)dbManager.excuteSql(connection, sql, dbManager.EXCUTETYPE_DELETE);
	}
	
	/**
	 * 执行查询操作<br>
	 * @param sql 需要执行的SQL语句
	 * @return ResultSet-如果SQL语句为空或者SQL语句不是QUERY操作，则直接返回NULL，不执行SQL.
	 */
	public ResultSet query(String sql) {
		ResultSet resultSet = null;
		if(connection == null) {
			connection = (Connection)dbManager.openConnection();
		}
		if(sql==null || !sql.toLowerCase().startsWith("select")) {
			System.out.println("sql is no valid!");
			return resultSet;
		}
		return (ResultSet)dbManager.excuteSql(connection, sql, dbManager.EXCUTETYPE_QUERY);
	}
	
	/**
	 * 解析获取到的SQL查询结果集，得到相应的数据对象集合<br>
	 * @param rs SQL查询结果集
	 * @return List 数据对象结果集合
	 * @throws SQLException - 当读取查询结果集时有可能会出现查询连接中结果集相关失败异常（注意捕获控制）<br>
	 */
	protected abstract List<T> parseResultSet(ResultSet rs) throws SQLException;
}
