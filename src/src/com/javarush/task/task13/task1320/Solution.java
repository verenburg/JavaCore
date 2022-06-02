package src.com.javarush.task.task13.task1320;

/* 
Neo
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        System.out.println(Matrix.NEO);
    }

    static class Matrix {
        public static DBObject NEO = new User().initializeIdAndName(1, "Neo");
    }

    interface DBObject {
        DBObject initializeIdAndName(long id, String name);

    }

    static class User implements DBObject {
        long id;
        String name;

        public void setId(long id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public User(){

        }

        public User(Long id, String name){
            setId(id);
            setName(name);
        }

        @Override
        public DBObject initializeIdAndName(long id, String name) {
            setName(name);
            setId(id);
            return this;

        }

        @Override
        public String toString() {
            return String.format("The user's name is %s, id = %d", name, id);
        }
    }
}
