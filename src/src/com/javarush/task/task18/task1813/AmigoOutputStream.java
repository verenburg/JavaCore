package src.com.javarush.task.task18.task1813;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream {
    public static String fileName = "C:/tmp/result.txt";

    private FileOutputStream example;

    public AmigoOutputStream(FileOutputStream example) throws FileNotFoundException {
        super(fileName);
        this.example = example;
    }

    public void close() throws IOException {
        example.flush();
        String javarash = "JavaRush © All rights reserved.";
        byte[] add = javarash.getBytes();
        example.write(add);
        example.close();
    }

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

}
