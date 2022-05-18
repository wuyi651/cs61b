import org.junit.Test;
import static org.junit.Assert.*;

public class FlikTest {

    @Test
    public void testisSameNumber(){
        Integer a=128;
        Integer b=128;
       // assertTrue(Flik.isSameNumber(a,b));
        assertTrue("failed",Flik.isSameNumber(a,b));
    }

}
