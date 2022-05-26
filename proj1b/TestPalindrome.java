import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();
    static CharacterComparator cc = new OffByOne();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void TestPalindrome() {
        assertFalse(palindrome.isPalindrome("cat"));
        assertTrue("Failed",palindrome.isPalindrome("a"));
        assertTrue("Failed",palindrome.isPalindrome(""));
        assertTrue("Failed",palindrome.isPalindrome("noon"));
       // assertTrue("Failed",palindrome.isPalindrome("cat"));
        assertTrue("Failed",palindrome.isPalindrome(null));
        assertTrue("Failed",palindrome.isPalindrome("flake",cc));
        assertTrue("Failed",palindrome.isPalindrome("f",cc));
    }


}
