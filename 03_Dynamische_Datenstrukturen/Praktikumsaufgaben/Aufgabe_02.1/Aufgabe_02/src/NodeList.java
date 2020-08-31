/**
 * NodeList
 * Diese Klasse soll mithilfe der Node-Klasse die dynamische
 * Liste darstellen. Durch eine Referenz auf den ersten Node (root) 
 * soll ein Einstiegspunkt in die Verkettung bestehen.
 */
public class NodeList<V> {
    Node<V> root = null;

    //Fügt einen neuen Node mit entsprechendem Inhalt (Object) hinzu. Ist kein
    //Node vorhanden, wird der neue Node zum root Node
    public void add(V content){
        if (root == null) {
            Node<V> a = new Node<V>(content, root);
            root = a;
        } else {
            Node node = root;
            while(node.next() != null){
                node = node.next();
            }
            Node<V> a = new Node<V>(content, node);
        }
    }

    //Gibt das Objekt des entsprechenden Nodes zurück.
    public V get(int index){
        Node<V> node = root;
        for (int i = 0; i < index; i++) {
            node = node.next();
        }
        return node.getContent();
    }

    public void remove(int index){
        Node<V> node = root;
        if (index == 0) {
            //neuer Root wird der Child vom alten Root
            Node<V> newRoot;
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
        Node<V> node = root;
        int i = 1;
        while(node.next() != null){
            node = node.next();
            i++;
        }
        return i;
    }
}