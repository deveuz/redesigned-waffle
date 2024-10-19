/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programmingexercise4;
import java.util.Map;
import java.util.Stack;
/**
 *
 * @author kelzie デヴ
 */
public class PostfixEvaluator {
    // Method to evaluate a postfix expression
    public int evaluatePostfix(String postfix, Map<Character, Integer> values) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < postfix.length(); i++) {
            char current = postfix.charAt(i);

            // If the character is an operand (A-E), push its value to the stack
            if (Character.isLetter(current)) {
                stack.push(values.get(current));
            }
            // If the character is an operator, pop two elements, apply the operator, and push the result
            else if (current == '+' || current == '-' || current == '*' || current == '/') {
                int operand2 = stack.pop();
                int operand1 = stack.pop();

                switch (current) {
                    case '+':
                        stack.push(operand1 + operand2);
                        break;
                    case '-':
                        stack.push(operand1 - operand2);
                        break;
                    case '*':
                        stack.push(operand1 * operand2);
                        break;
                    case '/':
                        stack.push(operand1 / operand2);
                        break;
                }
            }
        }

        return stack.pop();
    }
}
