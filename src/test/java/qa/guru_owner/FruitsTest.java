package qa.guru_owner;

import config.FruitsConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FruitsTest {

    @Test
    public void testArray(){
        System.setProperty("array", "orange,banana");

        FruitsConfig config = ConfigFactory.create(FruitsConfig.class,System.getProperties());
        assertThat(config.getFruitsArray())
                .containsExactly("orange", "banana");
    }

//    @Test
//    public void testList(){
//        System.setProperty("list", "orange,banana");
//
//        FruitsConfig config = ConfigFactory.create(FruitsConfig.class,System.getProperties());
//        assertThat(config.getFruitsList())
//                .contain
//    }

    @Test
    public void testArrayWithDefaultValue(){
        FruitsConfig config = ConfigFactory.create(FruitsConfig.class,System.getProperties());

        assertThat(config.getFruitsArrayWithDefaultValues())
                .containsExactly("orange", "apple");
    }

//    @Test
//    public void testListWithSeparator(){
//        FruitsConfig config = ConfigFactory.create(FruitsConfig.class,System.getProperties());
//
//        assertThat(config.getFruitsListWithSeparator())
//                .containsExa
//    }
}
