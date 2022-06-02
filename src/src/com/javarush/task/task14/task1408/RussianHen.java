package src.com.javarush.task.task14.task1408;

    class RussianHen extends Hen {
        @Override
        public int getCountOfEggsPerMonth() {
            return 17;
        }

        @Override
        public String getDescription() {
            return super.getDescription() + " Моя страна - " + Country.RUSSIA + ". Я несу " 
                    + getCountOfEggsPerMonth() + " яиц в месяц.";
        }
    }