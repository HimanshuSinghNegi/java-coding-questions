import java.beans.IntrospectionException;

//so here we have created a example which sequencely run all the thread through the help of Join()

class Thread1 extends Thread{
    Thread1(String name){
        super(name);
    }
    public void run(){
        for(int i=1;i<=5;i++){
            System.out.println(Thread.currentThread().getName());
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

class Thread2 extends Thread{
    Thread1 t1;
    Thread2(String name,Thread1 t1){
        super(name);
        this.t1=t1;
    }
    public void run(){
        try{
            
            t1.join(); //but here thread 2 joined thread 1 means thread 2 will give thread 1 to run first
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        for(int i=1;i<=5;i++){
            System.out.println(Thread.currentThread().getName());
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

class Thread3 extends Thread{
    
    Thread2 t2;
    Thread3(String name,Thread2 t2){
        super(name);
        this.t2=t2;
    }
    public void run(){
        try{
            
            t2.join();// but here thread 3 joined thread 2 means now thread 3 will give thread 2 to run first
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        for(int i=1;i<=5;i++){
            System.out.println(Thread.currentThread().getName());
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}



public class ExampleOfThreadJoinMethod {
    public static void main(String[] args) {
        Thread1 t1 = new Thread1("First");
        Thread2 t2 = new Thread2("Sec",t1);
        Thread3 t3 = new Thread3("Third" ,t2);

       
        t1.start();
        t2.start();
        t3.start();
       
        try{
            t3.join(); //here main method joined thread 3 so thread 3 or any other can run
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        for(int i=1;i<=5;i++){
            System.out.println(Thread.currentThread().getName());
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }

    }
}
