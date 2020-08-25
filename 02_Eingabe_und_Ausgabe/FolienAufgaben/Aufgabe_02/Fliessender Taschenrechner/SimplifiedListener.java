import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SimplifiedListener implements KeyListener, ActionListener
{
    @Override
    public void keyPressed(KeyEvent e) {
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        /**
        try {
            
        } catch (NumberFormatException f) {
            String fehlerMeldung = f.getMessage();
            Taschenrechner.surface.log.append(fehlerMeldung + "\n"); // Neue Zeile: \n
        } catch (NullPointerException g) {
            String fehlerMeldungNullPointer = g.getMessage();
            Taschenrechner.surface.log.append(fehlerMeldungNullPointer + "\n"); // Neue Zeile: \n
        }
        */
    }
}