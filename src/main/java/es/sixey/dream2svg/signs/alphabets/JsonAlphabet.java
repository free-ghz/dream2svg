package es.sixey.dream2svg.signs.alphabets;

import com.fasterxml.jackson.databind.ObjectMapper;
import es.sixey.dream2svg.Main;
import es.sixey.dream2svg.signs.Letter;
import es.sixey.dream2svg.signs.Path;

import java.io.IOException;
import java.util.*;

public class JsonAlphabet implements Alphabet {
    Map<Character, Letter> letters = new HashMap<>();
    public JsonAlphabet(String filename) throws IOException {
        var json = Main.loadFile("alphabets/" + filename);

        ObjectMapper mapper = new ObjectMapper();
        try {
            var mainObject = mapper.readValue(json, JsonLetterMap.class);
            mainObject.keySet().forEach(key -> {
                var letterDef = mainObject.get(key);
                var paths = new ArrayList<Path>();
                letterDef.lines.forEach(line -> {
                    var path = new Path();
                    line.forEach(p -> path.addPoint(p.get(0), p.get(1)));
                    paths.add(path);
                });
                double letterHeight = letterDef.getHeight() == null ? 1 : letterDef.getHeight();
                double letterWidth = letterDef.getWidth() == null ? 1 : letterDef.getWidth();
                letters.put(key.charAt(0), new Letter(letterWidth, letterHeight, paths));
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public Letter letterFor(char c) {
        return letters.get(c);
    }

    // This is a bit yucky - it depends on Jackson actually using a LinkedHashMap in implementation.
    static class JsonLetterMap extends LinkedHashMap<String, LetterDefinition> {}

    static class LetterDefinition {
        public List<List<List<Double>>> lines;
        Double width = null;
        Double height = null;

        public List<List<List<Double>>> getLines() {
            return lines;
        }

        public void setLines(List<List<List<Double>>> lines) {
            this.lines = lines;
        }

        public Double getWidth() {
            return width;
        }

        public void setWidth(Double width) {
            this.width = width;
        }

        public Double getHeight() {
            return height;
        }

        public void setHeight(Double height) {
            this.height = height;
        }
    }
}
