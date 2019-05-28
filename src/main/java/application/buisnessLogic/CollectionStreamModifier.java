package application.buisnessLogic;

import application.PredicateTemplate;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Component("collectionStreamModifier")
public class CollectionStreamModifier {

    Predicate<Integer> numberPredicate;
    Predicate<Integer> positionPredicate;
    Function<Integer, Integer> modifier;

    public Collection<Integer> multiplyPrimeNumbersAtEvenPosBy(Collection<Integer> collection, int byWhat) {
        positionPredicate = new PredicateTemplate()::isEven;
        numberPredicate = new PredicateTemplate()::isPrime;
        modifier = value -> value * byWhat;

        new CollectionModifier()
                .excludeElementsAtEvenPositions(collection); // e.g. isEven() passed then delete those which match !isEven()

        return collection.stream().
                filter(numberPredicate).
                map(modifier).
                collect(Collectors.toList());
    }
}
