package test8.test8;


import redis.clients.jedis.Jedis;

public class SetThread extends Thread {
	Jedis jedis;
	SetThread(){
		this.jedis = new Jedis("localhost");
	}
	public void run() {
		long begin = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			String key = "lala";
			String value = "aa" + i;
			jedis.set(key, value);
		}
		long end = System.currentTimeMillis();
		System.out.println(end-begin);
		jedis.close();
	}
}
