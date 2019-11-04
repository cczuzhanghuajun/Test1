package test8.test8;

import java.io.FileNotFoundException;

public class TestThread {

	public static void main(String[] args) throws FileNotFoundException {
		GetThread getThread = new GetThread();
		SetThread setThread = new SetThread();
		getThread.start();
		setThread.start();
	}

}
