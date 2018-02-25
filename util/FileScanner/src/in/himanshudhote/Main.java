package in.himanshudhote;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Properties prop = new Properties();
		
		try(
				InputStream input = new FileInputStream("config.properties");
		) {
			prop.load(input);
		}
			
		Path p = Paths.get(prop.getProperty("dir"));
		FileScanner fc = new FileScanner();
		fc.startScanning(p);
	}

}
