import java.awt.event.ActionEvent;

public class ActionMinus extends SimplifiedListener{
    public void actionPerformed(ActionEvent e) {

        try {
            String value_1_string = Taschenrechner.surface.input_1.getText();
            String value_2_string = Taschenrechner.surface.input_2.getText();
            float value_1 = Float.parseFloat(value_1_string);
            float value_2 = Float.parseFloat(value_2_string);
            float resultat = value_1 - value_2;
            String output = value_1_string + " - " + value_2_string + " = " + Float.toString(resultat);
            Taschenrechner.surface.log.append(output + "\n"); // Neue Zeile: \n
            Taschenrechner.surface.input_1.setText(Float.toString(resultat));
            Taschenrechner.surface.input_2.setText("");
        } catch (NumberFormatException f) {
            String fehlerMeldung = f.getMessage();
            Taschenrechner.surface.log.append(fehlerMeldung + "\n"); // Neue Zeile: \n
        } catch (NullPointerException g) {
            String fehlerMeldungNullPointer = g.getMessage();
            Taschenrechner.surface.log.append(fehlerMeldungNullPointer + "\n"); // Neue Zeile: \n
        }
    }
}