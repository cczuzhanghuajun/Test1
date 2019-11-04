package test8.test8;

import java.io.FileNotFoundException;
import java.io.PrintStream;

import redis.clients.jedis.Jedis;

public class GetThread extends Thread {
	PrintStream out;
	Jedis jedis;
	GetThread() throws FileNotFoundException {
		out = new PrintStream("out.txt");
		jedis = new Jedis("localhost");
	}
	public void run() {
		long begin = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			String key = "lala";
			String gvalue = jedis.get(key);
			out.println(gvalue);
		}
		long end = System.currentTimeMillis();
		System.out.println(end-begin);
		jedis.close();
		out.close();
	}
}
