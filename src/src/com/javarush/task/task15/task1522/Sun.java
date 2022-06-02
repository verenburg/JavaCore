package src.com.javarush.task.task15.task1522;

public class Sun implements Planet {
    private static Sun instance = null;

    public static Sun getInstans() {
        if (instance == null){
            instance = new Sun();
        }
        return instance;
    }
}




