public class ComposeExample {

    public ComposeExample(){
        Function<String, Integer> fun = String::length;
        Function<String, Integer> fun1 = fun.compose((String s) -> s+" hi");

        System.out.println(fun1.apply("hi"));


    }
}


interface Function<T, R>{
    R apply(T t);


    default <V> Function<V, R> compose(Function<V,T> fun){
        return (s) -> {
          return this.apply(fun.apply(s));
        };
    }
}