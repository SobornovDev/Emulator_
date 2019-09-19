package listener;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import db_connect.FilesServlet;
import holders.LogFileHolder;

public class Listener {

	String path = "";
	SimpleDateFormat sdf_db = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Date time = new Date();

	public Listener() {

	}

	public void getList(String path) {

		File file = new File(path);

		if (file.isDirectory()) {

			File[] listFiles;
			listFiles = file.listFiles();
			if (listFiles != null) {
				String datetime = sdf_db.format(time);
				for (File i : listFiles) {

					LogFileHolder logFileHolder = new LogFileHolder(datetime, i.getName(), "out");
					FilesServlet filesServlet = new FilesServlet(logFileHolder.getDatetime(),
							logFileHolder.getFilename(), logFileHolder.getInout());
					FilesServlet.insert();
					i.delete();

				}
			}
			
		} else {
			System.out.println("Некорректный путь к FOLDER_OUT");
		}

	}

}
