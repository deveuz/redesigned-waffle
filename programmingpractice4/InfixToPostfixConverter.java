/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programmingexercise4;

import java.util.Stack;

/**
 *
 * @author kelzie デヴ
 */
public class InfixToPostfixConverter {
    // Method to get precedence of operators
    private int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return -1;
        }
    }

    // Method to convert infix to postfix
    public String convertInfixToPostfix(String expression) {
        Stack<Character> stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();

        for (int i = 0; i < expression.length(); i++) {
            char current = expression.charAt(i);

            // If the character is an operand (A-E), add it to output
            if (Character.isLetter(current)) {
                postfix.append(current).append(" ");
            }
            // If the character is '(', push it to the stack
            else if (current == '(') {
                stack.push(current);
            }
            // If the character is ')', pop and output from the stack until '(' is found
            else if (current == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop()).append(" ");
                }
                stack.pop(); // Remove '('
            }
            // If the character is an operator
            else if (current == '+' || current == '-' || current == '*' || current == '/') {
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(current)) {
                    postfix.append(stack.pop()).append(" ");
                }
                stack.push(current);
            }
        }

        // Pop all remaining operators from the stack
        while (!stack.isEmpty()) {
            postfix.append(stack.pop()).append(" ");
        }

        return postfix.toString().trim();
    }
}
