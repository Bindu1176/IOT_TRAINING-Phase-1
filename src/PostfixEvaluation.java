import java.util.*;
public class PostfixEvaluation {
    static int evaluate(String expression) {
        Stack<Integer>stack=new Stack<>();
        String[] tokens = expression.split("");
        for(String token : tokens) {
            if(token.matches("\\d+")) {
                stack.push(Integer.parseInt(token));
            } else {
                int b = stack.pop();
                int a = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(a+b);
                        break;
                    case "-":
                        stack.push(a-b);
                        break;
                    case "*":
                        stack.push(a*b);
                        break;
                    case "/":
                        stack.push(a/b);
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid Operator");
                }
            }
        }
        return stack.pop();
    }
    public static void main(String[] args) {
        String expression = "82+3*";
        System.out.println("expression:"+expression);
        System.out.println("Result:"+evaluate(expression));
    }
}