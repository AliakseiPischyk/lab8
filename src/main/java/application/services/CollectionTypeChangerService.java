package application.services;

import application.buisnessLogic.CollectionTypeChanger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Set;

@Component
@RestController
@RequestMapping("/collection-type-changer")
public class CollectionTypeChangerService {

    @Autowired
    private CollectionTypeChanger collectionTypeChanger;

    @RequestMapping(value = "/to-set-using-stream",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Set<Integer> toSetUsingStream(@RequestBody Collection<Integer> collection) {
        return collectionTypeChanger.toSetUsingStream(collection);
    }

    @RequestMapping(value = "/to-set",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Set<Integer> toSet(@RequestBody Collection<Integer> collection) {
        return collectionTypeChanger.toSet(collection);
    }
}
