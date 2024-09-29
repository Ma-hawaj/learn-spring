import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {

    PredicateExample(){

        List<String> list = new ArrayList<>(Arrays.asList(
                "Basics",
                "",
                "Strong",
                ""
        ));
        Predicate<String> predicate = s -> !s.isEmpty();
        List<String> filtered = filterList(list, predicate);
        System.out.println(filtered);
    }

    private <T> List<T> filterList(List<T> list, Predicate<T> predicate) {
        List<T> newList = new ArrayList<>();

        for(T s: list){
            if(predicate.test(s)){
                newList.add(s);
            }
        }

        return newList;
    }


}
