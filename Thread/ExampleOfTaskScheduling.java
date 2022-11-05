import java.util.Timer;
import java.util.TimerTask;
import java.awt.Frame;
/*
 * Task Scheduling :- Repeat a task after a specific interval
 */
class Thread1 extends TimerTask {
    @Override
    public void run() {
        Frame frame = new Frame();
        frame.setTitle("Hello");
        frame.setSize(300,300);
        frame.setVisible(true);
    }

}

public class ExampleOfTaskScheduling {
    public static void main(String[] args) {
        //to run this program
        Timer time = new Timer();
        time.schedule(new Thread1(), 5000);
        //time.scheduleAtFixedRate(new Thread1(), 5000, 5000);
    }
}
