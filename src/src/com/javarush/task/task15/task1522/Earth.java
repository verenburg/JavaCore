package src.com.javarush.task.task15.task1522;

public class Earth implements Planet {
    private static Earth instance = null;

    public static Earth getInstans() {
        if (instance == null){
            instance = new Earth();
        }
        return instance;
    }
}