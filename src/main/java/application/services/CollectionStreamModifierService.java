package application.services;

import application.buisnessLogic.CollectionStreamModifier;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Collection;

@Component
@RestController
@RequestMapping("/collection-stream-modifier")
public class CollectionStreamModifierService {

    @Autowired
    CollectionStreamModifier collectionStreamModifier;
    ObjectMapper objectMapper = new ObjectMapper();

    @RequestMapping(path = "/multiply-prime-numbers-at-even-pos-by",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.GET)
    @ResponseBody
    public Collection<Integer> multiplyPrimeNumbersAtEvenPosBy10(@RequestBody JSONObject object) throws JSONException, IOException {
        return collectionStreamModifier.multiplyPrimeNumbersAtEvenPosBy(
                objectMapper.readValue(object.getString("values"), Collection.class),
                object.getInt("multiplier  "));
    }
}
