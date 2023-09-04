import org.w3c.dom.NodeList;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {
    ArrayList<Integer> indegreeList = new ArrayList<Integer>();
    ArrayList<Node> NodeList = new ArrayList<Node>();
    private Node curr = null;
    private Node start = null;
    private Node prev = null;
    private int temp1;
    private int temp2;


    public void addNode(String label) {
        if (start == null) {            // if start == null, insert a first element into an empty list
            Node newNode = new Node();  // create the new element, info and link are set to null.
            newNode.name = label;
            NodeList.add(newNode);// and assign the data given as parameter. The link is left as null
            start = newNode;            // start is updated to point to the new element
            curr = start;                // curr is updated to point to the new first (and only) element
            newNode.indegree = 0;
            indegreeList.add(0);

        } else if (prev == null) { // a new first element is inserterd into a non-empty list

            Node newNode = new Node();  // a new node is created ...
            newNode.name = label;
            NodeList.add(newNode);  // and assigned the data given as parameter
            newNode.link = start;       // and linked before the old first element
            start = newNode;            // start is updated to point to the new first element
            curr = newNode;            // curr is updated to point to the new first element
            newNode.indegree = 0;
            indegreeList.add(0);

        } else { // a new element is inserted last (if prev.link == null) or between prev and curr

            Node newNode = new Node();  // create a new node
            newNode.name = label;
            NodeList.add(newNode);      // assign it the data given as parameter
            newNode.link = prev.link;   // link it before curr ...
            prev.link = newNode;        // ... and after previous
            curr = newNode;            // update curr to point to newNode
            newNode.indegree = 0;
            indegreeList.add(0);
        }
        System.out.println("Node Added");
    }

    public void addEdge(String label1, String label2) {
        int i;
        for (i = 0; i < NodeList.size(); i++) {
            if (NodeList.get(i).name == label1) {
                temp1 = i;
            }
        }
        int j;
        for (j = 0; j < NodeList.size(); j++) {
            if (NodeList.get(j).name == label2) {
                temp2 = j;
            }
        }
        NodeList.get(temp1).neighbour.add(NodeList.get(temp2));
        NodeList.get(temp2).indegree++;
        indegreeList.set(temp2, indegreeList.get(temp2) + 1);
        System.out.println("Edge created");
    }



    public Node findNewNodeOfIndegreeZero() {

        for (int i : indegreeList) {
            if (i == 0) {
                return NodeList.get(i);
            }
        }
        return null;
    }


    public ArrayList getNodeList() {
        ArrayList<String> NodeNames = new ArrayList<>();
        for (int k = 0; k < NodeList.size(); k++) {
            NodeNames.add(NodeList.get(k).name);
        }
        return NodeNames;
    }
    public void printSortedList(ArrayList<Node> list) {
        ArrayList<String> sortedNames = new ArrayList<>();
        for (int k = 0; k < list.size(); k++) {
            sortedNames.add(list.get(k).name);
        }
        System.out.println(sortedNames);
    }

    public ArrayList<Node> topsort() throws Cyclefound {

        ArrayList<Node> sorted = new ArrayList<>();
        ArrayQueue<Node> q = new ArrayQueue<Node>(Node.class, 100);
        int counter = 0;
        while(sorted.size() < getNodeList().size()){
        for (Node i : NodeList) {
            if (i.indegree == 0) {
                q.enqueue(i);
            }
        }
        while (!q.isEmpty()) {
            Node v = q.dequeue();
            v.topNum = ++counter;
            sorted.add(v);
            for (Node k : v.neighbour) {
                if (--k.indegree == 0) {
                    q.enqueue(k);
                }
            }
        }
        }
        if(counter != getNodeList().size()) {
            throw new Cyclefound("Cycle found in graph");
        }
        System.out.println(sorted);
        return sorted;
    }
}
