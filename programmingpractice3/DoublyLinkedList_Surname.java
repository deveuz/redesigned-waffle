/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programmingexercise3;

/**
 *
 * @author klzpo
 */
public class DoublyLinkedList_Surname {
    Employee Head;
    Employee Tail;
    int numberOfItems;

    public DoublyLinkedList_Surname() {
        MakeEmpty();
    }

    public void MakeEmpty() {
        Head = new Employee();
        Tail = new Employee();
        Head.setNext(Tail);
        Tail.setPrevious(Head);
        numberOfItems = 0;
    }

    public void insertAtHead(Employee E) {
        E.setNext(Head.getNext());
        E.setPrevious(Head);
        Head.getNext().setPrevious(E);
        Head.setNext(E);
        numberOfItems++;
    }

    public void insertAtTail(Employee E) {
        E.setNext(Tail);
        E.setPrevious(Tail.getPrevious());
        Tail.getPrevious().setNext(E);
        Tail.setPrevious(E);
        numberOfItems++;
    }

    public void insertAtIndex(Employee E, int location) {
        if (location < 0 || location > numberOfItems) {
            System.out.println("Invalid index");
            return;
        }

        Employee nav = findByIndex(location);
        if (nav != null) {
            E.setNext(nav);
            E.setPrevious(nav.getPrevious());
            nav.getPrevious().setNext(E);
            nav.setPrevious(E);
            numberOfItems++;
        }
    }

    public Employee findByIndex(int location) {
        if (numberOfItems > 0 && location >= 0 && location < numberOfItems) {
            int x = 0, y = numberOfItems - 1;
            Employee nav1 = Head.getNext();
            Employee nav2 = Tail.getPrevious();
            while (x <= y) {
                if (x == location) return nav1;
                if (y == location) return nav2;
                nav1 = nav1.getNext();
                nav2 = nav2.getPrevious();
                x++;
                y--;
            }
        }
        return null;
    }
    
    public Employee getFirstNode() {
        return Head.getNext(); // Returns the first employee node
    }

    public void deleteFirst() {
        if (numberOfItems > 0) {
            Employee first = Head.getNext();
            Head.setNext(first.getNext());
            first.getNext().setPrevious(Head);
            numberOfItems--;
        } else {
            System.out.println("List is empty, cannot delete first element.");
        }
    }

    public void deleteLast() {
        if (numberOfItems > 0) {
            Employee last = Tail.getPrevious();
            Tail.setPrevious(last.getPrevious());
            last.getPrevious().setNext(Tail);
            numberOfItems--;
        } else {
            System.out.println("List is empty, cannot delete last element.");
        }
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= numberOfItems) {
            System.out.println("Invalid index, cannot delete.");
            return;
        }

        Employee toDelete = findByIndex(index);
        if (toDelete != null) {
            toDelete.getPrevious().setNext(toDelete.getNext());
            toDelete.getNext().setPrevious(toDelete.getPrevious());
            numberOfItems--;
        } else {
            System.out.println("Employee not found at index " + index);
        }
    }

    public Employee searchEmployeeName(String name) {
        Employee nav = Head.getNext();
        while (nav != Tail) {
            if (nav.getName().equals(name)) return nav;
            nav = nav.getNext();
        }
        return null;
    }

    public Employee searchEmployeeID(int ID) {
        Employee nav = Head.getNext();
        while (nav != Tail) {
            if (nav.getID() == ID) return nav;
            nav = nav.getNext();
        }
        return null;
    }

    public Employee findByValue(int index) {
        if (index >= 0 && index < numberOfItems) {
            Employee nav = Head.getNext(); // Start at the first real employee
            for (int i = 0; i < index; i++) {
                nav = nav.getNext(); // Traverse to the desired index
            }
            return nav; // Return the found employee
        }
        return null; // Return null if index is out of bounds
    }

    public Employee Next(Employee E) {
        return E.getNext();
    }

    public Employee Previous(Employee E) {
        return E.getPrevious();
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        Employee nav = Head.getNext();
        while (nav != Tail) {
            str.append(nav.toString()).append("\n\n");
            nav = nav.getNext();
        }
        return str.toString();
    }
}
