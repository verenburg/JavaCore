package src.com.javarush.task.task14.task1408;

class BelarusianHen extends Hen {
        @Override
        public String getDescription() {
            return super.getDescription() + " Моя страна - " + Country.BELARUS + ". Я несу "
                    + getCountOfEggsPerMonth() + " яиц в месяц.";
        }

        @Override
        public int getCountOfEggsPerMonth() {
            return 18;
        }
    }