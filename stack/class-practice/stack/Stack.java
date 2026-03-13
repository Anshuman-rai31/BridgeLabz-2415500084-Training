package stack;

import java.util.Scanner;

// Stack implementation using dynamic array resizing
class Stack {
    private int[] arr;
    private int top;
    private int capacity;

    // Constructor to initialize the stack
    public Stack(int size) {
        arr = new int[size];
        capacity = size;
        top = -1;
    }

    // Add an element to the stack
    public void push(int x) {
        // Resize if 75% full
        if (top + 1 >= capacity * 0.75) {
            resize();
        }
        arr[++top] = x;
        System.out.println("Pushed: " + x);
    }

    // Remove the top element
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow!");
            return -1;
        }
        return arr[top--];
    }

    // Return the top element without removing it
    public int peek() {
        if (!isEmpty()) {
            return arr[top];
        }
        System.out.println("Stack is empty!");
        return -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    // Resize logic: increase capacity by 50%
    private void resize() {
        int newCapacity = capacity + capacity / 2;
        int[] newArr = new int[newCapacity];
        for (int i = 0; i <= top; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
        capacity = newCapacity;
        System.out.println("Stack resized to capacity: " + capacity);
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter initial stack size: ");
        int size = sc.nextInt();
        Stack stack = new Stack(size);

        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Exit");
            System.out.print("Your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to push: ");
                    int val = sc.nextInt();
                    stack.push(val);
                    break;
                case 2:
                    int popped = stack.pop();
                    if (popped != -1) {
                        System.out.println("Popped: " + popped);
                    }
                    break;
                case 3:
                    int top = stack.peek();
                    if (top != -1) {
                        System.out.println("Top element: " + top);
                    }
                    break;
                case 4:
                    System.out.println("Exiting program...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}