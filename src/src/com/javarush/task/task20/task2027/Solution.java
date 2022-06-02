package src.com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/

public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        detectAllWords(crossword, "home", "same");
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        ArrayList<Word> list = new ArrayList<>();
        for (String word : words) {
            int len = word.length();
            char[] chars = word.toCharArray();
            for (int i = 0; i < crossword.length; i++) {
                for (int j = 0; j < crossword.length+1; j++) {
                    if ((char) crossword[i][j] == chars[0]) {
                        // !проверка в лево
                        if (i >= len-1) {
                            int count = 0;
                            for (char c : chars) {
                                if (c == (char) crossword[i - count][j]) {
                                    count++;
                                }
                                if (count == len) {
                                    Word line = new Word(word);
                                    line.setStartPoint(j, i);
                                    line.setEndPoint(j,i - len + 1);
                                    list.add(line);
                                }
                            }
                        }
                        // !проверка в лево и вверх
                        if (i >= len-1 && j >= len-1) {
                            int count = 0;
                            for (char c : chars) {
                                if (c == (char)crossword[i - count][j - count]) {
                                    count++;
                                }
                                if (count == len) {
                                    Word line = new Word(word);
                                    line.setStartPoint(j, i);
                                    line.setEndPoint(j - len + 1, i - len + 1);
                                    list.add(line);
                                }
                            }
                        }
                        // !проверка в верх
                        if (j >= len-1) {
                            int count = 0;
                            for (char c : chars) {
                                if (c == (char)crossword[i][j - count]) {
                                    count++;
                                }
                                if (count == len) {
                                    Word line = new Word(word);
                                    line.setStartPoint(j,i);
                                    line.setEndPoint(j - len + 1,i );
                                    list.add(line);
                                }
                            }
                        }
                        // !проверка в право и в верх
                        if (crossword.length - i >= len-1 && j >= len-1 ) {
                            int count = 0;
                            for (char c : chars) {
                                if (c == (char)crossword[i + count][j - count]) {
                                    count++;
                                }
                                if (count == len) {
                                    Word line = new Word(word);
                                    line.setStartPoint(j,i);
                                    line.setEndPoint(j - len + 1, i + len - 1);
                                    list.add(line);
                                }
                            }
                        }
                        // !проверка в право
                        if (crossword.length - i >= len-1 ) {
                            int count = 0;
                            for (char c : chars) {
                                if (c == (char)crossword[i + count][j]) {
                                    count++;
                                }
                                if (count == len) {
                                    Word line = new Word(word);
                                    line.setStartPoint(j, i);
                                    line.setEndPoint(j, i + len - 1);
                                    list.add(line);
                                }
                            }
                        }
                        // проверка в право в низ
                        if (crossword.length - i >= len-1 && crossword.length - j >= len-1) {
                            int count = 0;
                            for (char c : chars) {
                                if (c == (char)crossword[i + count][j + count]) {
                                    count++;
                                }
                                if (count == len) {
                                    Word line = new Word(word);
                                    line.setStartPoint(j, i);
                                    line.setEndPoint(j + len - 1, i + len - 1);
                                    list.add(line);
                                }
                            }
                        }
                        // проверка вниз
                        if (crossword.length - j >= len-1){
                            int count = 0;
                            for (char c : chars) {
                                if (c == (char)crossword[i][j + count]) {
                                    count++;
                                }
                                if (count == len) {
                                    Word line = new Word(word);
                                    line.setStartPoint(j, i);
                                    line.setEndPoint(j + len - 1 ,i );
                                    list.add(line);
                                }
                            }
                        }
                        // проверка в лево в низ
                        if (i >= len && crossword.length - j >= len-1){
                            int count = 0;
                            for (char c : chars) {
                                if (c == (char)crossword[i - count][j + count]) {
                                    count++;
                                }
                                if (count == len) {
                                    Word line = new Word(word);
                                    line.setStartPoint(j, i);
                                    line.setEndPoint( j + len - 1, i - len + 1);
                                    list.add(line);
                                }
                            }
                        }
                    }
                }
            }
        }
        for (Word w : list){
            System.out.println(w);
        }
        return list;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
