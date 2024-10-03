public class CurryingExample {
    public CurryingExample(){
        Function<Integer, Function<Integer, Integer>> fun = (s) -> {
            return (u) -> u + s;
        };

        Function<Integer, Integer> myfun = fun.apply(3);

        System.out.println(myfun.apply(10));
        System.out.println(fun.apply(3).apply(4));
    }
}
