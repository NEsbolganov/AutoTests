package simpleTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("simple")
public class NegativeTests {
    @Test
    void case1(){
        Assertions.assertTrue(false);
    }

    @Test
    void case2(){
        Assertions.assertTrue(false);
    }

    @Test
    void case3(){
        Assertions.assertTrue(false);
    }

    @Test
    @Disabled("We dont need it")
    void case4(){
        Assertions.assertTrue(false);
    }

    @Test
    void case5(){
        Assertions.assertTrue(false);
    }
}
