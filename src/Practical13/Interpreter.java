package Practical13;

import java.util.Stack;

public class Interpreter {

    /// Internal stack used for processing input
    private Stack<Token> stack = new Stack<>();

    /// Function used to push tokens onto the stack
    public void PushInternal(Token token) {
        stack.push(token);
    }

    /// Function called will begin the interpreter
    public void BeginInterpreter() {

        //Check the stack is not empty
        if (stack.empty()) {
            System.out.println("No Tokens in Stack");
            return;
        }



    }




}
