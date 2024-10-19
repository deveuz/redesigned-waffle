/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programmingexercise4;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author kelzie デヴ
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Infix Notation: ");
        String infixExpression = scanner.nextLine();

        // Find and input values for the variables that are actually in the expression inputted by user
        Map<Character, Integer> variableValues = new HashMap<>();
        System.out.println();
        
        for (char var : infixExpression.toCharArray()) {
            if (Character.isLetter(var) && !variableValues.containsKey(var)) {
                System.out.print("Enter value for " + var + ": ");
                variableValues.put(var, scanner.nextInt());
            }
        }

        // Convert infix to postfix
        InfixToPostfixConverter converter = new InfixToPostfixConverter();
        String postfixExpression = converter.convertInfixToPostfix(infixExpression);
        System.out.println("\nPostfix Notation: " + postfixExpression);

        // Evaluate postfix expression
        PostfixEvaluator evaluator = new PostfixEvaluator();
        int result = evaluator.evaluatePostfix(postfixExpression, variableValues);
        System.out.println("Generated Result: " + result);
    }
}
