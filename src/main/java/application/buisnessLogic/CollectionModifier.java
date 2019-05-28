package application.buisnessLogic;

import application.PredicateTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

@Component("collectionModifier")
public class CollectionModifier {
    private Predicate<Integer> numberPredicate;
    private Predicate<Integer> positionPredicate;
    private Function<Integer, Integer> modifier;

    public Collection<Integer> excludeElementsAtEvenPositions(@RequestBody Collection<Integer> collection) {
        int currPos = 0;
        positionPredicate = new PredicateTemplate()::isEven;
        Iterator<Integer> iterator = collection.iterator();

        while (iterator.hasNext()) {
            iterator.next();
            if (positionPredicate.test(currPos)) {
                iterator.remove();
            }
            currPos++;
        }
        return collection;
    }

    public Collection<Integer> multiplyPrimeNumbersAtEvenPosBy(@RequestBody Collection<Integer> collection,
                                                               int byWhat) {
        int currPos = 0;
        List<Integer> modifiedList = new ArrayList<>();
        Iterator<Integer> iterator = collection.iterator();

        positionPredicate = new PredicateTemplate()::isUneven;
        numberPredicate = new PredicateTemplate()::isPrime;
        modifier = value -> value * byWhat;

        while (iterator.hasNext()) {
            Integer currNum = iterator.next();

            if (numberPredicate.test(currNum) && positionPredicate.test(currPos)) {
                modifiedList.add(modifier.apply(currNum));
            }
            currPos++;
        }
        return modifiedList;
    }
}
