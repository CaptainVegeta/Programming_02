public class NodeList {
    private Node root;
    
    public void add(Object content){
        if(root == null){
            root = new Node(content, null);
        } else {
            Node node = root;
            while(node.next() != null){
                node = node.next();
            }
            new Node(content, node);
        }
    }

    public Object get(int index){
        Node node = getNode(index);
        return node.getContent();
    }

    public void remove(int index){
        Node node = getNode(index);
        node.previous().setChild(node.next());
    }

    private Node getNode(int index){
        Node node = root;
        
        for(int i = 0; i < index; i++){
            node = node.next();
        }

        return node;
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