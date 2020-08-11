/**
 * Node
 * Schreiben Sie eine Klasse Node, die jeweils eine Referenz zu einem 
 * vorherigen (parent) und darauffolgenden (child) Node besitzt. 
 * Dabei soll jede Node eine Referenz zu einem Object besitzen:
 */
public class Node {

    public Node parent;
    public Node child;
    public Object object;

    //Konstruktor 1
    public Node(Object element, Node parentNode){
        object = element;
        parent = parentNode;
    }

    public Node previous(){
        return parent;
    }

    public Node next(){
        return child;
    }

    public void setChild(){

    }

    public Object getContent(){
        return object;
    }
}