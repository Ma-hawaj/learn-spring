import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;

public class predefinedInterfaces {
    public predefinedInterfaces(){

        //Predicate
        //  takes T and return a boolean
        new PredicateExample();

        //Consumer
        //  takes T and return void
        List.of(1,3,4,5).forEach(System.out::println);

        //Supplier
        //  takes nothing and return T
        Supplier<Double> randomNum = Math::random;
        System.out.println(randomNum.get());

        //Function
        //  Takes T and return R
        Function<String, Integer> length = String::length;
        System.out.println(length.apply("Hi"));

        //UnaryOperator
        //  Takes T and returns T
        //  Extends function
        var ls = Arrays.asList(1,3,4,5);
        ls.replaceAll(x -> x+3);
        System.out.println(ls);

        //BiFunction
        //  Takes T and U and returns R
        BiFunction<String, Integer, Integer> bi = (x, y) -> x.length()+y;
        System.out.println(bi.apply("hi",3));

        //BinaryOperator
        //  Takes two Ts and return T
        BinaryOperator<Integer> bo = (x, y) -> 2*x +y;
        System.out.println(bo.apply(3,4));
    }
}
