package Changer;

import java.io.File;

import db_connect.FilesServlet;
import holders.LogFileHolder;

public class Changer {
	
	String p1 = "";
	String p2 = "";
	
	public Changer () {

	}
	
	public void changerListener (String p1, String p2) {
		File file = new File(p1);

		if (file.isDirectory()) {

			File[] listFiles;
			listFiles = file.listFiles();
			if (listFiles != null) {
				
				for (File i : listFiles) {
					
					File i_changed = SomeChange(i);
					i_changed.renameTo(new File(p2 + i_changed.getName()));

				}
			}
			
		} else {
			System.out.println("Некорректный путь к FOLDER_IN");
		}
	}
	
	private File SomeChange(File f) {
		// Сюда можно поместить некоторую логику обработки файла
		return f;
	}
	
}
