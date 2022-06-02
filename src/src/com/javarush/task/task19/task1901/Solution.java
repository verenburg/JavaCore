package src.com.javarush.task.task19.task1901;

/* 
TableAdapter
*/

public class Solution {
    public static void main(String[] args) {
        int a = 100;
        int b = 20;
        int c = 10;


        c = c&a ;
        System.out.println("c &= a " + c );

        c = c^a ;
        System.out.println("c ^= a   = " + c );

        c = c|a ;
        System.out.println("c |= a   = " + c );

        //это пример вывода
        ATable aTable = new ATable() {
            @Override
            public String getCurrentUserName() {
                return "Amigo";
            }

            @Override
            public String getTableName() {
                return "DashboardTable";
            }
        };
        BTable table = new TableAdapter(aTable);
        System.out.println(table.getHeaderText());
    }

    public static class TableAdapter implements BTable {
        private ATable aTable;
        public TableAdapter(ATable aTable){
            this.aTable = aTable;
        }

        @Override
        public String getHeaderText() {
            return "[" + aTable.getCurrentUserName() + "]:" + aTable.getTableName();
        }
    }

    public interface ATable {
        String getCurrentUserName();

        String getTableName();
    }

    public interface BTable {
        String getHeaderText();
    }
}