/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programmingpractice1;

/**
 *
 * @author klzpo
 */
public class DS_EmployeeList_Array {
    final int arraySize = 100; // Initial array size
    Employee[] EmployeeList; // Reference array object
    int size;

    // Constructor
    DS_EmployeeList_Array() {
        EmployeeList = new Employee[arraySize];
        size = 0;
    }
    
    // Method to replace the current list with a new one
    public void setEmployees(Employee[] employees) {
        clear(); // Clears the current list
        for (Employee employee : employees) {
            addItem(employee); // Adds each employee from the new list
        }
    }
    
    // Method to clear the current list
    public void clear() {
        EmployeeList = new Employee[arraySize]; // Reset to initial size
        size = 0;
    }

    // Method to add an employee
    public void addItem(Employee E) {
        if (size < arraySize) {
            EmployeeList[size] = new Employee(E);
            size++;
        } else {
            System.out.println("Error: Cannot add more employees, list is full.");
        }
    }

    // Method to add an employee at a specific index
    public void addItem(int i, Employee E) {
        if (i >= 0 && i < size && size < arraySize) {
            // Shift elements to the right to make space
            for (int j = size; j > i; j--) {
                EmployeeList[j] = EmployeeList[j - 1];
            }
            EmployeeList[i] = new Employee(E);
            size++;
        } else {
            System.out.println("Error: Invalid index or list is full.");
        }
    }

    // Method to get employee by index
    public Employee searchbyIndex(int i) {
        if (i >= 0 && i < size) {
            return EmployeeList[i];
        } else {
            System.out.println("Error: Index out of bounds.");
            return null;
        }
    }

    // Method to get employee by name
    public Employee searchbyName(String n) {
        for (int i = 0; i < size; i++) {
            if (EmployeeList[i].getName().equals(n)) {
                return EmployeeList[i];
            }
        }
        System.out.println("Error: Employee with name " + n + " not found.");
        return null;
    }

    // Method to get employee by ID
    public Employee searchbyID(int id) {
        for (int i = 0; i < size; i++) {
            if (EmployeeList[i].getID() == id) {
                return EmployeeList[i];
            }
        }
        System.out.println("Employee with ID " + id + " not found. You may proceed to create one.");
        return null;
    }

    // Method to remove the last employee
    public void remove() {
        if (size > 0) {
            EmployeeList[size - 1] = null;
            size--;
        } else {
            System.out.println("Error: No items to remove.");
        }
    }

    // Method to remove an employee by index
    public void removebyIndex(int i) {
        if (i >= 0 && i < size) {
            for (int j = i; j < size - 1; j++) {
                EmployeeList[j] = EmployeeList[j + 1];
            }
            EmployeeList[size - 1] = null;
            size--;
        } else {
            System.out.println("Error: Index out of bounds.");
        }
    }

    // Method to get the next employee
    public Employee Next(Employee E) {
        for (int i = 0; i < size - 1; i++) {
            if (EmployeeList[i].equals(E)) {
                return EmployeeList[i + 1];
            }
        }
        System.out.println("Error: No next employee found.");
        return null;
    }

    // Method to get the previous employee
    public Employee Previous(Employee E) {
        for (int i = 1; i < size; i++) {
            if (EmployeeList[i].equals(E)) {
                return EmployeeList[i - 1];
            }
        }
        System.out.println("Error: No previous employee found.");
        return null;
    }

    // Method to get the string representation of the employee list
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < size; i++) {
            str.append(EmployeeList[i].toString()).append("\n\n");
        }
        return str.toString();
    }

    // Method to get the size of the employee list
    public int getSize() {
        return size;
    }
}

