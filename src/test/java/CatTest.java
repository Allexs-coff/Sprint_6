import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.Mockito;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    private Feline feline = new Feline();
    @Spy private Cat cat = new Cat(feline);



    @Test
    public void getSoundTest(){
        assertEquals(cat.getSound(),"Мяу");
        Mockito.verify(cat,Mockito.times(1)).getSound();
    }
    @Test
    public void getFoodTest() throws Exception {
        assertEquals(cat.getFood(),List.of("Животные", "Птицы", "Рыба"));
        Mockito.verify(cat,Mockito.times(1)).getFood();
    }
}
