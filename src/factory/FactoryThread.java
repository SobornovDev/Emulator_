package factory;

import java.io.File;

import listener.Listener;

public class FactoryThread extends Thread{
	String p1 = "";
	String p4 = "";
	String p4_doc = "";
	double p5;
	public FactoryThread(String name, String p1, String p4, String p4_doc, double p5) {
		super(name);
		this.p1 = p1;
		this.p4 = p4;
		this.p4_doc = p4_doc;
		this.p5 = p5;
	}
	
	
	
	public void run() {
		double pacing = (60000 / p5);
		FileFactory factory = new FileFactory();
		AbstractFile file = factory.getCreator(p4);
		AbstractFile file_doc = factory.getCreator(p4_doc);
		long startdebag = System.currentTimeMillis();
		long enddebag = System.currentTimeMillis() - startdebag;
		
		while (true) {
			double start = System.currentTimeMillis();

			file.create(p1);
			file_doc.create(p1);

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
			enddebag = System.currentTimeMillis() - startdebag;
			System.out.println("Time is " + enddebag);
		}
	}
}
