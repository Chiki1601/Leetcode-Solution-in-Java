// A class to represent a node in a linked list
class Node {
  // The previous and next nodes in the list
  public Node prev;
  public Node next;
  // The URL represented by this node
  public final String url;
  
  // Constructor that sets the URL for this node
  public Node(final String url) {
    this.url = url;
  }
}

// A class to represent a browser history
class BrowserHistory {
  // The current node in the history
  private Node curr;
  
  // Constructor that creates a new history with the given homepage
  public BrowserHistory(String homepage) {
    // Create a new node to represent the homepage
    curr = new Node(homepage);
  }

  // Method to add a new URL to the history
  public void visit(String url) {
    // Create a new node to represent the new URL
    curr.next = new Node(url);
    // Set the previous node for the new node to be the current node
    curr.next.prev = curr;
    // Make the new node the current node
    curr = curr.next;
  }

  // Method to navigate back in the history by the given number of steps
  public String back(int steps) {
    // While there are previous nodes and we haven't gone back enough steps yet
    while (curr.prev != null && steps-- > 0) {
      // Move back one node by setting the current node to the previous node
      curr = curr.prev;
    }
    // Return the URL represented by the current node
    return curr.url;
  }

  // Method to navigate forward in the history by the given number of steps
  public String forward(int steps) {
    // While there are next nodes and we haven't gone forward enough steps yet
    while (curr.next != null && steps-- > 0) {
      // Move forward one node by setting the current node to the next node
      curr = curr.next;
    }
    // Return the URL represented by the current node
    return curr.url;
  }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
