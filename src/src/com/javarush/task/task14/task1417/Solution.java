package src.com.javarush.task.task14.task1417;

import java.util.ArrayList;
import java.util.List;

/* 
Валюты
В существующем абстрактном классе Money создай приватное поле amount типа double.
Создай публичный геттер для поля amount(public double getAmount()), чтобы к этому полю можно было получить доступ извне класса Money.
В отдельных файлах создай классы Hryvnia, Ruble и USD, которые будут являться потомками класса Money.
В классах Hryvnia, Ruble и USD реализуй метод getCurrencyName() который будет возвращать название соответствующей валюты (строку) в виде аббревиатуры (USD, UAH, RUB).
В классах Hryvnia, Ruble и USD реализуй публичный (public) конструктор, который принимает один параметр и вызывает конструктор базового класса (super) с этим параметром.
Заполни список allMoney объектами всех возможных в рамках условия задачи и функциональности программы валют.

*/

public class Solution {
    public static void main(String[] args) {
        Person ivan = new Person("Иван");
        for (Money money : ivan.getAllMoney()) {
            System.out.println(ivan.name + " имеет заначку в размере " + money.getAmount() + " " + money.getCurrencyName());
        }
    }

    public static class Person {
        public String name;

        private List<Money> allMoney;

        Person(String name) {
            this.name = name;
            this.allMoney = new ArrayList<Money>();
            this.allMoney.add(new Hryvnia(50));
            this.allMoney.add((new Ruble(500000)));
            this.allMoney.add(new USD(91));
        }

        public List<Money> getAllMoney() {
            return allMoney;
        }
    }
}
