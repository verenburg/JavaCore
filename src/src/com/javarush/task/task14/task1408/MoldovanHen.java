package src.com.javarush.task.task14.task1408;


class MoldovanHen extends Hen {
    @Override
    public int getCountOfEggsPerMonth() {
        return 14;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " Моя страна - " + Country.MOLDOVA + ". Я несу "
                + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}