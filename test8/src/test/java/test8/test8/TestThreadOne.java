package test8.test8;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class TestThreadOne {

	public static void main(String[] args) throws FileNotFoundException {
		PrintStream out = new PrintStream("out.txt");
		for (int i = 0; i < 1000; i++) {
			SetThreadOne setThreadOne = new SetThreadOne(i);
			GetThreadOne getThreadOne = new GetThreadOne(out);
			setThreadOne.start();
			getThreadOne.start();
		}
	}

}
