import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class LinkedList<T> implements Iterable<T>  {


    private Node start, curr, prev;

    public LinkedList() {

        curr = null;  	 // the curr position in the list
        start = null;    // the first element
        prev = null;     // the node before curr
    }

    public void add(T x) {

        if (start == null) {     		// if start == null, insert a first element into an empty list
            Node newNode = new Node();  // create the new element, info and link are set to null.
            newNode.info = x; 			// and assign the data given as parameter. The link is left as null
            start = newNode;			// start is updated to point to the new element
            curr = start;     			// curr is updated to point to the new first (and only) element

        } else if (prev == null) { // a new first element is inserterd into a non-empty list

            Node newNode = new Node();  // a new node is created ...
            newNode.info = x;			// and assigned the data given as parameter
            newNode.link = start;       // and linked before the old first element
            start = newNode;            // start is updated to point to the new first element
            curr = newNode;          	// curr is updated to point to the new first element

        } else { // a new element is inserted last (if prev.link == null) or between prev and curr

            Node newNode = new Node();  // create a new node
            newNode.info = x;		    // assign it the data given as parameter
            newNode.link = prev.link;   // link it before curr ...
            prev.link = newNode;        // ... and after previous
            curr = newNode;          	// update curr to point to newNode
        }

    } // add

    public void remove() { 				// removes the current node

        if (isEmpty() || endOfList()) { // no node to be removed
            return;
        }
        else {                        	// curr points to the element to be removed
            if (prev == null) {         // remove a first element: start is updated!
                start = start.link;     // "jump over" the first element (curr/start)
                curr = start;        	// update curr to point to the new start
            }
            else {                    	// the element to be removed is in the middle of the list/last
                prev.link = curr.link;  // "jump over it!"
                curr = curr.link;    	// curr is updated to the element after the removed one
            }
        }
    } // remove

    public boolean isEmpty() { // checks if the list is empty
        return start == null;
    }

    public T retrieveCurr() { // return the curr element's data
        return curr.info;
    }

    public void reset() { // resets a list so that curr points to the first element

        curr = start;  	  // curr starts from the beginning of the list
        prev = null;      // there is no previous element for curr
    }

    public boolean endOfList() { // has curr reached and passed the end of the list?

        return curr == null;
    }

    public void succ() { // moves curr to the next element

        curr = curr.link; 		// curr is set to the next node
        if (prev == null) {     // previous must follow; if it was null to begin with ...
            prev = start;       // ... it must now point to start
        }
        else {
            prev = prev.link;   // otherwise it is just moved one step forward
        }
    }

    public Iterator<T> iterator(){ //Needed to implement the iterable interface
        return new ListIterator();
    }

    private class Node {
        T info;
        Node link;

        Node() {
            info = null;
            link = null;
        }
    }

    private class ListIterator implements Iterator<T>{

        private Node curr;

        public ListIterator(){
            curr=start;
        }

        public boolean hasNext(){
            return curr!=null;
        }

        public T next(){
            if(curr==null){
                throw new NoSuchElementException();
            }
            T value=curr.info;
            curr=curr.link;
            return value;
        }
        public void remove(){
            throw new UnsupportedOperationException();

        }
    }
}