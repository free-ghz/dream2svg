package es.sixey.dream2svg.dream2text.align;

import es.sixey.dream2svg.util.LineUtil;

import java.util.List;

public class AutoAligner implements Aligner {
    public void setWidth(int width) {
        inner.setWidth(width);
        outer.setWidth(width);
    }

    private final Aligner inner;
    private final Aligner outer;
    private final int threshold;

    public AutoAligner (Aligner inner, int threshold, Aligner outer) {
        this.inner = inner;
        this.outer = outer;
        this.threshold = threshold;
    }

    @Override
    public String align(List<String> line) {
        if (LineUtil.combinedLength(line) > threshold) return outer.align(line);
        return inner.align(line);
    }
}
