package Practical13;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static Practical13.TokenType.BOOLEAN;
import static org.junit.jupiter.api.Assertions.*;

public class Unit_13_Test {

    private Interpreter interpreter;

    @BeforeEach
    void setup() {
        interpreter = new Interpreter();
    }

    @Test
    void testSimpleComparisonLessThan() {
        List<Token> tokens = new ArrayList<>();
        tokens.add(new Token(TokenType.NUMERIC, "5"));
        tokens.add(new Token(TokenType.NUMERIC, "10"));
        tokens.add(new Token(TokenType.COMPARISON, "<"));

        interpreter.BeginInterpreter(tokens);

        // The stack should now have one BOOLEAN token with value true
        Token result = interpreter.popStack();
        assertEquals(BOOLEAN, result.getType());
        assertTrue(result.getBool());
    }

    @Test
    void testSimpleComparisonGreaterThan() {
        List<Token> tokens = new ArrayList<>();
        tokens.add(new Token(TokenType.NUMERIC, "20"));
        tokens.add(new Token(TokenType.NUMERIC, "15"));
        tokens.add(new Token(TokenType.COMPARISON, ">"));

        interpreter.BeginInterpreter(tokens);

        Token result = interpreter.popStack();
        assertEquals(BOOLEAN, result.getType());
        assertTrue(result.getBool());
    }

    @Test
    void testLogicalAndOperation() {
        List<Token> tokens = new ArrayList<>();
        tokens.add(new Token(BOOLEAN, "true"));
        tokens.add(new Token(BOOLEAN, "false"));
        tokens.add(new Token(TokenType.LOGICAL, "AND"));

        interpreter.BeginInterpreter(tokens);

        Token result = interpreter.popStack();
        assertEquals(BOOLEAN, result.getType());
        assertFalse(result.getBool());
    }

    @Test
    void testLogicalOrOperation() {
        List<Token> tokens = new ArrayList<>();
        tokens.add(new Token(BOOLEAN, "true"));
        tokens.add(new Token(BOOLEAN, "false"));
        tokens.add(new Token(TokenType.LOGICAL, "OR"));

        interpreter.BeginInterpreter(tokens);

        Token result = interpreter.popStack();
        assertEquals(BOOLEAN, result.getType());
        assertTrue(result.getBool());
    }

    @Test
    void testCombinedPostfixExpression() {
        // Tests the numerical with the logical
        List<Token> tokens = new ArrayList<>();
        tokens.add(new Token(TokenType.NUMERIC, "5"));
        tokens.add(new Token(TokenType.NUMERIC, "10"));
        tokens.add(new Token(TokenType.COMPARISON, "<"));  // evaluates to true

        tokens.add(new Token(TokenType.NUMERIC, "15"));
        tokens.add(new Token(TokenType.NUMERIC, "10"));
        tokens.add(new Token(TokenType.COMPARISON, ">"));  // evaluates to true

        tokens.add(new Token(TokenType.LOGICAL, "AND"));   // true AND true = true

        interpreter.BeginInterpreter(tokens);

        Token result = interpreter.popStack();
        assertEquals(BOOLEAN, result.getType());
        assertTrue(result.getBool());
    }

    @Test
    void testInvalidStackSize() {
        List<Token> tokens = new ArrayList<>();
        tokens.add(new Token(TokenType.COMPARISON, "<")); // Not enough operands

        interpreter.BeginInterpreter(tokens);

        // Stack should remain empty
        assertTrue(interpreter.isStackEmpty());
    }
}

