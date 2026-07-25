import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringUtilsTest {

    private StringUtils stringUtils = new StringUtils();

    @Test
    void testReverse() {
        String result = stringUtils.reverse("hello");
        assertEquals("olleh", result, "Reversing 'hello' should give 'olleh'");
    }

    @Test
    void testReverseWithNull() {
        String result = stringUtils.reverse(null);
        assertNull(result, "Reversing null should return null");
    }

    @Test
    void testIsPalindromeTrue() {
        boolean result = stringUtils.isPalindrome("madam");
        assertTrue(result, "'madam' should be identified as a palindrome");
    }

    @Test
    void testIsPalindromeFalse() {
        boolean result = stringUtils.isPalindrome("hello");
        assertFalse(result, "'hello' should not be identified as a palindrome");
    }

    @Test
    void testCountVowels() {
        int result = stringUtils.countVowels("Education");
        assertEquals(5, result, "'Education' should have 5 vowels");
    }

    @Test
    void testCountVowelsWithNull() {
        int result = stringUtils.countVowels(null);
        assertEquals(0, result, "Counting vowels in null should return 0");
    }
}
