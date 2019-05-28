import application.buisnessLogic.CollectionModifier;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

public class CollectionModifierTest {

    private final List<Integer> list = new ArrayList<>();

    @Before
    public void setList() {
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
    }

    @Test
    public void modifyCollectionPrimeEvenTest() {

        Collection<Number> correctModifiedList = new ArrayList<>();
        CollectionModifier collectionModifierService = new CollectionModifier();
        Collection<Integer> myModifiedList = collectionModifierService.multiplyPrimeNumbersAtEvenPosBy(list,10);

        assertFalse(correctModifiedList.equals(myModifiedList));
    }

    @Test
    public void modifyCollectionPrimeUnevenTest() {

        Collection<Integer> correctModifiedList = new ArrayList<>();
        correctModifiedList.add(30);
        correctModifiedList.add(50);
        correctModifiedList.add(70);

        CollectionModifier collectionModifier = new CollectionModifier();

        Collection<Integer> myModifiedList = collectionModifier.multiplyPrimeNumbersAtEvenPosBy(list,10);

        assertArrayEquals(correctModifiedList.toArray(), myModifiedList.toArray());
    }

    @Test
    public void excludeElementsAtEvenPositions() {
        List<Number> expectedList = new ArrayList<>();
        expectedList.add(1);
        expectedList.add(3);
        expectedList.add(5);
        expectedList.add(7);
        expectedList.add(9);

        CollectionModifier collectionModifier = new CollectionModifier();

        collectionModifier.excludeElementsAtEvenPositions(list);

        assertEquals(expectedList, list);
    }
}