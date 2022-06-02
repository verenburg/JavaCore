package src.com.javarush.task.task15.task1505;

/* 
ООП - исправь ошибки в наследовании
*/

public class Solution {
    public interface HasWeight {
        int getValue();
    }

    public interface HasHeight {
        int getValue();
    }

    public static class Human implements HasWeight, HasHeight {
        @Override
        public int getValue() {
            return 0;
        }
    }

    public static void main(String[] args) {
        Human human = new Human();
        System.out.println(human.getValue());
        System.out.println(human.getValue());
    }
}