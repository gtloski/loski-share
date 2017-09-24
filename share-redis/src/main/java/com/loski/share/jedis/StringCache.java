package com.loski.share.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class StringCache {

	/**
	 * 客户端链接
	 */

	private Jedis jedis;

	/**
	 * 链接池
	 */

	private JedisPool jedisPool;

	/**
	 * 构造函数
	 *
	 * @param jedis
	 *            链接线
	 * @param jedispool
	 *            链接池
	 */
	public StringCache(Jedis jedis, JedisPool jedispool) {
		this.jedis = jedis;
		this.jedisPool = jedispool;
	}

	/**
	 * 向名称为key的String中插入元素
	 *
	 * @param key
	 *            String的名称
	 * @param value
	 *            插入的值
	 * @return 插入成功返回true,插入失败返回false
	 */

	public boolean put(String key, String value) {
		boolean flag = true;
		Jedis jedis = jedisPool.getResource();
		try {
			if (jedis != null) {
				jedis.set(key, value);
			}
		} catch (Exception e) {
			flag = false;
			e.printStackTrace();
		} finally {
			if (flag) {
				jedis.close();
				return true;
			} else {
				jedisPool.close();
			}
		}
		return false;
	}

	/**
	 * 获得名称为key的元素的值
	 *
	 * @param key
	 *            String的名称
	 * @return 执行成功返回value,执行失败返回null
	 */

	public String get(String key) {
		boolean flag = true;
		Jedis jedis = jedisPool.getResource();
		try {
			if (jedis != null) {
				return jedis.get(key);
			}
		} catch (Exception e) {
			flag = false;
			e.printStackTrace();
		} finally {
			if (flag) {
				jedis.close();
			} else {
				jedisPool.close();
			}
		}
		return null;
	}

	/**
	 * 删除名称为key的String元素
	 * 
	 * @param key
	 *            String的名称
	 * @return 删除成功返回true,删除失败,返回false
	 */

	public boolean remove(String key) {
		boolean flag = true;
		Jedis jedis = jedisPool.getResource();
		try {
			if (jedis != null) {
				jedis.del(key);
			}
		} catch (Exception e) {
			flag = false;
			e.printStackTrace();
		} finally {
			if (flag) {
				jedis.close();
				return true;
			} else {
				jedisPool.close();
			}
		}
		return false;
	}

	/**
	 * 插入元素,并且设置元素的有效时间
	 *
	 * @param key
	 *            String的名称
	 * @param value
	 *            插入的值
	 * @param second
	 *            有效时间,单位为秒;
	 * @return 执行成功返回true,执行失败返回false
	 */

	public boolean put(String key, String value, int second) {
		boolean flag = true;
		Jedis jedis = jedisPool.getResource();
		try {
			if (jedis != null) {
				jedis.set(key, value);
				if (jedis.exists(key)) {
					jedis.expire(key, second);
				}
			}
		} catch (Exception e) {
			flag = false;
			e.printStackTrace();
		} finally {
			if (flag) {
				jedis.close();
				return true;
			} else {
				jedisPool.close();
			}
		}
		return false;
	}
}
