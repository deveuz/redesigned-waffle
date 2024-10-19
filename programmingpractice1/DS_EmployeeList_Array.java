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
    final int arraySize = 100;
    Employee[] EmployeeList; // reference array object
    int size;

    DS_EmployeeList_Array() {
        EmployeeList = new Employee[arraySize];
        size = 0;
    }

    public void addItem(Employee E) {
        if (size < arraySize) {
            EmployeeList[size] = new Employee(E);
            size++;
        } else {
            System.out.println("Error: Cannot add more employees, list is full.");
        }
    }

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

    public Employee searchbyIndex(int i) {
        if (i >= 0 && i < size) {
            return EmployeeList[i];
        } else {
            System.out.println("Error: Index out of bounds.");
            return null;
        }
    }

    public Employee searchbyName(String n) {
        for (int i = 0; i < size; i++) {
            if (EmployeeList[i].getName().equals(n)) {
                return EmployeeList[i];
            }
        }
        System.out.println("Error: Employee with name " + n + " not found.");
        return null;
    }

    public Employee searchbyID(int id) {
        for (int i = 0; i < size; i++) {
            if (EmployeeList[i].getID() == id) {
                return EmployeeList[i];
            }
        }
        System.out.println("Error: Employee with ID " + id + " not found.");
        return null;
    }

    public void remove() {
        if (size > 0) {
            EmployeeList[size - 1] = null;
            size--;
        } else {
            System.out.println("Error: No items to remove.");
        }
    }

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

    public Employee Next(Employee E) {
        for (int i = 0; i < size - 1; i++) {
            if (EmployeeList[i].equals(E)) {
                return EmployeeList[i + 1];
            }
        }
        System.out.println("Error: No next employee found.");
        return null;
    }

    public Employee Previous(Employee E) {
        for (int i = 1; i < size; i++) {
            if (EmployeeList[i].equals(E)) {
                return EmployeeList[i - 1];
            }
        }
        System.out.println("Error: No previous employee found.");
        return null;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < size; i++) {
            str.append(EmployeeList[i].toString()).append("\n\n");
        }
        return str.toString();
    }

    public int getSize() {
        return size;
    }
}

