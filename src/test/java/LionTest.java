import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.Mockito;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Spy   private Feline feline= new Feline();
@Spy private Lion lion  = new Lion("Самец", feline);
@Spy private Lion lioness= new Lion("Самка", feline);;
    private Lion wrongValue;

    public LionTest() throws Exception {}

    @Test
    public void lionTest()  {
        assertTrue(lion.doesHaveMane());
        Mockito.verify(lion,Mockito.times(1)).doesHaveMane();
    }

    @Test
    public void lionessTest() {
        assertFalse(lioness.doesHaveMane());
        Mockito.verify(lioness,Mockito.times(1)).doesHaveMane();
    }

    @Test
    public void incorrectGenderValueTest() {
        Exception exception = assertThrows(Exception.class, ()-> wrongValue = new Lion("qwerty",feline));
        assertTrue(exception.getMessage().equals("Используйте допустимые значения пола животного - самей или самка"));
    }

    @Test
    public void getKittensTest()  {
        assertEquals(lion.getKittens(),1);
        Mockito.verify(lion,Mockito.times(1)).getKittens();

    }

    @Test
    public void getFoodTest() throws Exception {
        assertEquals(lion.getFood(), List.of("Животные", "Птицы", "Рыба"));
        Mockito.verify(lion,Mockito.times(1)).getFood();
    }

}
