//example of implement inteface without using "implements" keyword
// interface which contains two abstract method
interface KK{
    void show();
    void disp();
}

public class ImplementInterfaceWithoutUsingImplementsKeyword {
    public static void main(String[] args) {
       //by this we can implement interface without using "implements" keyword;
        KK k= new KK(){ //here we are not creating object of interface we can't create object of interface
        //here we are creating a Anonymous class where "kk()" is parent class for Anonymous class and "KK k" is reference
        //varibale of interface
            public void show(){
                System.out.println("show method override");
            }
            public void disp(){
                System.out.println("disp override");
            }
        };
        k.show();
    }
}




    

