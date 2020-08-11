public class Node <T>{
    private Node parent;
    private Node child;
    private T content;
    
    public Node(T content, Node parent_node){
        this.content = content;
        this.parent = parent_node;
        if(parent_node != null){
            parent_node.setChild(this);
        }
    }

    public Node<T> next(){
        return child;
    }

    public Node<T> previous(){
        return parent;
    }

    public void setChild(Node<T> child){
        this.child = child;
    }

    public T getContent(){
        return content;
    }
}