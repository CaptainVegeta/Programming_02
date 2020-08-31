package com.company;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;

public class Telefonliste {
    String path = "C:\\Users\\tokma_000\\Desktop\\TEKO\\Semester_04\\Programming_02\\03_Dynamische_Datenstrukturen\\Praktikumsaufgaben\\Aufgabe_04\\src\\com\\company\\phone_list.txt";
    FileReader reader = null;
    BufferedReader bufferedReader = null;
    HashMap<String, Integer> hatAngerufen = new HashMap<String, Integer>();
    HashMap<String, Integer> wurdeAngerufen = new HashMap<String, Integer>();


    public void read(){
        boolean hasNext = true;
        String line;
        try {
            reader = new FileReader(path);
            bufferedReader = new BufferedReader(reader);
            while (hasNext){
                if ((line = bufferedReader.readLine()) == null) {
                    hasNext = false;
                } else{
                    // Twana Blaine -> array[0] = Twana & array[1] = Blaine
                    String[] array = line.split(" ");
                    //füge Anrufer in die HashMap
                    setHatAngerufen(array[0]);
                    //füge Empfänger in die HashMap
                    setWurdeAngerufen(array[1]);
                }
            }
            bufferedReader.close();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public void setHatAngerufen(String anrufer){
        boolean vorhanden = false;
        Integer value = 0;
        //Da Hashmap am Anfang leer ist
        if (hatAngerufen.size() == 0){
            hatAngerufen.put(anrufer, 1);
        } else{
            //gehe vorhandene Liste durch
            for (String s : hatAngerufen.keySet()) {
                //falls anrufer bereits in der Liste vorhanden, dann erhöhe value um 1
                if(anrufer.equals(s)){
                    value = hatAngerufen.get(s);
                    value += 1;
                    vorhanden = true;
                } else{
                    vorhanden = false;
                }
            }
            //avoid ConcurrentModificationException
            if (vorhanden){
                hatAngerufen.put(anrufer, value);
            } else{
                hatAngerufen.put(anrufer, 1);
            }
        }
    }

    public void setWurdeAngerufen(String empfaenger){
        boolean vorhanden = false;
        Integer value = 0;
        if (wurdeAngerufen.size() == 0){
            wurdeAngerufen.put(empfaenger, 1);
        } else {
            for (String s : wurdeAngerufen.keySet()) {
                if (empfaenger.equals(s)){
                    value = wurdeAngerufen.get(s);
                    value += 1;
                    vorhanden = true;
                } else {
                    vorhanden = false;
                }
            }
            if (vorhanden){
                wurdeAngerufen.put(empfaenger, value);
            } else{
                wurdeAngerufen.put(empfaenger, 1);
            }
        }
    }

    public void printHatAngerufen(){
        for (String i : hatAngerufen.keySet()) {
            System.out.println("key: " + i + " - value: " + hatAngerufen.get(i));
        }
        System.out.println("************************");
    }

    public void printWurdeAngerufen(){
        for (String i : wurdeAngerufen.keySet()) {
            System.out.println("key: " + i + " - value: " + wurdeAngerufen.get(i));
        }
        System.out.println("************************");
    }
}
