package com.loski.share.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class HashCache {

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

	public HashCache(Jedis jedis, JedisPool jedisPool) {
		this.jedis = jedis;
		this.jedisPool = jedisPool;
	}

	/**
	 * 向名称为key的hash中添加元素fied————value
	 *
	 * @param key
	 *            标示创建的hash
	 * @param field
	 *            hash中的key
	 * @param value
	 *            与field对应的value值
	 * @return 插入成功返回true.插入失败返回fasle
	 */

	public boolean put(String key, String field, String value) {
		boolean flag = true;
		Jedis jedis = jedisPool.getResource();
		try {
			if (jedis != null) {
				jedis.hset(key, field, value);
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
	 * 返回名称为key的hash中field对应的value
	 *
	 * @param key
	 *            标示一个hash表
	 * @param field
	 *            hash表中的key
	 * @return 找到返回value,找不到返回false
	 */

	public String get(String key, String field) {
		boolean flag = true;
		Jedis jedis = jedisPool.getResource();
		try {
			if (jedis != null) {
				return jedis.hget(key, field);
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
	 * 删除名称为key的hash中键为value的值
	 *
	 * @param key
	 *            标示hash的名称
	 * @param field
	 *            hash的键值
	 * @return 删除成功返回true,删除失败返回false
	 */

	public boolean remove(String key, String field) {
		boolean flag = true;
		Jedis jedis = jedisPool.getResource();
		try {
			if (jedis != null) {
				jedis.hdel(key, field);
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
	 * 为名称为key的Hash表设置有效时间
	 *
	 * @param key
	 *            标示hash表
	 * @param second
	 *            有效时间,秒为单位
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
