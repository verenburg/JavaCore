package src.com.javarush.task.task14.task1417;

public abstract class Money {
    private double amount;

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public  double getAmount(){
        return this.amount;
    }

    public Money(double amount) {
        setAmount(amount);
    }

    public abstract String getCurrencyName();
}

