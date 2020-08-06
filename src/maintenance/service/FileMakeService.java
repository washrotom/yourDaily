package maintenance.service;

import java.io.IOException;

public interface FileMakeService {
	public void FileM(String fileName, String path, String content, String id) throws IOException;
	//public void userFileM(String id, String path) throws IOException;
}
