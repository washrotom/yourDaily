import java.util.Timer;
import java.util.TimerTask;

public class timer {
	public static void main(String[] args) {
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("momomo");
			}
		};
		timer.schedule(task, 1000);
		
		
	}

}
