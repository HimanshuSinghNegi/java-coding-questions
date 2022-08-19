//inside a java file only one class can be "public"
// mostly we make that class public which contains main method

/* 
public class Base{
    void show(){
        System.out.println(" hello");
    }
}
*/

//we can't use private keyword with class
//it will give compile time error 

/*
private class Base{
    void show(){
        System.out.println(" hello");
    }
    public static void main(String[] args) {
        Base b = new Base();
        b.show();
    }
}
*/

//And same for protected 
//we can't use protected with class.
//it is compile time error
/* 
protected class Base{
    void show(){
        System.out.println("hello");
    }
}
*/


//Note :- By default java all classes use default access modifiers also know as "package private"
public class AccessModifierExampleWithClass {
    public static void main(String[] args) {
        
            
    }
}
