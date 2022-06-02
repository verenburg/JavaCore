package src.com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

import static com.javarush.task.task16.task1631.common.ImageTypes.*;

public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes imageTypes){
        ImageReader imageReader = null;
        switch (imageTypes){
            case JPG:
                imageReader = new JpgReader();
                break;
            case BMP:
                imageReader = new BmpReader();
                break;
            case PNG:
                imageReader = new PngReader();
                break;
            default:
                //System.out.println("Незвестное значение ридера");
                throw new IllegalStateException("Неизвестный тип картинки " + imageTypes);
        }
    return imageReader;
    }
}
