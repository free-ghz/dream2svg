package es.sixey.dream2svg.util;

import java.util.List;

public class LineUtil {
    public static int combinedLength(List<String> words) {
        int length = words.size()-1; // min amount of whitespace needed
        length += words.stream().mapToInt(String::length).sum();
        return length;
    }

    public static String spaces(int howMany) {
        return "                                        ".substring(0, howMany);
    }
}
