package test8.test8;

import redis.clients.jedis.Jedis;

public class SetThreadOne extends Thread {
	Jedis jedis;
	int index;
	SetThreadOne(int index){
		this.jedis = new Jedis("localhost");
		this.index = index;
	}
	public void run() {
		String key = "lala";
		String value = "aa" + index;
		jedis.set(key, value);
		jedis.close();
	}
}
