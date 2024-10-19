/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programmingpractice1;

/**
 *
 * @author klzpo
 */
public class EmployeeApplication {
     public static void main(String[] args) {
        // Launch the new GUI frame
        java.awt.EventQueue.invokeLater(() -> {
            new EmployeeManagementFrame().setVisible(true);
        });
    }
}
