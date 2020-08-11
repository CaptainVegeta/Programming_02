public class NodeList <T>{
    private Node<T> root;
    private Node<T> iterate_node;
    private Node<T> tail;           // Optimierung Praktikum 3.6
    
    public void add(T content){
        if(root == null){
            root = new Node<T>(content, null);
            iterate_node = root;
            tail = root;
        } else {
            tail = new Node<T>(content, tail);
        }
    }

    public T get(int index){
        Node<T>  node = getNode(index);
        return node.getContent();
    }

    public T iterate(){
        Node<T>  node = iterate_node;
        iterate_node = iterate_node.next();
        return node.getContent();
    }

    public void resetIteration(){
        iterate_node = root;
    }

    public void remove(int index){
        Node<T>  node = getNode(index);
        if(node.previous() != null){
            if(node.next() != null){
                node.previous().setChild(node.next());
            } else {
                node.previous().setChild(null);
                tail = node.previous();
            }
        }
    }

    private Node<T>  getNode(int index){
        Node<T>  node = root;
        
        for(int i = 0; i < index; i++){
            node = node.next();
        }

        return node;
    }


    public int getLength(){
        Node<T>  node = root;
        int i = 1;
        while(node.next() != null){
            node = node.next();
            i++;
        }

        return i;
    }
}