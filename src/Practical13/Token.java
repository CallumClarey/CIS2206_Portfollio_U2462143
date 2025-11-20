package Practical13;


/// Class used to present tokens string he values and the type
/// @param type  stores a value of the enum Token Type
/// @param value stores a string value of the token then will be parsed later
public record Token(TokenType type, String value) {

    /// Enum types used to represent tokens
    public enum TokenType {
        Comparison,
        Logical,
        Numeric,
        Boolean,
    }

    //NOTE: all values are readonly once set due to the redundant need for tokens to be changed

    /// sets the token type these will be readonly as they should not need to be changed
    /// after creation
    public Token {
    }

    /// Returns the type of the token
    @Override
    public TokenType type() {
        return type;
    }

    /// Returns the opera
    public String getOperator() {
        return value;
    }

    /// Represents the string representation of a token
    /// Displays value of token and type
    @Override
    public String toString() {
        return "Token Type:" + type + " \n Value:" + value;
    }
}
