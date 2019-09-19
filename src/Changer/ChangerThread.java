package Changer;

import listener.Listener;

public class ChangerThread extends Thread{
	
	String p1 = "";
	String p2 = "";
	
	public ChangerThread(String name, String p1, String p2) {
		super(name);
		this.p1 = p1;
		this.p2 = p2;
	}
	
	public void run() {
		
		Changer changer = new Changer();
		while(true) {
			changer.changerListener(p1,p2);			
		}
	}

}
