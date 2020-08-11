public class User {
    private String id;
    private int number_called;
    private int number_get_called;
    
    public User(String id){
        this.number_called = 0;
        this.number_get_called = 0;
        this.id = id;
    }

    public void incrementCaller(){
        number_called++;
    }

    public void incrementCallee(){
        number_get_called++;
    }

    public String getId(){
        return this.id;
    }

    public int getNumberCalled(){
        return this.number_called;
    }

    public int getNumberGetCalled(){
        return this.number_get_called;
    }
}