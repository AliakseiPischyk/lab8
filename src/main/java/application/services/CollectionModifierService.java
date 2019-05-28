package application.services;

import application.buisnessLogic.CollectionModifier;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Collection;

@Component
@RestController
@RequestMapping("/collection-modifier")
public class CollectionModifierService {

    private static final Logger logger = LoggerFactory.getLogger(CollectionStreamModifierService.class);

    @Autowired
    private CollectionModifier collectionModifier;
    ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping(path = "/exclude-elements-at-even-positions",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Collection<Integer> excludeElementsAtEvenPositions(@RequestBody JSONObject object) {
        try {
            return collectionModifier.excludeElementsAtEvenPositions(
                    objectMapper.readValue(object.getString("values"), Collection.class));
        } catch (IOException e) {
            logger.error(e.toString());
        } catch (JSONException e) {
            logger.error(e.toString());
        }
        return null;
    }

    @GetMapping(path = "/multiply-prime-numbers-at-even-pos-by",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE,
            params = "j")
    @ResponseBody
    public Collection<Integer> multiplyPrimeNumbersAtEvenPosBy(@RequestBody JSONObject object) throws JSONException, IOException {
        return collectionModifier.multiplyPrimeNumbersAtEvenPosBy(
                objectMapper.readValue(object.getString("values"), Collection.class),
                object.getInt("multiplier  "));
    }
}

