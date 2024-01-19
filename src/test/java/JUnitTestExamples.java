import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class JUnitTestExamples {

    @BeforeAll
    static void beforeAll(){
        System.out.println("This is case beforeAll");
    }

    @Test
    void firstTestCase(){
        System.out.println("This is the first test case");
    }

    @Test
    void secondTestCase(){
        System.out.println("This is the second test case");
    }
}
