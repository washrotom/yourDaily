package maintenance.service;
 
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class FileMakeServiceImpl implements FileMakeService{

	@Override
	public void FileM(String fileName, String path, String content, String id) throws IOException {
					
					File file = new File(fileName);
					File dir = new File(path);
					System.out.println(path);
					dir.mkdirs();
					file.createNewFile(); //파일 생성
					
					//System.out.println("f"+file);
					//System.out.println("p"+path);
					
					SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
					Calendar time = Calendar.getInstance();
					String format_time1 = format1.format(time.getTime());
					//System.out.println(format_time1);
					content = content + " / " + format_time1;
					
					
					StackTraceElement[] a = new Throwable().getStackTrace();
					content = content + " / " + a[2].getFileName();
					
					content = content + " / " + id;
					
					//System.out.println(id);
					
					String File = path + "\\" + file;
					//파일이 존재하지 않으면 파일을 생성하고 Stream을 생성
					FileWriter fw = new FileWriter(File, true);// true : append data 누적
					PrintWriter pw = new PrintWriter(fw, true); //true : autoflush
					pw.println(content);
					pw.close();
				}

/*	@Override
	public void userFileM(String id, String path) throws IOException {
		// TODO Auto-generated method stub
		
		String idp = id + ".jsp";
		
		File file = new File(idp);
		File dir = new File(path);
		dir.mkdirs();
		file.createNewFile(); //파일 생성
		
		String File = path = "\\" + "user";
		
		String content = id + "님의 페이지입니다!";
		
		FileWriter fw = new FileWriter(File, false);// true : append data 누적
		PrintWriter pw = new PrintWriter(fw, true); //true : autoflush
		pw.println(content);
		pw.close();
		
	}*/

/* 사용안함.			
 * public void readFile(String fileName) throws IOException {
					FileReader fr=new FileReader(fileName);
					BufferedReader br=new BufferedReader(fr);
					String str = br.readLine();
					while (str != null) {
						System.out.println(str);
						str = br.readLine();
					}
					br.close();
				}

				public void copyFile(String fileName, String destName) throws IOException {
					File file = new File(destName);
					file.getParentFile().mkdirs();
					BufferedReader br=new BufferedReader(new FileReader(fileName));
					PrintWriter pw = new PrintWriter(new FileWriter(file, true), true);
					String str = br.readLine();
					while (str != null) {
						pw.println(str);
						str = br.readLine();
					}
					pw.close();
					br.close();
				}*/

	
			
	}