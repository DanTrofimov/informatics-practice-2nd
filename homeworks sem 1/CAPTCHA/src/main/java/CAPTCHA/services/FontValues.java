package CAPTCHA.services;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class FontValues {
    public static final String FILE_TYPE = "jpeg";

    public static List<String> fonts = Arrays.asList("Arial", "Courier", "TimesRoman");
    public static  List<Color> colors = Arrays.asList(Color.GRAY, Color.LIGHT_GRAY, Color.BLACK, Color.darkGray);
    public static List<Integer> fontStyles = Arrays.asList(Font.BOLD, Font.ITALIC, Font.LAYOUT_NO_LIMIT_CONTEXT, Font.CENTER_BASELINE);
    public String captchaSymbols = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

    public <T> T getRandomValueOf(List<T> list) {
        Random random = new Random();
        int index = (int) (random.nextFloat() * list.size());
        return list.get(index);
    }
}
