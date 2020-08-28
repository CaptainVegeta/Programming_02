/**
 * NodeList
 * Diese Klasse soll mithilfe der Node-Klasse die dynamische
 * Liste darstellen. Durch eine Referenz auf den ersten Node (root) 
 * soll ein Einstiegspunkt in die Verkettung bestehen.
 */
public class NodeList {
    Node root = null;

    //Fügt einen neuen Node mit entsprechendem Inhalt (Object) hinzu. Ist kein
    //Node vorhanden, wird der neue Node zum root Node
    public void add(Object content){
        if (root == null) {
            Node a = new Node(content, root);
            root = a;
        } else {
            Node node = root;
            while(node.next() != null){
                node = node.next();
            }
            Node a = new Node(content, node);
        }
    }

    //Gibt das Objekt des entsprechenden Nodes zurück.
    public Object get(int index){
        Node node = root;
        for (int i = 0; i < index; i++) {
            node = node.next();
        }
        return node.getContent();
    }

    public void remove(int index){
        Node node = root;
        if (index == 0) {
            //neuer Root wird der Child vom alten Root
            Node newRoot;
            newRoot = node.next(); 
            root = newRoot;
        }
        else {
            for (int i = 0; i < index; i++) {
                node = node.next();
            }
            //Parent of index-node gets a new child. New child is child of index-node. a->b->c => a->c 
            node.previous().setChild(node.next());
        }
    }

    public int getLength(){
        Node node = root;
        int i = 1;
        while(node.next() != null){
            node = node.next();
            i++;
        }
        return i;
    }
}