package src.com.javarush.task.task15.task1530;

public class LatteMaker extends DrinkMaker {
    @Override
    void getRightCup() {
        System.out.println("Берем чашку для латте");
    }

    @Override
    void putIngredient() {
        System.out.println("Заливаем кофе");
    }

    @Override
    void pour() {
        System.out.println("Делаем молоко с пенкой");
    }
}
