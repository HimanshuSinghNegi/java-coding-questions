class Bank{
    int amount;
    int flag=0;
   synchronized void submit(int amount){
     flag=1;
     this.amount=amount;
     notify();
   }

   synchronized void withDraw(int withDrawAmount){
       if(flag==0){
           try{
           wait();
           }catch(InterruptedException e){
               e.printStackTrace();
           }
       }
       System.out.println("Before withdrwal="+amount);
       System.out.println("After withdrawal amount "+(amount-withDrawAmount));

   }
}

class Thread12 implements Runnable{
    Bank bank;
    Thread12(Bank bank){
        this.bank=bank;
    }

    public void run(){
        
        bank.submit(1200);
        
    }
}

class Thread123 implements Runnable{
    Bank bank;
    Thread123(Bank bank){
        this.bank=bank;
    }

    public void run(){
        
        bank.withDraw(233);
        
    }
}




public class InterThreadCommunication {
    
    
    public static void main(String[] args) {
        Bank bank = new Bank();
        Thread12 t1 = new Thread12(bank);
        Thread123 t2 = new Thread123(bank);
        Thread thread = new Thread(t1);
        Thread thread2 = new Thread(t2);
        thread2.start();
        thread.start();
       
    }


}
