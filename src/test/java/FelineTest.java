import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Spy private Feline feline = new Feline();


    @Test
    public void eatMeatTest() throws Exception {
        assertEquals(feline.eatMeat(), List.of("Животные", "Птицы", "Рыба"));
        Mockito.verify(feline,Mockito.times(1)).eatMeat();
    }

    @Test
    public void getFamilyTest(){
        assertEquals(feline.getFamily(),"Кошачьи");
        Mockito.verify(feline,Mockito.times(1)).getFamily();
    }

    @Test
    public void getKittensWithParams(){
        assertEquals(feline.getKittens(1),1);
        Mockito.verify(feline,Mockito.times(1)).getKittens(1);
    }

    @Test
    public void getKittensWithParamsStabTest(){
        Mockito.when(feline.getKittens(1)).thenReturn(100500);
        assertEquals(feline.getKittens(1),100500);
        Mockito.verify(feline,Mockito.times(1)).getKittens(1);
    }

    @Test
    public void getKittensWithoutParams(){
        assertEquals(feline.getKittens(),1);
        Mockito.verify(feline,Mockito.times(1)).getKittens();
    }


}
