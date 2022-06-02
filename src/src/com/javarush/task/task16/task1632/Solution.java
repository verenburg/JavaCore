package src.com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Клубок
*/

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);
    static {
        ThreadOne thread1 = new ThreadOne();
        ThreadTwo thread2 = new ThreadTwo();
        ThreadThree thread3 = new ThreadThree();
        Thread4 thread4 = new Thread4();
        Thread5 thread5 = new Thread5();

        threads.add(thread1);
        threads.add(thread2);
        threads.add(thread3);
        threads.add(thread4);
        threads.add(thread5);
    }

    public static void main(String[] args) {



    }

    public static class ThreadOne extends Thread{
        @Override
        public void run() {
            int i = 1;
            while (true){
                i *= 1;
            }
        }
    }

    public static class ThreadTwo extends Thread{
        @Override
        public void run() {
             while (true){
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    System.out.println("InterruptedException");
                }
            }
        }
    }

    public static class ThreadThree extends Thread{
        @Override
        public void run() {
            while (true){
                try {
                    Thread.sleep(500);
                    System.out.println("Ура!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class Thread4 extends Thread implements Message{
        @Override
        public void run() {
            while (!isInterrupted()){
                try {
                    Thread.sleep(500);
                    System.out.println("Нить 4 исполняется");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        public void showWarning() {
            Thread.currentThread().interrupt();
        }
    }

    public static class Thread5 extends Thread{
        @Override
        public void run() {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int  summ = 0;
            String value = "";
            while (true){
                try {
                    value = reader.readLine();
                    if (value.equals("N")) {
                        System.out.println("Сумма равна: " + summ);
                    } else {
                        summ += Integer.parseInt(value);
                    }
                }catch (IOException e1){
                    System.out.println("Некорректное значение числа!");
                }
            }
        }
    }
}