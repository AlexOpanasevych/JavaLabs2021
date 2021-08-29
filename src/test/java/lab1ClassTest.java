import com.phone.models.Phone;
import com.phone.models.Smartphone;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;


public class lab1ClassTest {

    @Test
    public void runAllAnnotatedMethodsTest() {
        Phone smartphone = new Smartphone();
        assertEquals(3, smartphone.runAllAnnotatedMethods());
    }

    @Test
    public void runAllAnnotatedMethodsNotEqualsTest() {
        Phone smartphone = new Smartphone();
        assertNotEquals(0, smartphone.runAllAnnotatedMethods());
    }

}