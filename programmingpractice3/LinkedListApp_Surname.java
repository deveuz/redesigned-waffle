/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programmingexercise3;

/**
 *
 * @author klzpo
 */
public class LinkedListApp_Surname {
    public static void main(String[] args) {
        DoublyLinkedList_Surname list = new DoublyLinkedList_Surname();

        // Insert employees at various locations
        list.insertAtHead(new Employee("Alice", "Manager", (byte) 30, 1001, null, null));
        list.insertAtTail(new Employee("Bob", "Engineer", (byte) 28, 1002, null, null));
        list.insertAtTail(new Employee("Charlie", "Designer", (byte) 25, 1003, null, null));
        list.insertAtIndex(new Employee("David", "Developer", (byte) 26, 1004, null, null), 1);
        list.insertAtTail(new Employee("Eva", "Tester", (byte) 27, 1005, null, null));

        // Print list of employees
        System.out.println("List of Employees:");
        System.out.println(list.toString());

        // Delete first employee
        list.deleteFirst();
        System.out.println("After deleting the first employee:");
        System.out.println(list.toString());

        // Delete last employee
        list.deleteLast();
        System.out.println("After deleting the last employee:");
        System.out.println(list.toString());

        // Insert an employee at the tail after deletions
        list.insertAtTail(new Employee("Frank", "Analyst", (byte) 29, 1006, null, null));
        System.out.println("After inserting Frank at the tail:");
        System.out.println(list.toString());

        // Delete employee at a specific index
        list.deleteAtIndex(1); // Deletes the second employee (David)
        System.out.println("After deleting the employee at index 1:");
        System.out.println(list.toString());

        // Find employee by index
        int indexToFind = 0; // Example index
        Employee foundByIndex = list.findByValue(indexToFind);
        if (foundByIndex != null) {
            System.out.println("\nEmployee found at index " + indexToFind + ": \n" + foundByIndex);
        } else {
            System.out.println("No employee found at index " + indexToFind);
        }

        // Search employee by name
        String employeeNameToSearch = "Bob"; // Example name
        Employee searchResultByName = list.searchEmployeeName(employeeNameToSearch);
        if (searchResultByName != null) {
            System.out.println("\nFound employee by name '" + employeeNameToSearch + "':  \n" + searchResultByName);
        } else {
            System.out.println("\nEmployee named '" + employeeNameToSearch + "' not found.");
        }

        // Search employee by ID
        int employeeIDToSearch = 1004; // Example ID
        Employee searchResultByID = list.searchEmployeeID(employeeIDToSearch);
        if (searchResultByID != null) {
            System.out.println("\nFound employee with ID " + employeeIDToSearch + ":  \n" + searchResultByID);
        } else {
            System.out.println("Employee with ID " + employeeIDToSearch + " not found.");
        }

        // Display next employee after first employee
        Employee firstEmployee = list.getFirstNode();
        if (firstEmployee != null) {
            Employee nextEmployee = list.Next(firstEmployee);
            if (nextEmployee != null) {
                System.out.println("\nNext employee after the first employee: \n" + nextEmployee);
            } else {
                System.out.println("There is no next employee.");
            }
        } else {
            System.out.println("The list is empty, no first employee found.");
        }

        // Display previous employee before specific employee
        if (firstEmployee != null) {
            Employee nextEmployee = list.Next(firstEmployee);
            if (nextEmployee != null) {
                Employee prevEmployee = list.Previous(nextEmployee);
                if (prevEmployee != null) {
                    System.out.println("\nPrevious employee before " + nextEmployee.getName() + ": \n" + prevEmployee);
                } else {
                    System.out.println("There is no previous employee.");
                }
            } else {
                System.out.println("No next employee to check for previous.");
            }
        }
    }
}
