package com.joinus.server.cache;

/**
 * 缓存管理类<br>
 * @author henrybit
 * @version 1.1
 * @since 2013-11-21
 */
public class CacheManager {
	
	private final static CacheManager cacheManager = new CacheManager();
	
	private CacheManager() {
	}
	
	/**
	 * 返回缓存管理实例-全局唯一<br>
	 * @return CacheManager
	 */
	public static CacheManager getInstance() {
		return cacheManager;
	}
	
}
