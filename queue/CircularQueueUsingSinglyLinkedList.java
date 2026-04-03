package queue;

class Node{
	int data;
	Node next;
	
	Node(int data){
		this.data=data;
		this.next=null;
	}
}

public class CircularQueueUsingSinglyLinkedList {
	
	Node front;
	Node rear;
	
	void enqueue(int val) {
		Node newNode=new Node(val);
		if(front==null && rear==null) {
			front=newNode;
			rear=newNode;
			rear.next=front;
			return;
		}
		
		rear.next=newNode;
		rear=newNode;
		rear.next=front;
		
	}
	
	void dequeue() {
		if(front==null && rear==null) {
			System.out.print("Queue Is Empty");
			return;
		}
		
		if(front==rear) {
			System.out.print(front.data);
			front=null;
			rear=null;
			return;
		}
		
		System.out.println(front.data);
		front=front.next;
		rear.next=front;
		
	}
	
	void display() {
		
		if(front==null) {
			System.out.print("Circular Queue Is Empty");
			return;
		}
		
		Node temp=front;
		while(temp.next!=front) {
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
		System.out.println();
	}
	
	
	

	public class Main {
	    public static void main(String[] args) {
	        CircularQueueUsingSinglyLinkedList cq = new CircularQueueUsingSinglyLinkedList();
	        cq.enqueue(10);
	        cq.enqueue(20);
	        cq.enqueue(30);
	        cq.enqueue(40);

	        System.out.println("Enqueue elements:");
	        cq.display();

	        System.out.println("Dequeuing elements:");
	        cq.dequeue();
	        cq.dequeue();

	       

	        

	        cq.dequeue();
	        cq.dequeue();
	        cq.dequeue();
	        cq.dequeue();

	        System.out.println("Queue after removing all elements:");
	        cq.display();
	    }
	}

}
