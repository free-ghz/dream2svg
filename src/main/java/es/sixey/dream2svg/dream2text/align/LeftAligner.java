package es.sixey.dream2svg.dream2text.align;

import es.sixey.dream2svg.util.LineUtil;

import java.util.List;

public class LeftAligner implements Aligner {
    private int WIDTH = 40;

    public void setWidth(int width) {
        WIDTH = width;
    }

    @Override
    public String align(List<String> line) {
        var joinedLine = LineUtil.joinToString(line);
        var minLength = joinedLine.length();
        if (minLength == WIDTH) return joinedLine;

        var difference = WIDTH-minLength;
        var padding = LineUtil.spaces(difference);
        return joinedLine + padding;
    }
}
