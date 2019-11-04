package test8.test8;


import java.io.PrintStream;

import redis.clients.jedis.Jedis;

public class GetThreadOne extends Thread {
	PrintStream out;
	Jedis jedis;
	static int n = 0;
	static long begin = System.currentTimeMillis();
	GetThreadOne(PrintStream out){
		this.out = out;
		jedis = new Jedis("localhost");
	}
	public void run() {
		String key = "lala";
		String gvalue = jedis.get(key);
		out.println(gvalue);
		long end = System.currentTimeMillis();
		
		jedis.close();
		n++;
		if (n >= 999) {
			out.println(end-begin);
			out.close();
		}
	}
}
