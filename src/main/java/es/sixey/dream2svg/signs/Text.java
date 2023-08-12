package es.sixey.dream2svg.signs;

import es.sixey.dream2svg.signs.alphabets.Alphabet;

public class Text {
    private final Letter[][] grid;
    private final int width;
    private final int height;
    private String name = null;

    public Text(String text, Alphabet alphabet, String name) {
        this(text, alphabet);
        this.name = name;
    }
    public Text(String text, Alphabet alphabet) {
        var lines = text.split("\n");
        int maxLen = 0;
        for (var line : lines) {
            var lineArr = line.toCharArray();
            maxLen = Math.max(maxLen, lineArr.length);
        }
        width = maxLen;
        height = lines.length;
        grid = new Letter[width][height];

        for (int y = 0; y < height; y++) {
            var line = lines[y].toCharArray();
            for (int x = 0; x < line.length; x++) {
                grid[x][y] = alphabet.letterFor(line[x]);
            }
        }
    }

    public Letter[][] getGrid() {
        return grid;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        if (name != null) return name;
        return super.toString();
    }
}
