/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Dog dog1 = new Dog();
        Dog dog2 = new Dog();

        Cat cat1 = new Cat();
        Cat cat2 = new Cat();

        Bird bird1 = new Bird();
        Bird bird2 = new Bird();

        Object[] liste = {dog1, cat1, bird1, bird2, dog2, cat2};

        for(int i = 0; i < liste.length; i++){
            if(liste[i] instanceof Dog){
                dog1.doDogSound();
            }
            if(liste[i] instanceof Cat){
                cat1.doCatSound();
            }
            if (liste[i] instanceof Bird){
                bird1.doBirdSound();
            }
        }
    }
}