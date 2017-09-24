package com.loski.share.jedis;

import java.util.List;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class ListCache {

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

	public ListCache(Jedis jedis, JedisPool jedisPool) {
		this.jedis = jedis;
		this.jedisPool = jedisPool;
	}

	/**
	 * 在名称为key的list头添加一个值为value的元素
	 *
	 * @param key
	 *            list的名称
	 * @param value
	 *            插入的值
	 * @return 插入成功返回true,插入失败返回false
	 */

	public boolean lput(String key, String value) {
		boolean flag = true;
		Jedis jedis = jedisPool.getResource();
		try {
			if (jedis != null) {
				jedis.lpush(key, value);
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
	 * 在名称为key的list尾添加一个值为value的元素
	 *
	 * @param key
	 *            list的名称
	 * @param value
	 *            插入的值
	 * @return 插入成功返回true,插入失败返回false
	 */

	public boolean rput(String key, String value) {
		boolean flag = true;
		Jedis jedis = jedisPool.getResource();
		try {
			if (jedis != null) {
				jedis.rpush(key, value);
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
	 * 在名称为key的list中index位置的元素重新赋值为wvalue
	 *
	 * @param key
	 *            list的名称
	 * @param index
	 *            插入的下标
	 * @param value
	 *            插入的值
	 * @return 插入成功返回true,插入失败返回false
	 */

	public boolean put(String key, long index, String value) {
		boolean flag = true;
		Jedis jedis = jedisPool.getResource();
		try {
			if (jedis != null) {
				long length = jedis.llen(key);
				if (jedis.exists(key) && index <= length && index >= 1) {
					jedis.lset(key, index, value);
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

	/**
	 * 为List设置有效时间
	 *
	 * @param key
	 *            list的名称
	 * @param time
	 *            list的有效时间
	 * @return 设置成功返回true,设置失败返回false
	 */

	public boolean put(String key, int time) {
		boolean flag = true;
		Jedis jedis = jedisPool.getResource();
		try {
			if (jedis != null) {
				if (jedis.exists(key)) {
					jedis.expire(key, time);
				} else {
					flag = false;
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

	/**
	 * 返回名称为key的list中index位置的元素的值
	 *
	 * @param key
	 *            list的名称
	 * @param index
	 *            List的下标值
	 * @return 设置成功返回true,设置失败返回false
	 */

	public String get(String key, long index) {
		boolean flag = true;
		Jedis jedis = jedisPool.getResource();
		try {
			if (jedis != null) {
				return jedis.lindex(key, index);
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
	 * 获得start——end之间的元素值,start默认从1开始,当start=1,end=0时获取全部的元素
	 *
	 * @param key
	 *            list的名称
	 * @param start
	 *            开始下标
	 * @param end
	 *            结束下标
	 * @return 取得成功返回true,取得失败返回false
	 */

	public List<String> get(String key, long start, long end) {
		boolean flag = true;
		Jedis jedis = jedisPool.getResource();
		try {
			if (jedis != null) {
				return jedis.lrange(key, start, end);
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
	 * 删除名称为key的list中的首元素
	 *
	 * @param key
	 *            list的名称
	 * @return 删除成功返回true,删除失败返回false
	 */

	public boolean lremove(String key) {
		boolean flag = true;
		Jedis jedis = jedisPool.getResource();
		try {
			if (jedis != null) {
				jedis.lpop(key);
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
	 * 删除名称为key的list中的尾元素
	 *
	 * @param key
	 *            list的名称
	 * @return 删除成功返回true,删除失败返回false
	 */

	public boolean rremove(String key) {
		boolean flag = true;
		Jedis jedis = jedisPool.getResource();
		try {
			if (jedis != null) {
				jedis.rpop(key);
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
	 * 删除count个名称为key的List中值为value的元素 count为0,删除所有值为value的元素
	 * count>0从头到尾count个值为value的元素 count<0从尾到头count个值为value的元素
	 *
	 * @param key
	 *            list的名称
	 * @param count
	 *            删除情景标志
	 * @param value
	 *            删除的value
	 * @return
	 */

	public boolean remove(String key, long count, String value) {
		boolean flag = true;
		Jedis jedis = jedisPool.getResource();
		try {
			if (jedis != null) {
				jedis.lrem(key, count, value);
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
