import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.Mockito;

import java.util.Collections;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
@Mock   private Feline feline= new Feline();
@Spy private Lion lion  = new Lion("Самец", feline);
@Spy private Lion lioness= new Lion("Самка", feline);
    private Lion wrongValue;

    public LionTest() throws Exception {}

    @Test
    public void lionTest()  {
        assertTrue(lion.doesHaveMane());
        verify(lion,Mockito.times(1)).doesHaveMane();
    }

    @Test
    public void lionessTest() {
        assertFalse(lioness.doesHaveMane());
        verify(lioness,Mockito.times(1)).doesHaveMane();
    }

    @Test
    public void incorrectGenderValueTest() {
        Exception exception = assertThrows(Exception.class, ()-> wrongValue = new Lion("qwerty",feline));
        assertTrue(exception.getMessage().equals("Используйте допустимые значения пола животного - самей или самка"));
    }

    @Test
    public void getKittensTest()  {
        assertEquals(lion.getKittens(),1);
        verify(lion,Mockito.times(1)).getKittens();
    }

    @Test
    public void getKittensStub() throws Exception {
        Mockito.when(feline.getKittens()).thenReturn(100500);
        Lion lionTestStab = new Lion("Самец",feline);
        assertEquals(lionTestStab.getKittens(), 100500);
    }


    @Test
    public void getFoodTest() throws Exception {
        assertEquals(lion.getFood(), List.of("Животные", "Птицы", "Рыба"));
        verify(lion,Mockito.times(1)).getFood();
    }
    @Test
    public void testLionStub() throws Exception {
        Mockito.when(feline.getFood("Хищник")).thenReturn(Collections.singletonList("не хищник"));
        Lion lionTestStab = new Lion("Самец",feline);
        assertEquals(lionTestStab.getFood(), Collections.singletonList("не хищник"));
    }
}
