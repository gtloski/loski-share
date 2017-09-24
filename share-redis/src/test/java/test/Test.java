package test;

import org.junit.Before;

import com.loski.share.jedis.RedisInit;
import com.loski.share.jedis.StringCache;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class Test {
	
	/**
	 * 客户端链接
	 */

	private Jedis jedis;

	/**
	 * 链接池
	 */

	private JedisPool jedisPool;
	
	private RedisInit redis;
	
	@Before
	public void before(){
		redis = new RedisInit();
	}
	
	@org.junit.Test
	public void test(){
		StringCache cache = new StringCache(redis.getJedis(), redis.getJedisPool());
//		cache.put("li", "guitian");
		System.out.println(cache.get("li"));
	}
}
