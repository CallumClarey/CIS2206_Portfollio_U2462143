import Practical13.Token;
import Practical13.TokenType;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    Token token = new Token(TokenType.NUMERIC,"1");
    System.out.println(token.toString());

}
