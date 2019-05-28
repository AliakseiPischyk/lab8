package application.services;

import application.buisnessLogic.CollectionStreamModifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Component
@RestController
@RequestMapping("/collection-stream-modifier")
public class CollectionStreamModifierService {

    @Autowired
    CollectionStreamModifier collectionStreamModifier;

    @RequestMapping(path = "/multiply-prime-numbers-at-even-pos-by-10",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.GET)
    @ResponseBody
    public Collection<Integer> multiplyPrimeNumbersAtEvenPosBy10(@RequestBody Collection<Integer> collection) {
       return collectionStreamModifier.multiplyPrimeNumbersAtEvenPosBy10(collection);
    }
}
