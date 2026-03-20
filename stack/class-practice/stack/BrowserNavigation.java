package stack;
import java.util.Stack;

public class BrowserNavigation {
	
	

	
	    private Stack<String> backStack = new Stack<>();
	    private Stack<String> forwardStack = new Stack<>();
	    private String currentPage;

	    public BrowserNavigation(String homepage) {
	        currentPage = homepage;
	        System.out.println("Homepage: " + currentPage);
	    }

	    public void visit(String url) {
	        backStack.push(currentPage);
	        currentPage = url;
	        forwardStack.clear(); // clear forward history
	        System.out.println("Visited: " + currentPage);
	    }

	    public void back() {
	        if (!backStack.isEmpty()) {
	            forwardStack.push(currentPage);
	            currentPage = backStack.pop();
	            System.out.println("Back to: " + currentPage);
	        } else {
	            System.out.println("No pages in back history!");
	        }
	    }

	    public void forward() {
	        if (!forwardStack.isEmpty()) {
	            backStack.push(currentPage);
	            currentPage = forwardStack.pop();
	            System.out.println("Forward to: " + currentPage);
	        } else {
	            System.out.println("No pages in forward history!");
	        }
	    }

	    public static void main(String[] args) {
	        BrowserNavigation browser = new BrowserNavigation("homepage.com");
	        browser.visit("google.com");
	        browser.visit("facebook.com");
	        browser.back();    
	        browser.forward(); 
	    }
	}


