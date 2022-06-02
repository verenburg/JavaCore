package src.com.javarush.task.task15.task1529;

public class Plane implements CanFly {
    int numb;

    public Plane(int nom){
        setNumb(nom);
    }

    @Override
    public void fly() {

    }

    public int getNumb() {
        return numb;
    }

    public void setNumb(int numb) {
        this.numb = numb;
    }
}
