package queue;

class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev=null;
    }
}

public class Deque {
	Node front;
    Node rear;
    
    public Deque() {
    	front = rear = null;
    }
    void insertAtFront(int val) {
    	Node newNode=new Node(val);
    	if(front==null) {
    		front=newNode;
    		rear=newNode;
    		return;
    		}
    	
    	newNode.next=front;
    	front.prev=newNode;
    	front=newNode;
    	
    }
    void insertAtEnd(int val) {
    	Node newNode=new Node(val);
    	if(rear==null) {
    		front=newNode;
    		rear=newNode;
    		return;
    	}
    	
    	newNode.prev=rear;
    	rear.next=newNode;
    	rear=newNode;
    }
   void display() {
        Node temp = front;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
   
   int deleteFromFront() {
	   if (front == null) {
           System.out.println("Deque is empty!");
           return -1;
       }
       int val = front.data;
       front = front.next;
       if (front != null) {
           front.prev = null;
       } else {
           rear = null; 
       }
       return val;
   }
   
   int deleteFromRear() {
	   if (rear == null) {
           System.out.println("Deque is empty!");
           return -1;
       }
       int val = rear.data;
       rear = rear.prev;
       if (rear != null) {
           rear.next = null;
       } else {
           front = null;
       }
       return val;

   }
    
   
   public class Main {
	    public static void main(String[] args) {
	        Deque q = new Deque();   
	        q.insertAtFront(10);
	        q.insertAtFront(20);
	        q.insertAtFront(30);

	       
	        q.display();

	        System.out.println("Dequeued: " + q.deleteFromFront()); 
	        q.display();
	    }
	}
   }
    
	
	


