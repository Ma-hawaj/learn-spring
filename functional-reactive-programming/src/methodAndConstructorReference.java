import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class methodAndConstructorReference {
    public methodAndConstructorReference(){


        // 3 types of method references
        System.out.println("Method and constructor reference");

        //object::instanceMethod
            // object system.out
        Consumer<String> pr = System.out::println;

        //Class::staticMethod
        UnaryOperator<String> uo = AClass::myMethod;

        //Class::intanceMethod
            // using an instance method of class
        Function<String, Integer> len = String::length;

        // Constructor reference
        //Class::new
        Function<Integer, AClass> me = AClass::new;
        Supplier<AClass> s = AClass::new;

    }
}

class AClass{
    public AClass(){
        // Supplier<AClass> s uses this
    }

    public AClass(int i){
        // Function<Integer, AClass> me uses this
    }

    static String myMethod(String a){
        return a+ "fewlf";
    }

    static String myMethod2(String a){
        return a+ "fewlf";
    }
}
