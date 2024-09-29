import java.util.Optional;

public class OptionalExamples {

    public OptionalExamples(){

        // Wrapping the values with optional
        String val = "my str";
        Optional<String> optional = Optional.of(val);

        // empty
        Optional<String> empty = Optional.empty();

        Optional<String> nullable = Optional.ofNullable(val);
        Optional<String> emptyNullable = Optional.ofNullable(null);

        // Unwrapping the values
        System.out.println(optional.get());
        System.out.println(empty.isEmpty() ? "empty" : empty.get());
        System.out.println(nullable.orElse("Else"));
        System.out.println(emptyNullable.orElse("Else"));

        // better for performance
        System.out.println(emptyNullable.orElseGet(()-> "Supplier"));
        System.out.println(nullable.orElseThrow(RuntimeException::new));

        //map()
            // returns the value wrapped with optional
            // orElse unwrap it
        System.out.println(optional.map(x -> x+" mapped").orElse("Empty"));

        //filter()
        System.out.println(optional
                .filter(s ->
                        s.equalsIgnoreCase("somethind"))
                .orElse("Wrong"));

        //flatMap()
            // don't return optional you should wrap it manually
        System.out.println(optional
                .flatMap(str -> Optional.of("Strr")));

        //ifPresent
        optional.ifPresent(System.out::println);
        //ifPresentOrElse
        empty.ifPresentOrElse(System.out::println,
                () -> System.out.println("NO value present"));

        //streams
        optional.stream().forEach(System.out::println);

        //or
        // if optional empty execute the supplier
        empty.or(()-> Optional.of("empty")).ifPresent(System.out::println);

        //equals
        // the object should be optional
        System.out.println(optional.equals(Optional.of("my str")));

        //hashcode
        System.out.println(emptyNullable.hashCode());


    }
}
