package in.himanshudhote;

import java.nio.file.Path;

public class FileScanner {
	FileScanner() {}
	
	void startScanning(Path dir) {
		System.out.println(String.format("Readinding file %s", dir.toString()));
	}

}
