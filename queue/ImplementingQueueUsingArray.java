package queue;

public class ImplementingQueueUsingArray {
	
	
	    private int size;
	    private int[] arr;
	    private int front, rear;

	    
	    public ImplementingQueueUsingArray(int size) {
	        this.size = size;
	        arr = new int[size];
	        front = -1;
	        rear = -1;
	    }

	    public void enqueue(int value) {
	        if (rear == size - 1) {
	            System.out.println("Queue is full!");
	            return;
	        }
	        if (front == -1) front = 0; 
	        arr[++rear] = value;
	        System.out.println(value + " enqueued");
	    }

	    public void dequeue() {
	        if (front == -1 || front > rear) {
	            System.out.println("Queue is empty!");
	            return;
	        }
	        System.out.println(arr[front] + " dequeued");
	        front++;
	    }

	    public void peek() {
	        if (front == -1 || front > rear) {
	            System.out.println("Queue is empty!");
	        } else {
	            System.out.println("Front element: " + arr[front]);
	        }
	    }

	    public void display() {
	        if (front == -1 || front > rear) {
	            System.out.println("Queue is empty!");
	            return;
	        }
	        System.out.print("Queue elements: ");
	        for (int i = front; i <= rear; i++) {
	            System.out.print(arr[i] + " ");
	        }
	        System.out.println();
	    }
	    
	    public static void main(String[] args) {
	    	ImplementingQueueUsingArray q = new ImplementingQueueUsingArray(5);
	        q.enqueue(10);
	        q.enqueue(20);
	        q.enqueue(30);
	        q.display();
	        q.dequeue();
	        q.peek();
	        q.display();
	    }
	}
	
	

