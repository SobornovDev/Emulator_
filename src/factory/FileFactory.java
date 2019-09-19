package factory;

import java.io.FileInputStream;
import java.io.IOException;

public class FileFactory {

	public AbstractFile getCreator(String path) {
		AbstractFile filecreator = null;
		byte[] buffer = null;
		try (FileInputStream fin = new FileInputStream(path)) {
			buffer = new byte[fin.available()];
			fin.read(buffer, 0, buffer.length);
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
		int index = path.indexOf(".");
		String p3 = path.substring(index);

		if (buffer != null) {
			switch (p3) {
			case ".txt": {
				filecreator = new ConcreteCreator(buffer);
				break;
			}
			case ".doc": {
				filecreator = new ConcreteCreator_doc(buffer);
				break;
			}
			default:
				System.out.println("Не существует подходящей маски файла");
			}
		} else {
			System.out.println("Файл пустой");
		}

		return filecreator;
	}

}
