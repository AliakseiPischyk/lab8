package application.buisnessLogic;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;

@Component("collectionTypeChanger")
public class CollectionTypeChanger {
    public Set<Integer> toSetUsingStream(@RequestBody Collection<Integer> collection) {
        return collection.
                stream().
                collect(Collectors.toSet());
    }

    public Set<Integer> toSet(@RequestBody Collection<Integer> collection) {
        Set<Integer> set = new HashSet<>();

        for (Iterator<Integer> iterator = collection.iterator(); iterator.hasNext(); ) {
            set.add(iterator.next());
        }

        return set;
    }
}
