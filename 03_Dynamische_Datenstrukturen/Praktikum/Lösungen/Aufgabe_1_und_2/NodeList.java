package Kapitel3_Dynamische_Datenstrukturen.Praktikum.Aufgabe_1_und_2;

public class NodeList {
    
    public Node root;

    public void add(Object object){
        if (root == null){
            root = new Node(object, null);
        } else{
            new Node(object, root);
        }
    }

    public Object get(int position){
        Node currentNode = root;
        while (position > 0){
            currentNode = currentNode.child;
            position -= 1;
        }
        return currentNode.object;
    }

    public void remove(int position){
        Node currentNode = root;
        while (position > 0){
            currentNode = currentNode.child;
            position -= 1;
        }
        currentNode.child.parent = currentNode.parent;
        currentNode.parent.child = currentNode.child;
    }

    public int getLength(){
        if (root == null){
            return 0;
        }

        int counter = 1;
        Node currentNode = root;
        while (currentNode.child != null){
            currentNode = currentNode.child;
            counter += 1;
        }
        return counter;
    }
}