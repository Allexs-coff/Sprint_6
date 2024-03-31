import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)

public class ParameterizedClassAnimalTest {

    private final boolean isTruth;
    private final String inputParameter;
    private final List<String> outputParameter ;

    private Animal animal = new Animal();

    public ParameterizedClassAnimalTest(String inputParameter, List<String> outputParameter, boolean isTruth) {
        this.isTruth = isTruth;
        this.inputParameter = inputParameter;
        this.outputParameter = outputParameter;
    }

    @Parameterized.Parameters
    public static Object[][] getFood(){
        return new Object[][]{
                {"Травоядное", Arrays.asList("Трава", "Различные растения"),true},
                {"Хищник", Arrays.asList("Животные", "Птицы", "Рыба"),true},
                {"Всеядные", Collections.singletonList("Неизвестный вид животного, используйте значение Травоядное или Хищник"), true}
        };
    }

    @Test
    public void animalClassTest() {
        assertThat((exceptionHandling(inputParameter).equals(outputParameter)),is(isTruth));
    }

    public List<String> exceptionHandling(String inputLocalParameter){
        List<String> result ;

        try{
            result = animal.getFood(inputLocalParameter);
        }
        catch (Exception e){
            result = Collections.singletonList(e.getMessage());
        }
        return result;
    }

    @Test
    public void getFamilyTest(){
        assertEquals(animal.getFamily(),"Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи");
    }




}
