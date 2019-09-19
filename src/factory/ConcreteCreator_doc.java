package factory;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import db_connect.FilesServlet;
import holders.LogFileHolder;

public class ConcreteCreator_doc extends AbstractFile {

	private byte[] buffer;
	
	SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
	SimpleDateFormat sdf_db = 
			new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Date time = new Date();
	
	ConcreteCreator_doc(byte[] buffer) {
		this.buffer = buffer;
	}

	@Override
	public void create(String path) {
			
		String datetime = sdf_db.format(time);
		String filename = "doc_" + sdf.format(time) + ".doc";
		try (FileOutputStream fos = new FileOutputStream(path + filename)) {
			fos.write(buffer, 0, buffer.length);
			LogFileHolder logFileHolder = new LogFileHolder(datetime, filename, "in");
			FilesServlet filesServlet = new FilesServlet(logFileHolder.getDatetime(), logFileHolder.getFilename(), logFileHolder.getInout());
			FilesServlet.insert();
		}

		catch (IOException ex) {
			System.out.println(ex.getMessage());
		}

	}

}
