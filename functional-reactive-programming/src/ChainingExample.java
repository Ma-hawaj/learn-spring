import java.util.Objects;

public class ChainingExample {
    public ChainingExample(){
        Consumer<String> c1 = System.out::println;
        Consumer<String> c2 = System.out::println;

        Consumer<String> c3 = c1.thenAccept(c2);
        c3.accept( "hi");
    }

}

@FunctionalInterface
interface Consumer<T> {

    void accept(T t);
    default Consumer<T> thenAccept(Consumer<T> next){

        Objects.requireNonNull(next);


        return (T t) -> {
            this.accept(t);
            next.accept(t);
        };
    }
}