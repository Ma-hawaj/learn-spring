import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsExample {
    public StreamsExample(){

        System.out.println("______Streams______");

        // takes a predicate function
        System.out.println("______Filter______");
        Stream.of(1, 2 ,5 ,48 ,84 ,54, 4, 45, 54)
                .filter(n -> n>6)
                .forEach(System.out::println);

        // takes a Function
        System.out.println("______Map______");
        Stream.of(1, 2 ,5 ,48 ,84 ,54, 4, 45, 54)
                .map(s -> s*21)
                .forEach(System.out::println);

        // takes an identity, accumulator
        // identity don't affect the operation ex. 0 in sum
        System.out.println("______Reduce______");
        int sum = Stream.of(1, 2 ,5 ,48 ,84 ,54, 4, 45, 54)
                .reduce(0, (a,b) -> a+b);
        System.out.println("Total: "+sum);

        // Streams of primitive types
        int sumOfInt = IntStream.of(3,4,4,3,43).sum();
        System.out.println(sumOfInt);
        // you can use mapToInt function
        // or on primitive streams mapToObj

        // .max() returns Optional
        // .min() returns Optional
        // .average() returns Optional double

        IntSummaryStatistics summaryStatistics = IntStream
                .of(3,4,4,3,43)
                .summaryStatistics();
        System.out.println(summaryStatistics);

        // streaming maps
        Map<Integer, String> map = Map.of(1, "one", 2, "two", 3, "three");
        map.entrySet()
                .stream()
                .forEach(s-> System.out.println(s.getKey()+": "+s.getValue()));
        var valueStream = map.values().stream();
        var keyStream = map.keySet().stream();

        // stream from array
        Integer[] intArray = {2,43, 54,35 ,453,534 };
        Arrays.stream(intArray).filter(s -> s>10);

        System.out.println("______Stream Builder______");
        // Using stream builder
        Stream.Builder<Integer> builder = Stream.builder();
        builder.add(2);
        builder.add(3);
        builder.build().forEach(System.out::println);

        System.out.println("______Infinite Streams______");
        Stream.iterate(0, integer -> ++integer)
                .limit(20)
                .forEach(System.out::println);

        Stream.generate(() -> "Hi")
                .limit(2)
                .forEach(System.out::println);

        // flatMap flats the streams


        // parallel streams
        // use .parallelStream()
        // or on a stream .parallel()

        // when using parallel streams be careful to only use
        // stateless methods

    }
}
