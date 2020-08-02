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
					file.createNewFile(); //���� ����
					
					//System.out.println("f"+file);
					//System.out.println("p"+path);
					
					SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
					Calendar time = Calendar.getInstance();
					String format_time1 = format1.format(time.getTime());
					System.out.println(format_time1);
					content = content + " / " + format_time1;
					
					
					StackTraceElement[] a = new Throwable().getStackTrace();
					content = content + " / " + a[2].getFileName();
					
					content = content + " / " + id;
					
					System.out.println(id);
					
					String File = path + "\\" + file;
					//������ �������� ������ ������ �����ϰ� Stream�� ����
					FileWriter fw = new FileWriter(File, true);// true : append data ����
					PrintWriter pw = new PrintWriter(fw, true); //true : autoflush
					pw.println(content);
					pw.close();
				}

/* ������.			
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