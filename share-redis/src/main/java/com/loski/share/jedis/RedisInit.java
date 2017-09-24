package com.loski.share.jedis;

import com.loski.share.common.utils.PropertiesUtils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisInit {

	private Jedis jedis = null;

	private JedisPool jedisPool = null;

	protected static String propertiesPath = "jedis.properties";

	protected static String ip = PropertiesUtils.getStringProperties(propertiesPath, "jedis.ip");

	protected int port = Integer.parseInt(PropertiesUtils.getStringProperties(propertiesPath, "jedis.port"));

	protected long maxWaitMillis = Long
			.parseLong(PropertiesUtils.getStringProperties(propertiesPath, "jedis.MaxWaitMillis"));

	protected int maxIdle = Integer.parseInt(PropertiesUtils.getStringProperties(propertiesPath, "jedis.MaxIdle"));

	protected boolean testOnBorrow = Boolean
			.parseBoolean(PropertiesUtils.getStringProperties(propertiesPath, "jedis.TestOnBorrow"));

	public RedisInit() {
		initialPool();
		jedis = jedisPool.getResource();
	}

	/**
	 * 链接池初始化
	 */

	private void initialPool() {
		// 池基本配置
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxIdle(30);
		config.setMaxWaitMillis(1000l);
		config.setTestOnBorrow(false);
		jedisPool = new JedisPool(config, ip, 6379);
	}

	/**
	 * 获得链接线程
	 * 
	 * @return
	 */

	public Jedis getJedis() {
		return jedis;
	}

	/**
	 * 获得链接池
	 * 
	 * @return
	 */

	public JedisPool getJedisPool() {
		return jedisPool;
	}

	public static void main(String args[]) {
		System.out.println(ip);
	}
}
