package es.sixey.dream2svg.dream2text.align;

import es.sixey.dream2svg.util.LineUtil;

import java.util.List;
import java.util.Random;
import java.util.StringJoiner;

public class CenterAligner implements Aligner {
    private static final int WIDTH = 40;

    private final Random random = new Random();

    @Override
    public String align(List<String> line) {
        var joinedLine = LineUtil.joinToString(line);
        var minLength = joinedLine.length();
        if (minLength == 40) return joinedLine;

        var difference = WIDTH-minLength;
        var padding = LineUtil.spaces(difference/2);
        var alignedLine = padding + joinedLine + padding;
        if (alignedLine.length() < WIDTH) {
            if (random.nextBoolean()) {
                alignedLine = " " + alignedLine;
            } else  {
                alignedLine = alignedLine + " ";
            }
        }
        return alignedLine;
    }

}
