package com.company;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        Telefonliste telefonliste = new Telefonliste();
        telefonliste.read();
        telefonliste.printHatAngerufen();
        telefonliste.printWurdeAngerufen();
    }
}

