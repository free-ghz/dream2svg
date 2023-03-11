package es.sixey.dream2svg.dream2text.align;

import es.sixey.dream2svg.util.LineUtil;

import java.util.List;

public class LeftAligner implements Aligner {

    private static final int WIDTH = 40;

    @Override
    public String align(List<String> line) {
        var joinedLine = LineUtil.joinToString(line);
        var minLength = joinedLine.length();
        if (minLength == 40) return joinedLine;

        var difference = WIDTH-minLength;
        var padding = LineUtil.spaces(difference);
        return joinedLine + padding;
    }
}
