import java.util.Collection;
import java.util.function.Predicate;

public class MultiplePredicate {
    public static <T> Predicate<T> matchingAll(Collection<Predicate<T>> predicates) {
        Predicate<T> multiPredicate = to -> true;
        for (Predicate<T> predicate : predicates) {
            multiPredicate = multiPredicate.and(predicate);
        }
        return multiPredicate;
    }
}
