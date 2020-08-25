import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Highscore {
    public String[] score;
    public String path;
 
    public Highscore(String path){
        this.path = path;
        readScore(path);
    }
    
    public void readScore(String path){
        if(checkFile(path)){    // Der Try-Catch-Block sollte nicht für die Überprüfung, ob die Datei vorhanden ist, verwendet werden, sondern nur bei Ausnahmefällen. Daher wird ein direkter Test mit der Klasse File durchgeführt.
            try{
                FileReader reader = new FileReader(path);
                BufferedReader buffered_reader = new BufferedReader(reader);
                String full_content = "";
                String line;
                while((line = buffered_reader.readLine()) != null){
                    full_content = full_content + line + "|";       // erstelle verketteter Score mit "|"-Abtrennung
                }
                score = full_content.split("\\|");    // Erzeuge aus der Kette ein Array.
                buffered_reader.close();
            } catch(IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Score nicht vorhanden.");
        }
    }

    public boolean checkFile(String path){
        File file = new File(path);
        return file.exists();
    }

    public void showHighscore(){
        if(score != null){
            System.out.println("=== Score ===");
            for(int i = 0; i < score.length; i++){
                String components[] = score[i].split(":");
                if(components.length == 2){
                    System.out.println(components[0] + ": " + components[1]);
                }
            }
            System.out.println("==========");
        }
    }

    public void addScore(String player_name, int new_score_value){
        if(score == null){
            score = new String[1];
            score[0] = player_name + ":" + new_score_value;
        } else {
            String new_score[] = new String[score.length + 1];
            for(int i = 0; i < score.length; i++){
                new_score[i] = score[i];
            }
            new_score[score.length] = player_name + ":" + new_score_value;
            score = sortScore(new_score);
        }
    }

    public void saveHighscore(){
        try {
            FileWriter writer = new FileWriter(path);
            BufferedWriter buffered_writer = new BufferedWriter(writer);
            for(int i = 0; i < score.length; i++){
                if(i > 0){
                    buffered_writer.newLine();
                }
                buffered_writer.write(score[i]);
            }
            buffered_writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String[] sortScore(String score[]){
        // Bubble-Sort
        if(score.length > 1){
            boolean changed;
            do{
                changed = false;
                for(int i = 0; i < score.length - 1; i++){
                    int value_1 = Integer.parseInt(score[i].split("\\:")[1]);
                    int value_2 = Integer.parseInt(score[i + 1].split("\\:")[1]);
                    if(value_1 < value_2){
                        String tmp = score[i + 1];
                        score[i + 1] = score[i];
                        score[i] = tmp;
                        changed = true;
                    }
                }
            } while(changed);
        }
        return score;
    }
}