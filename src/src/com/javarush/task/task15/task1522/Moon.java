package src.com.javarush.task.task15.task1522;

public class Moon implements Planet {
    private static Moon instance = null;

    public static Moon getInstans() {
        if (instance == null){
            instance = new Moon();
        }
        return instance;
    }
}