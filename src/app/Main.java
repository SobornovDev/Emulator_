package app;

import java.io.File;
import java.math.BigInteger;

import Changer.ChangerThread;
import factory.AbstractFile;
import factory.FactoryThread;
import factory.FileFactory;
import listener.Listener;
import listener.ListenerThread;

public class Main {

	public static void main(String args[]) throws InterruptedException {

		String p1 = "C://dev//Emulator//FOLDER_IN//";

		String p2 = "C://dev//Emulator//FOLDER_OUT//";

		// P3 маска для создаваемых эмулятором файлов находится в классе FileFactory. В
		// качестве примера использую две маски - txt и doc

		String p4 = "C://dev//Emulator//REF//file_origin.txt";

		String p4_doc = "C://dev//Emulator//REF//file_origin.doc";

		double p5 = 20;
		double p7 = 10;

		new FactoryThread("FactoryThread", p1, p4, p4_doc, p5).start();
		
		new ListenerThread("ListenerThread", p2, p7).start();
		
		new ChangerThread("ChangerThread",p1,p2).start();

		
		
		
	}

}
