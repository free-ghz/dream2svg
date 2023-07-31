package es.sixey.dream2svg.dream2text.align;

import es.sixey.dream2svg.util.LineUtil;

import java.util.ArrayList;
import java.util.List;

public class BlockAligner implements Aligner {
    private int width = 40;
    private Aligner overflowAligner = new CenterAligner();

    public void setWidth(int width) {
        this.width = width;
        overflowAligner.setWidth(width);
    }

    @Override
    public String align(List<String> line) {
        var joinedLine = LineUtil.joinToString(line);
        var minLength = joinedLine.length();
        if (minLength == width) return joinedLine;
        if (minLength == 0) return LineUtil.spaces(width);
        if (line.size() == 1) return overflowAligner.align(line);

        var difference = width -minLength+line.size()-1;
        var buckets = createBuckets(line);
        var currentBucket = 0;
        while (buckets.stream().mapToInt(String::length).sum() < difference) {
            var bucket = currentBucket;
            buckets.set(bucket, buckets.get(bucket) + " ");
            currentBucket = (currentBucket + 1) % buckets.size();
        }

        return zipJoin(line, buckets);
    }

    private String zipJoin(List<String> text, List<String> spaces) {
        var builder = new StringBuilder();
        for (int i = 0; i < spaces.size(); i++) {
            builder.append(text.get(i)).append(spaces.get(i));
        }
        return builder.append(text.get(spaces.size())).toString();
    }

    private List<String> createBuckets(List<String> line) {
        var list = new ArrayList<String>();
        for (int i = 0; i < line.size() -1; i++) list.add(" ");
        return list;
    }

    public void setOverflowAligner(Aligner overflowAligner) {
        this.overflowAligner = overflowAligner;
    }
}
