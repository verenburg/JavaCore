package src.com.javarush.task.task13.task1313;

import java.awt.*;

/* 
Лисица — это такое животное
Реализуй в классе Fox интерфейс Animal.
Поменяй код так, чтобы в классе Fox был только один метод - getName.
Учти, что создавать дополнительные классы и удалять методы нельзя!


*/

public class Solution {
    public static void main(String[] args) throws Exception {
    }

    public interface Animal {
        default Color getColor(){ return new Color(243, 166, 12);}
    }

    public static class Fox implements Animal {
        public String getName() {
            return "Fox";
        }
    }
}