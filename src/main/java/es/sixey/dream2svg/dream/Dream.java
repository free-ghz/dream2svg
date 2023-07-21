package es.sixey.dream2svg.dream;

import es.sixey.dream2svg.util.LineUtil;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Dream {
    private final List<DreamSegment> segments = new ArrayList<>();

    public Dream(String file, int paragraphWidth, boolean shouldAddMargin) {
        var lines = file.split("\r?\n");

        var segment = new DreamSegment(AlignStrategy.AUTO, CurtainType.RANDOM);
        if (shouldAddMargin) addMargin(5, segment);
        for (var line: lines) {
            if (line.startsWith("^")) {
                // handle commands
                var newAlignStrategy = getAlignStrategy(line);
                var newCurtainType = getCurtainType(line);
                if (newAlignStrategy != null || newCurtainType != null) {
                    segments.add(segment);
                    segment = new DreamSegment();
                    segment.setCurtainType(newCurtainType);
                    segment.setAlignStrategy(newAlignStrategy);
                }
                continue;
            }
            var words = new ArrayDeque<>(List.of(line.split("\s")));
            do {
                var outputLine = new ArrayList<String>();
                String currentWord = null;
                while (LineUtil.combinedLength(outputLine) <= paragraphWidth && !words.isEmpty()) {
                    currentWord = words.removeFirst();
                    if (currentWord.length() > paragraphWidth) {
                        var leader = currentWord.substring(0, paragraphWidth);
                        var trailer = currentWord.substring(paragraphWidth);
                        currentWord = leader;
                        words.addFirst(trailer);
                    }
                    outputLine.add(currentWord);
                }
                if (LineUtil.combinedLength(outputLine) > paragraphWidth) {
                    outputLine.remove(outputLine.size()-1);
                    words.addFirst(currentWord);
                }
                segment.getLines().add(outputLine);
            } while (!words.isEmpty());
        }
        if (shouldAddMargin) addMargin(5, segment);
        segments.add(segment);
    }

    private AlignStrategy getAlignStrategy(String line) {
        var instruction = line.split("\\^");
        var command = instruction[1].strip().toLowerCase();
        if (command.equals("align") || command.equals("justify")) {
            return AlignStrategy.forValue(instruction[2].strip().toLowerCase());
        }
        return null;
    }

    private CurtainType getCurtainType(String line) {
        var instruction = line.split("\\^");
        var command = instruction[1].strip().toLowerCase();
        if (command.equals("curtains")) {
            return CurtainType.forValue(instruction[2].strip().toLowerCase());
        }
        return null;
    }

    private void addMargin(int lines, DreamSegment segment) {
        for (int i = 0; i < lines; i++) segment.getLines().add(new ArrayList<>());
    }

    public List<DreamSegment> getSegments() {
        return segments;
    }

    @Override
    public String toString() {
        return segments.toString();
    }

}
