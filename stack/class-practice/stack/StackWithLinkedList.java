package stack;

public class StackWithLinkedList {
	
    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    private Node head;

    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public int pop() {
        if (head == null) {
        	 System.out.println("Stack Underflow");
             return -1;
        }
        int value = head.val;
        head = head.next;
        return value;
    }

    public int peek() {
        if (head == null) {
        	 System.out.println("Stack Is Empty");
             return -1;
        }
        return head.val;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void printStack() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StackWithLinkedList stack = new StackWithLinkedList();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        stack.printStack(); 

        System.out.println("Top element: " + stack.peek()); 
        System.out.println("Popped: " + stack.pop());       

        stack.printStack(); 
    }
}