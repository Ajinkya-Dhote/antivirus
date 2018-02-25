package in.himanshudhote;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class FileScanner {
	FileScanner() {}
	
	void startScanning(Path dir) {
		System.out.println(String.format("Readinding file %s", dir.toString()));
		
		try {
			WatchService watcher = FileSystems.getDefault().newWatchService();
		    WatchKey key = dir.register(watcher,
		    		StandardWatchEventKinds.ENTRY_CREATE ,
		    		StandardWatchEventKinds.ENTRY_DELETE,
		    		StandardWatchEventKinds.ENTRY_MODIFY);

	        while ((key = watcher.take()) != null) {
	            for (WatchEvent<?> event : key.pollEvents()) {
	                System.out.println(
	                  "Event kind:" + event.kind() 
	                    + ". File affected: " + event.context() + ".");
	            }
	            key.reset();
	        }
	        
		} catch (IOException | InterruptedException x) {
		    System.err.println(x);
		}
	}

}
