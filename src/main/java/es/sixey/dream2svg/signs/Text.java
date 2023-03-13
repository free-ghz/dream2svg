package es.sixey.dream2svg.signs;

import es.sixey.dream2svg.signs.alphabets.Alphabet;

public class Text {
    private Letter[][] grid;
    private int width;
    private int height;

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

        for (int y = 0; y < width; y++) {
            var line = lines[y].toCharArray();
            for (int x = 0; x < line.length; x++) {
                grid[x][y] = alphabet.letterFor(line[x]);
            }
        }
    }
}
