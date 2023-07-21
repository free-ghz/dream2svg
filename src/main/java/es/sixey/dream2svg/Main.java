package es.sixey.dream2svg;

import es.sixey.dream2svg.dream.Dream;
import es.sixey.dream2svg.dream2text.TextRenderer;
import es.sixey.dream2svg.signs.Text;
import es.sixey.dream2svg.signs.alphabets.DefaultGrimesAlphabet;
import es.sixey.dream2svg.signs.alphabets.DefaultLettersAlphabet;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        final var WIDTH_MM = 74;
        final var HEIGHT_MM = 105;
        final var WIDTH_LETTERS = 13;
        final var HEIGHT_LETTERS = 19;
        final var OUTER_BORDER_LETTERS = 1;
        final var WIDTH_LETTERS_BORDER = WIDTH_LETTERS + (2 * OUTER_BORDER_LETTERS);
        final var HEIGHT_LETTERS_BORDER = HEIGHT_LETTERS + (2 * OUTER_BORDER_LETTERS);
        final var CURTAIN_LETTERS = 1;

        final var PARAGRAPH_LETTERS = WIDTH_LETTERS - (2 * CURTAIN_LETTERS) - 2;


        var cavePath = Path.of("book/shower.dream");
        var caveFile = Files.readString(cavePath);
        var cave = new Dream(caveFile.toLowerCase(), PARAGRAPH_LETTERS , false);
        System.out.println("survived creating dream");
        var renderer = new TextRenderer(PARAGRAPH_LETTERS, CURTAIN_LETTERS);
        var asciiCave = renderer.render(cave, HEIGHT_LETTERS);
        System.out.println(asciiCave);

        var letters = new Text(asciiCave, new DefaultLettersAlphabet());
        var grime = new Text(asciiCave, new DefaultGrimesAlphabet());

        var drawing = new Drawing(WIDTH_MM, HEIGHT_MM, WIDTH_LETTERS_BORDER, HEIGHT_LETTERS_BORDER, OUTER_BORDER_LETTERS);
        drawing.drawText(letters);
        drawing.drawText(grime);
        var outputPath = Path.of("output.svg");
        Files.writeString(outputPath, SvgSorter.sort(drawing.getSvg()));
    }
}
