package test8.test8;

import java.io.FileNotFoundException;
import java.io.PrintStream;

import redis.clients.jedis.Jedis;

public class Test {

	public static void main(String[] args) throws FileNotFoundException {
		PrintStream out = new PrintStream("out.txt");
		Jedis jedis = new Jedis("localhost");
		long begin = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			String key = "lala";
			String value = "aa" + i;
			jedis.getSet(key, value);
			String gvalue = jedis.get(key);
			out.println(gvalue);
		}
		long end = System.currentTimeMillis();
		System.out.println(end-begin);
		//System.out.println(value);
		jedis.close();
		out.close();

	}

}
