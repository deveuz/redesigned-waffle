/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programmingpractice1;

/**
 *
 * @author klzpo
 */
public class DS_EmployeeList_Sorted extends DS_EmployeeList_Array {
    
    // Constructor
    public DS_EmployeeList_Sorted() {
        super();  // Call the superclass constructor
    }

    // Main method to prompt for sorting technique and sort accordingly
    public void sortByID(String technique) {
        switch (technique.toLowerCase()) {
            case "selection":
                selectionSort();
                break;
            case "double selection":
                doubleSelectionSort();
                break;
            case "bubble":
                bubbleSort();
                break;
            case "insertion":
                insertionSort();
                break;
            case "quick":
                quicksort(0, getSize() - 1);
                break;
            case "merge":
                mergeSort(0, getSize() - 1);
                break;
            default:
                System.out.println("Invalid sorting technique.");
        }
    }

    // Quicksort Method
    private void quicksort(int low, int high) {
        if (low < high) {
            int pi = partition(low, high);
            quicksort(low, pi - 1);
            quicksort(pi + 1, high);
        }
    }

    private int partition(int low, int high) {
        Employee pivot = EmployeeList[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (EmployeeList[j].getID() <= pivot.getID()) {
                i++;
                Employee temp = EmployeeList[i];
                EmployeeList[i] = EmployeeList[j];
                EmployeeList[j] = temp;
            }
        }

        Employee temp = EmployeeList[i + 1];
        EmployeeList[i + 1] = EmployeeList[high];
        EmployeeList[high] = temp;

        return i + 1;
    }

    // Selection Sort
    private void selectionSort() {
        int n = getSize();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (EmployeeList[j].getID() < EmployeeList[minIndex].getID()) {
                    minIndex = j;
                }
            }
            swap(i, minIndex);
        }
    }

    // Double Selection Sort (Bidirectional Selection Sort)
    private void doubleSelectionSort() {
        int n = getSize();
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int minIndex = left;
            int maxIndex = right;
            for (int i = left; i <= right; i++) {
                if (EmployeeList[i].getID() < EmployeeList[minIndex].getID()) {
                    minIndex = i;
                }
                if (EmployeeList[i].getID() > EmployeeList[maxIndex].getID()) {
                    maxIndex = i;
                }
            }
            swap(left, minIndex);
            if (maxIndex == left) {
                maxIndex = minIndex;
            }
            swap(right, maxIndex);
            left++;
            right--;
        }
    }

    // Bubble Sort
    private void bubbleSort() {
        int n = getSize();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (EmployeeList[j].getID() > EmployeeList[j + 1].getID()) {
                    swap(j, j + 1);
                }
            }
        }
    }

    // Insertion Sort
    private void insertionSort() {
        int n = getSize();
        for (int i = 1; i < n; i++) {
            Employee key = EmployeeList[i];
            int j = i - 1;
            while (j >= 0 && EmployeeList[j].getID() > key.getID()) {
                EmployeeList[j + 1] = EmployeeList[j];
                j--;
            }
            EmployeeList[j + 1] = key;
        }
    }

    // Merge Sort
    private void mergeSort(int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(l, m);
            mergeSort(m + 1, r);
            merge(l, m, r);
        }
    }

    private void merge(int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        Employee[] L = new Employee[n1];
        Employee[] R = new Employee[n2];

        for (int i = 0; i < n1; i++)
            L[i] = EmployeeList[l + i];
        for (int j = 0; j < n2; j++)
            R[j] = EmployeeList[m + 1 + j];

        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i].getID() <= R[j].getID()) {
                EmployeeList[k] = L[i];
                i++;
            } else {
                EmployeeList[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            EmployeeList[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            EmployeeList[k] = R[j];
            j++;
            k++;
        }
    }

    // Utility method to swap elements
    private void swap(int i, int j) {
        Employee temp = EmployeeList[i];
        EmployeeList[i] = EmployeeList[j];
        EmployeeList[j] = temp;
    }
}
