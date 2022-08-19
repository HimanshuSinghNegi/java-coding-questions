class Base {
    void show(){
        System.out.println("show method of base class");
    }
    void display(){
        System.out.println("display method of base class");
    }
}

class Child extends Base{
    void show(){
        System.out.println("show method of child class");
    }
    void display(){
        System.out.println("display method of child class");
    }
}

public class ExampleOfMthodNewInstance {
    public static void main(String[] args) {
        try{
            //making class type object for class which we will dynamically input at time of run
            Class c = Class.forName(args[0]);
            //here casting class type object into base class object because we don't know which class user will dynamically
            Base b = (Base)c.newInstance();
            b.show();
            b.display();
        }catch(Exception e){
            System.out.println(e.getLocalizedMessage());
        }
        //here calling functions but here the methods of class will call which we will send at the excetution time
        
    }
}

//to run the code 
// ---> compile the code :-like "javac ExampleOfMthodNewInstance.java"
// --->run the code :- like "java ExampleOfMthodNewInstance <class name / if inside package then use "pkg name.class name">"
