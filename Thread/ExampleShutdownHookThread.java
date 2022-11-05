import java.io.IOException;
import java.util.TimerTask;
/*Note: ShutdownHook Thread is a thread which 
* execute a block of code even JVM gets terminated
  */
class Thread1 extends Thread{
  public void run(){
    System.out.println(Thread.currentThread().getName());
    System.out.println("hi");
  }    
}

public class ExampleShutdownHookThread {
public static void main(String[] args) {
    Thread1 t1 = new Thread1();

    //now create object of JVM
    Runtime runtime = Runtime.getRuntime();
 /*
  * BY runtime you can also open other application by
  exec() of this class
  */
    // try{
    // runtime.exec("C:/Program Files/Sublime Text/sublime_text.exe");
    // }
    // catch(IOException e){
    //     e.printStackTrace();
    // }
    //here creating thread1 to shutdownHook Thread
    runtime.addShutdownHook(t1);
    /*  here i am forcefully terminating program 
     * but because we have made thread1 to shutdownHookThread
     * so this thread will run definately
     * only small code can run by the help of ShutdownHook Thread
    */
    System.exit(0);

    try{
        Thread.sleep(1000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }

    //here i am staring thread1 which is now shutdownHook thread 
    t1.start();

}    
}
