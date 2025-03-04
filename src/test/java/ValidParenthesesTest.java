import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class ValidParenthesesTest {


    @Test
    void testValidParentheses() {
        // Test valid cases
        assertTrue(ValidParentheses.isValid("()"));
        assertTrue(ValidParentheses.isValid("()[]{}"));
        assertTrue(ValidParentheses.isValid("{[]}"));
        assertTrue(ValidParentheses.isValid("([{}])"));


    }


    @Test
    void testInvalidParentheses() {
        // Test invalid cases
        assertFalse(ValidParentheses.isValid("(]"));
        assertFalse(ValidParentheses.isValid("([)]"));
        assertFalse(ValidParentheses.isValid("]"));
        assertFalse(ValidParentheses.isValid("{"));
    }

    @Test
    void testEmptyString() {
        assertFalse(ValidParentheses.isValid(""));
    }


    @Test
    void testLongInput() {
        // Test with a complex nested structure
        String longValidInput = "({[(){}]([{}])}{({})[[()]]})[{()}]";
        assertTrue(ValidParentheses.isValid(longValidInput));

        // Test with a long invalid input
        String longInvalidInput = "({[(){}]([{}])}{({})[[()]]})[{(";
        assertFalse(ValidParentheses.isValid(longInvalidInput));

        // Test with repeated patterns
        String repeatedPattern = "()[]{}()[]{}()[]{}";
        assertTrue(ValidParentheses.isValid(repeatedPattern));

        // Test with deeply nested structure
        String deeplyNested = "(((((((((()))))))))){[][][][][]}";
        assertTrue(ValidParentheses.isValid(deeplyNested));
    }
}
