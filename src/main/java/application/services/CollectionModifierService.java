package application.services;

import application.buisnessLogic.CollectionModifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Component
@RestController
@RequestMapping("/collection-modifier")
public class CollectionModifierService {

    @Autowired
    private CollectionModifier collectionModifier;

    @GetMapping(path = "/exclude-elements-at-even-positions",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Collection<Integer> excludeElementsAtEvenPositions(@RequestBody Collection<Integer> collection) {
        return collectionModifier.excludeElementsAtEvenPositions(collection);
    }

    @GetMapping(path = "/multiply-prime-numbers-at-even-pos-by-10",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Collection<Integer> multiplyPrimeNumbersAtEvenPosBy10(@RequestBody Collection<Integer> collection) {
        return collectionModifier.multiplyPrimeNumbersAtEvenPosBy10(collection);
    }
}

