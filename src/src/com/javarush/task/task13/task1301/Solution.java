package src.com.javarush.task.task13.task1301;

/* 
Пиво
*/

import java.util.Random;

public class Solution {
    public static void main(String[] args) throws Exception {
        Alcoholic koldyr = new BeerLover();
        System.out.println("Мне как обычно.");
        int n = 17;
        for (int i = 0; i < n; i++){
            koldyr.askForMore("Дружище, надо повторить!");
            koldyr.sayThankYou();

            if (i > 5) koldyr.sleepOnTheFloor();
        }

        if (koldyr.isReadyToGoHome()) {
            System.out.println("фывоажлыафвы пока!!!");
        }
    }

    public interface Drinker {
        void askForMore(String message);

        void sayThankYou();

        boolean isReadyToGoHome();
    }

    public interface Alcoholic extends Drinker {
        boolean READY_TO_GO_HOME = false;

        void sleepOnTheFloor();
    }

    public static class BeerLover implements Alcoholic{
        @Override
        public void askForMore(String message) {
            System.out.println(message);
        }

        @Override
        public void sayThankYou() {
            Random random = new Random();
            switch (random.nextInt(2)+1){
                case 1: {
                System.out.println("Благодарю!");
                break;
            }
                case 2: {
                System.out.println("Примного благодарен");
                break;
            }
                case 3: {
                System.out.println("тенькс");
                break;
            }
            }
        }

        @Override
        public boolean isReadyToGoHome() {
            boolean b = READY_TO_GO_HOME ? true : false;
            return b;
        }

        @Override
        public void sleepOnTheFloor() {
            System.out.println("Я в слюни...");
        }
    }
}
