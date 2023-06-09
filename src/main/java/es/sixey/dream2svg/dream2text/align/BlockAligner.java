package es.sixey.dream2svg.dream2text.align;

import es.sixey.dream2svg.util.LineUtil;

import java.util.ArrayList;
import java.util.List;

public class BlockAligner implements Aligner {
    private static final int WIDTH = 40;

    @Override
    public String align(List<String> line) {
        var joinedLine = LineUtil.joinToString(line);
        var minLength = joinedLine.length();
        if (minLength == 40) return joinedLine;
        if (minLength == 0) return LineUtil.spaces(40);
        if (line.size() == 1) return new CenterAligner().align(line);

        var difference = WIDTH-minLength+line.size()-1;
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

}
