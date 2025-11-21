package Practical13;


/// Class used to present tokens string he values and the type
/// @param type  stores a value of the enum Token Type
/// @param value stores a string value of the token then will be parsed later
public record Token(TokenType type, String value) {

    /// Returns the type of the token
    public TokenType getType() {
        return type;
    }

    /// Returns the value of the token as a string
    public String getValue() {
        return value;
    }


    /// returns a parsed value from the string value
    /// if an invalid parse throws an error
    public double getNum(){
        if(type != TokenType.NUMERIC){ throw new
                IllegalArgumentException("TokenType is not NUMERIC: " + type);}
        //returned parsed value
        return Double.parseDouble(value);
    }

    /// returns a boolean from string value
    /// if invalid parse it throws an error
    public boolean getBool(){
        if(type != TokenType.LOGICAL){
            throw new IllegalArgumentException("TokenType is not LOGICAL: " + type);
        }
        return Boolean.parseBoolean(value);
    }


    /// Represents the string representation of a token
    /// Displays value of token and type
    @Override
    public String toString() {
        return "Token Type:" + type + " \n Value:" + value;
    }
}
