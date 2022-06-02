package src.com.javarush.task.task19.task1902;

import java.io.FileOutputStream;
import java.io.IOException;

/* 
Адаптер
*/

public class AdapterFileOutputStream implements AmigoStringWriter{
    private FileOutputStream fileOutputStream;
    public AdapterFileOutputStream(FileOutputStream fileOutputStream){
        this.fileOutputStream = fileOutputStream;
    }

    public static void main(String[] args) {

    }


    @Override
    public void flush() throws IOException {
        fileOutputStream.flush();
    }

    @Override
    public void writeString(String s) throws IOException {
        fileOutputStream.write(s.getBytes());

        /*char[] chars = s.toCharArray();
        byte[] b = new byte[chars.length];
        for (int i = 0; i < chars.length; i++){
            b[i] = (byte)chars[i];
        }
        fileOutputStream.write(b);*/
    }

    @Override
    public void close() throws IOException {
        fileOutputStream.close();
    }
}

