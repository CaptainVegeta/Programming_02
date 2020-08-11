import java.awt.event.ActionEvent;

public class ActionClear extends SimplifiedListener{
    public void actionPerformed(ActionEvent e) {
        Taschenrechner.surface.input_1.setText("");
        Taschenrechner.surface.input_2.setText("");
        Taschenrechner.surface.log.setText("");
    }
}