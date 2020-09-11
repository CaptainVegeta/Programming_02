/**
 * Node
 * Schreiben Sie eine Klasse Node, die jeweils eine Referenz zu einem 
 * vorherigen (parent) und darauffolgenden (child) Node besitzt. 
 * Dabei soll jede Node eine Referenz zu einem Object besitzen:
 */
public class Node<V> {
    private Node<V> parent;
    private Node<V> child;
    private V content;

    public Node(V content, Node parent_node){
        this.content = content;
        this.parent = parent_node;
        if (parent_node != null) {
            parent_node.setChild(this);
        }
    }

    //Gibt den vorherigen (parent) Node zurück.
    public Node<V> previous(){
        return parent;
    }

    //Gibt den nächsten (child) Node zurück.
    public Node<V> next(){
        return child;
    }

    //Setzt den nächsten (child) Node.
    public void setChild(Node<V> child){
        this.child = child; 
    }

    //Gibt das referenzierte Objekt zurück.
    public V getContent(){
        return content;
    }
}