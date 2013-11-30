package com.joinus.server.dao.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;


/**
 * MySql数据库管理类<br>
 * @author henrybit
 * @version 1.0
 * @since 2013-4-4
 */
public class MysqlDBManager implements DBManager {
	
	/**DB的URL*/
	private final static String DBURL = "jdbc:mysql://127.0.0.1:3306/joinUs";
	/**DB的用户名*/
	private final static String DBUSER = "root";
	/**DB的密码*/
	private final static String DBPASSWORD = "henrybit";
	/**DB连接池大小*/
	private final static int connectionPoolSize = 10;
	/**DB实例*/
	private final static MysqlDBManager dbManager = new MysqlDBManager();
	
	/**DB连接池:key-连接相应的信息，value-DB连接*/
	private static HashMap<ConnectionInfo, Connection> connectionPoolMap = new HashMap<ConnectionInfo, Connection>();
	
	/**DB连接池:key-DB连接，value-连接相应的信息*/
	private static HashMap<Connection, ConnectionInfo> connectionPoolValueMap = new HashMap<Connection, ConnectionInfo>();
	
	/**
	 * 禁止外部生成实例<br>
	 */
	private MysqlDBManager() {
	}
	
	/**
	 * 返回实例<br>
	 * @return MysqlDBManager
	 */
	public final static MysqlDBManager getInstance() {
		return dbManager;
	}
	
	/* (non-Javadoc)
	 * @see com.joinus.server.dao.db.DBManager#initDB()
	 */
	@Override
	public boolean initDB() {
		return initDB(DBURL, DBUSER, DBPASSWORD);
	}
	
	/* (non-Javadoc)
	 * @see com.joinus.server.dao.db.DBManager#initDB(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public synchronized boolean initDB(String url, String user, String password) {
		HashMap<ConnectionInfo, Connection> connectionPoolMapTemp = new HashMap<ConnectionInfo, Connection>();
		HashMap<Connection, ConnectionInfo> conneciontPoolValueMapTemp = new HashMap<Connection, ConnectionInfo>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			for(int i=0; i<connectionPoolSize; i++) {
				Connection connection = DriverManager.getConnection(url, user, password);
				long createTime = System.currentTimeMillis();
				int status = 1;
				ConnectionInfo connectionInfo = new ConnectionInfo();
				connectionInfo.connectionUpdateDate = createTime;
				connectionInfo.status = status;
				if(connection != null) {
					connectionPoolMapTemp.put(connectionInfo, connection);
					conneciontPoolValueMapTemp.put(connection, connectionInfo);
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		connectionPoolMap = connectionPoolMapTemp;
		connectionPoolValueMap = conneciontPoolValueMapTemp;
		return true;
	}

	/* (non-Javadoc)
	 * @see com.joinus.server.dao.db.DBManager#openConnection()
	 */
	@Override
	public synchronized Connection openConnection() {
		Connection connection = null;
		if(connectionPoolMap!=null) {
			Iterator<ConnectionInfo> iterator = connectionPoolMap.keySet().iterator();
			while(iterator.hasNext()) {
				ConnectionInfo connectionInfo = iterator.next();
				if(connectionInfo.status == 1) {
					connectionInfo.connectionUpdateDate = System.currentTimeMillis();
					connectionInfo.status = 2;
					connection = connectionPoolMap.get(connectionInfo);
				}
			}
		}
		return connection;
	}

	/* (non-Javadoc)
	 * @see com.joinus.server.dao.db.DBManager#closeConnection(java.lang.Object)
	 */
	@Override
	public synchronized void closeConnection(Object connection) {
		if(connection instanceof Connection) {
			Connection connect = (Connection)connection;
			ConnectionInfo connectionInfo = connectionPoolValueMap.get(connect);
			if(connectionInfo != null) {
				connectionInfo.status = 1;
				connectionInfo.connectionUpdateDate = System.currentTimeMillis();
			}
		}
	}

	/* (non-Javadoc)
	 * @see com.joinus.server.dao.db.DBManager#excuteSql(java.lang.String)
	 */
	@Override
	public Object excuteSql(Object connection, String sql, int excuteType) {
		System.out.println("excuteSql.........");
		Connection connect = (Connection)connection;
		try {
			if(connect == null)
				System.out.println("connect is null.....");
			Statement stateMent = connect.createStatement();
			switch(excuteType) {
			case EXCUTETYPE_QUERY:
				System.out.println(EXCUTETYPE_QUERY+":"+sql);
				return stateMent.executeQuery(sql);
			case EXCUTETYPE_INSERT:
				stateMent.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
				return stateMent.getGeneratedKeys();
			case EXCUTETYPE_INSERT_NOT_AUTOINCREATEMENT:
				return stateMent.execute(sql);
			case EXCUTETYPE_UPDATE:
				return stateMent.executeUpdate(sql);
			case EXCUTETYPE_DELETE:
				return stateMent.execute(sql);
			default:break;
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 数据库连接的信息<br>
	 * @author henrybit
	 * @version 1.0
	 * @since 2013-4-5
	 */
	class ConnectionInfo {
		/**连接更新时间*/
		private long connectionUpdateDate;
		/**连接的状态:1-未使用，2－已占用*/
		private int status = 1;
	}
}
