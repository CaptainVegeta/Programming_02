import java.awt.event.ActionEvent;

public class ActionDivide extends SimplifiedListener{
    public void actionPerformed(ActionEvent e) {
        String value_1_string = Taschenrechner.surface.input_1.getText();
        String value_2_string = Taschenrechner.surface.input_2.getText();
        float value_1 = Float.parseFloat(value_1_string);
        float value_2 = Float.parseFloat(value_2_string);
        float resultat = value_1 / value_2;
        String output = value_1_string + " / " + value_2_string + " = " + Float.toString(resultat);
        Taschenrechner.surface.log.append(output + "\n"); // Neue Zeile: \n
        Taschenrechner.surface.input_1.setText(Float.toString(resultat));
        Taschenrechner.surface.input_2.setText("");
    }
}