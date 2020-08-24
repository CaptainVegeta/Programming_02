/**
 * Klasse für vereinfachten Programmunterbruch
 */
public class SimplifiedDelay
{
    /**
     * Unterbricht das Programm für die angegebene Zeit in Millisekunden.
     */
    public static void delay(int milliseconds){
        // Sleep-Methode kann einen Fehler ausgeben (exception). Dadurch wird ein try-catch-Bereich benötigt um zu beschreiben, was in diesem Fehlerfall unternommen werden soll.
        try        
        {
            Thread.sleep(milliseconds);
        } 
        catch(InterruptedException ex) 
        {
            Thread.currentThread().interrupt();
        }
    }
}