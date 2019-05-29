
import application.buisnessLogic.CollectionStreamModifier;
import application.services.CollectionStreamModifierService;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;


public class CollectionStreamModifierTest {
    private final List<Integer> list = new ArrayList<>();

    @Before
    public void setList() {
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
    }

    @Test
    public void modifyCollectionPrimeEvenTest() {

        Collection<Integer> correctModifiedList = new ArrayList<>();
        CollectionStreamModifier collectionStreamModifier = new CollectionStreamModifier();

        Collection<Integer> myModifiedList = collectionStreamModifier.multiplyPrimeNumbersAtEvenPosBy(list, 10);

        assertFalse(correctModifiedList.equals(myModifiedList));
    }

    @Test
    public void modifyCollectionPrimeUnevenTest() {

        Collection<Integer> correctModifiedList = new ArrayList<>();
        correctModifiedList.add(30);
        correctModifiedList.add(50);
        correctModifiedList.add(70);

        CollectionStreamModifier collectionStreamModifier = new CollectionStreamModifier();

        Collection<Integer> myModifiedList = collectionStreamModifier.multiplyPrimeNumbersAtEvenPosBy(list, 10);

        assertArrayEquals(correctModifiedList.toArray(), myModifiedList.toArray());
    }


}