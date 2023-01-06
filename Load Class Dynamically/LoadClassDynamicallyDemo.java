//Here we are loading class Dynamically into the memory
//By the help of class "class"  forName() method, which dynamically load class into the memory 
import java.util.Scanner;

//first  class
class A{
    static{
        System.out.println("A's Object created");
    }
    void show(){
        System.out.println("A's object formed");
    }
}

//second class
class B{
    static {
        System.out.println("B's object created");
    }
    void show(){
        System.out.println("B's object formed");
    }
}

public class LoadClassDynamicallyDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Which class's object you want to create .\n1. A (type capital A)\n2. B(type capital B)");
        System.out.print("Enter your choice:-");
        String str = sc.next();
        Class c = Class.forName(str);
        
        
    }
}
