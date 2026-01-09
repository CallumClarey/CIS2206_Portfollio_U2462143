package Practical13;

import java.util.List;
import java.util.Stack;

public class Interpreter {

    /// Internal stack used for processing input
    private final Stack<Token> stack = new Stack<>();

    /// Function called will begin the interpreter
    public void BeginInterpreter(List<Token> tokenList) {

        //checks to see if there is a valid amount of inputs
        if (tokenList.size() < 2){
            System.out.println("Not enough tokens To begin Process");
            return;
        }

        // Loop through the list of tokens and check the input
        // this is complexity of O(N) due to each item in the list requiring an operation
        for (var token : tokenList) {

            //check the values in the list to add to the stack
            if(token.getType() == TokenType.NUMERIC || token.getType() == TokenType.BOOLEAN){
                stack.push(token);
                continue;
            }

            stack.push(token);

            //performs a switch and checks the token type to see if an operation can be performed
            switch (token.getType()) {
                case COMPARISON -> ComparisonOperation();
                case LOGICAL -> LogicalOperation();
                default -> { System.out.println("Invalid token type"); return; }
            }

        }
    }

    /// Function used to the compared the values of two doubles
    public void ComparisonOperation(){
//        //check for the order error
//        if(!checkTokenType(TokenType.COMPARISON))return ;
        //checks for the stack size error
        if(!checkStackSize()) return;

        //initial validation passed
        //pop the operation of the stack, time O(1)
        //store the operation value
        Token operation = stack.pop();

        //store the rhs and lhs values
        //pops achieved in O(1)
        var RHS = stack.pop().getNum();
        System.out.println("RHS Popped: " + RHS);
        var LHS = stack.pop().getNum();
        System.out.println("LHS Popped: " + LHS);

        //stores the value of the operation
        boolean result;
        switch (operation.getValue()){
            case "<" -> { result = LHS < RHS;}
            case ">" -> { result = LHS > RHS;}
            default -> {
                System.out.println("Invalid Operation!!");
                return;
            }
        }

        //creates a new token and then pushes the token onto the stack
        //operation performed in O(1)
        var ResultToken = new Token(TokenType.BOOLEAN, String.valueOf(result));
        stack.push(ResultToken);
        //displays stack value at this stage
        System.out.println("Operation Successful, Value Pushed:" + operation.getValue());
        System.out.println(stack.toString());
    }


    /// function used to perform logical operations on values in the stack
    public void LogicalOperation(){
        //performs check to see whether the stack is valid
        if(!checkStackSize()) return;

        //pops values in time O(1)
        Token operation = stack.pop();
        System.out.println("Logical Operation Popped: " + operation.getValue());
        boolean RHS = stack.pop().getBool();
        System.out.println("RHS Popped: " + RHS);
        boolean LHS = stack.pop().getBool();
        System.out.println("LHS Popped: " + LHS);
        //output result of the operation
        boolean result;

        //switch on the value
        switch (operation.getValue().toUpperCase()) {
            case "AND" -> result = LHS && RHS;
            case "OR"  -> result = LHS || RHS;
            default -> {
                System.out.println("Invalid logical operator: " + operation.getValue());
                return;
            }
        }

        //creates a result token and pushes it onto the stack
        Token resultToken = new Token(TokenType.BOOLEAN, String.valueOf(result));
        stack.push(resultToken);

        //prints the stack and then prints the operation
        System.out.println("Logical operation successful: " + LHS + " " + operation.getValue() + " " + RHS + " = " + result);
        System.out.println("Stack now: " + stack);
    }

    //HELPER FUNCTIONS TO CLEAN UP CODE

    /// Function is used to check the size of the stack
    /// returns true if the stack size is valid false if not
    private Boolean checkStackSize(){
        if(stack.size() < 3){
            System.out.println("Not enough tokens To compare, Stack Size: " + stack.size());
            System.out.println("Stack:" + stack);
            return false;
        }
        else return true;
    }

    /// Function is used to check the token type of the stack top value
    /// returns true if valid and false if invalid
    private Boolean checkTokenType(TokenType tokenTypeValue){
        if(stack.peek().getType() != tokenTypeValue){
            System.out.println("Invalid Token, TokenType: " + stack.peek().getType());
            return false;
        }
        else return true;
    }

    //helper functions for testing
    public Token popStack() {
        return stack.pop();
    }

    public boolean isStackEmpty() {
        return stack.isEmpty();
    }

    public int getStackSize() {
        return stack.size();
    }





}
