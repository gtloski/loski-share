package com.loski.share.jedis;

import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class SetCache {

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
	 * @param jedisPool
	 *            链接池
	 */

	public SetCache(Jedis jedis, JedisPool jedisPool) {
		this.jedis = jedis;
		this.jedisPool = jedisPool;
	}

	/**
	 * 向set集合中加入元素
	 *
	 * @param key
	 *            set的名称
	 * @param value
	 *            插入的值
	 * @return 插入成功返回true,插入失败返回false
	 */

	public boolean put(String key, String value) {
		boolean flag = true;
		Jedis jedis = jedisPool.getResource();
		try {
			if (jedis != null) {
				jedis.sadd(key, value);
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
	 * 获得set集合的所有元素
	 *
	 * @param key
	 *            set的名称
	 * @return 获得成功返回true,获得失败返回null
	 */

	public Set<String> getAllSet(String key) {
		boolean flag = true;
		Jedis jedis = jedisPool.getResource();
		try {
			if (jedis != null) {
				return jedis.smembers(key);
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
	 * 删除set集合中的某个元素
	 *
	 * @param key
	 *            set的名称
	 * @param value
	 *            删除的值
	 * @return 删除成功返回true,删除失败返回false
	 */

	public boolean remove(String key, String value) {
		boolean flag = true;
		Jedis jedis = jedisPool.getResource();
		try {
			if (jedis != null) {
				jedis.srem(key, value);
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
	 * 设置set集合的有效时间
	 *
	 * @param key
	 *            set的名称
	 * @param second
	 *            set的有效时间,单位为秒
	 * @return 设置成功返回true,设置失败返回false
	 */

	public boolean put(String key, int second) {
		boolean flag = true;
		Jedis jedis = jedisPool.getResource();
		try {
			if (jedis != null) {
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
