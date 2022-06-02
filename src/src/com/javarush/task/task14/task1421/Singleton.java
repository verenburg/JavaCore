package src.com.javarush.task.task14.task1421;

public class Singleton {
    private static Singleton singleton = new Singleton();

    private Singleton(){
    }

    public static Singleton getInstance() {
        return singleton;
    }
}
