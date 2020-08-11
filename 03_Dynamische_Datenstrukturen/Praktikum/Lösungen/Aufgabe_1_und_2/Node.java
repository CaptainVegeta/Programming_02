package Kapitel3_Dynamische_Datenstrukturen.Praktikum.Aufgabe_1_und_2;

public class Node {

    public Object object;
    public Node parent;
    public Node child;

    public Node(Object object, Node parent){
        this.object = object;
        this.parent = parent;
        if (parent != null){
            this.parent.setChild(this);
        }
    }

    public Node next(){
        return this.child;
    }

    public Node previous(){
        return this.parent;
    }

    public void setChild(Node newChild){
        Node curr_node = this;
        while(curr_node.child != null){
            curr_node = curr_node.child;
        }
        curr_node.child = newChild;
        curr_node.child.parent = curr_node;
    }

    public Object getContent(){
        return object;
    }
}