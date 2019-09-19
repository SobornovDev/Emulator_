package listener;

import java.io.File;

public class ListenerThread extends Thread{
	
	String p2 = "";
	double p7;
	public ListenerThread(String name, String p2, double p7) {
		super(name);
		this.p2 = p2;
		this.p7 = p7;
	}
	
	public void run() {
		double pacing = (60000 / p7);
		Listener listener = new Listener();
		while(true) {
			double start = System.currentTimeMillis();
			listener.getList(p2);
			double stop = System.currentTimeMillis() - start;
			if (stop < pacing)
				try {
					Thread.sleep((long)(pacing - stop));
				} catch (InterruptedException e) {					
					e.printStackTrace();
				}
			else
				try {
					Thread.sleep(0);
				} catch (InterruptedException e) {					
					e.printStackTrace();
				}
		}
	}

}
