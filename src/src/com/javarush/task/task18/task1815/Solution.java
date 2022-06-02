package src.com.javarush.task.task18.task1815;

import java.util.List;

/* 
Таблица
*/

public class Solution {
    public class TableInterfaceWrapper {
        private TableInterface tableInterface;

        public TableInterfaceWrapper(TableInterface tableInterface){
            super();
            this.tableInterface = tableInterface;
        }

        void setModel(List rows){
            System.out.println(rows.size());
            tableInterface.setModel(rows);
        }

        String getHeaderText(){
            return tableInterface.getHeaderText().toUpperCase();
        }

        void setHeaderText(String newHeaderText){
            this.tableInterface.setHeaderText(newHeaderText);
        }

    }

    public interface TableInterface {
        void setModel(List rows);

        String getHeaderText();

        void setHeaderText(String newHeaderText);
    }

    public static void main(String[] args) {
    }
}