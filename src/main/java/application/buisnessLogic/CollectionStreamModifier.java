package application.buisnessLogic;

import application.PredicateTemplate;
import application.services.CollectionModifierService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collection;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Component("collectionStreamModifier")
public class CollectionStreamModifier {

    Predicate<Integer> numberPredicate;
    Predicate<Integer> positionPredicate;
    Function<Integer, Integer> modifier;

    public Collection<Integer> multiplyPrimeNumbersAtEvenPosBy10(@RequestBody Collection<Integer> collection) {
        positionPredicate = new PredicateTemplate()::isEven;
        numberPredicate = new PredicateTemplate()::isPrime;
        modifier = value -> value * 10;

        new CollectionModifierService()
                .excludeElementsAtEvenPositions(collection); // e.g. isEven() passed then delete those which match !isEven()

        return collection.stream().
                filter(numberPredicate).
                map(modifier).
                collect(Collectors.toList());
    }
}
