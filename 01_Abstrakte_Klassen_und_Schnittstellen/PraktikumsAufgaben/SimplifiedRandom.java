/**
 * Klasse für Zufallszahlen in einem bestimmten Bereich
 */
public class SimplifiedRandom
{
    public static float getRandomFloat(float min, float max){
        return min + (float)(Math.random() * ((max - min) + 1));
    }
    
    public static int getRandomInt(int min, int max){
        return min + (int)(Math.random() * ((max - min) + 1));
    }
}
