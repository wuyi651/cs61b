import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void TestOffByOne() {
        assertTrue("failed",offByOne.equalChars('a','b'));
        assertTrue("failed",offByOne.equalChars('r','q'));
        assertFalse(offByOne.equalChars('a','e'));
        assertTrue("failed",offByOne.equalChars('&', '%'));
    }
}
