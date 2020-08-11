public class Node {
    private Node parent;
    private Node child;
    private Object content;
    
    public Node(Object content, Node parent_node){
        this.content = content;
        this.parent = parent_node;
        if(parent_node != null){
            parent_node.setChild(this);
        }
    }

    public Node next(){
        return child;
    }

    public Node previous(){
        return parent;
    }

    public void setChild(Node child){
        this.child = child;
    }

    public Object getContent(){
        return content;
    }
}