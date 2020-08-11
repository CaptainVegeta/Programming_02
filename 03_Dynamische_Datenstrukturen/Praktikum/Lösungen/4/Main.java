import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Main {
    private static String file_name = "phone_list.txt";
    private static ArrayList<String> lines;
    private static HashMap<String, User> users_hash;
    private static ArrayList<User> users_list;
    private static long tick_start;

    public static void main(String[] args) {
        lines = new ArrayList<String>();
        users_hash = new HashMap<String, User>();
        users_list = new ArrayList<User>();

        // read file and store lines in array list
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(file_name)));
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.err.println("Datei konnte nicht geladen werden.");
            e.printStackTrace();
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Fehler beim Lesen");
            e.printStackTrace();
            System.exit(1);
        }

        // fill user lists (comment out for test)
        //      hash list
        tick(true);
        for (String line : lines) {
            String[] names = line.split("\\s+");
            if (names.length < 2) {
                System.err.println("Zeile besitzt weniger als 2 Namen.");
            } else {
                incrementCallerHash(names[0]);
                incrementCalleeHash(names[1]);
            }
        }
        tick(false);

        //      array list
        tick(true);
        for(String line : lines){
            String[] names = line.split("\\s+");
            if(names.length < 2){
                System.err.println("Zeile besitzt weniger als 2 Namen.");
            } else {
                incrementCallerList(names[0]);
                incrementCalleeList(names[1]);
            }
        }
        tick(false);

        // sort lists
        Comparator<User> comparator = new Comparator<User>() {
            @Override
            public int compare(User user_1, User user_2) {
                return user_2.getNumberCalled() - user_1.getNumberCalled();
            }
        };
        ArrayList<User> sort_hash = new ArrayList<User>(users_hash.values());
        sort_hash.sort(comparator);
        users_list.sort(comparator);
        
        // print out one list
        for(User user : sort_hash){
            System.out.println(user.getId());
            System.out.println("\t\t" + user.getNumberCalled() + "\t" + user.getNumberGetCalled());
        }
    }

    private static void incrementCallerHash(String name){
        User user = getOrCreateUserHash(name);
        user.incrementCaller();
    }

    private static void incrementCalleeHash(String name){
        User user = getOrCreateUserHash(name);
        user.incrementCallee();
    }

    private static User getOrCreateUserHash(String name){
        User user = users_hash.get(name);
        if(user == null){
            user = new User(name);
            users_hash.put(name, user);
        }

        return user;
    }

    private static void incrementCallerList(String name){
        User user = getOrCreateUserList(name);
        user.incrementCaller();
    }

    private static void incrementCalleeList(String name){
        User user = getOrCreateUserList(name);
        user.incrementCallee();
    }

    private static User getOrCreateUserList(String name){
        for(User user : users_list){
            if(user.getId().equals(name)){
                return user;
            }
        }

        User user = new User(name);
        users_list.add(user);

        return user;
    }

    private static void tick(boolean start){
        if(start){
            tick_start = System.currentTimeMillis();
        } else {
            long tick_end = System.currentTimeMillis();
            float tick = (tick_end - tick_start);
            System.out.println(tick);   
        }
    }
}