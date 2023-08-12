package es.sixey.dream2svg;

import es.sixey.dream2svg.dream.Dream;
import es.sixey.dream2svg.dream2text.TextRenderer;
import es.sixey.dream2svg.dream2text.curtains.AutomataCurtain;
import es.sixey.dream2svg.signs.Text;
import es.sixey.dream2svg.signs.alphabets.*;
import es.sixey.dream2svg.util.Fade;
import es.sixey.dream2svg.util.SvgSorter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        final var WIDTH_MM = 74;
        final var HEIGHT_MM = 105;
        final var WIDTH_LETTERS = 17;
        final var HEIGHT_LETTERS = 25;
        final var OUTER_BORDER_LETTERS = 1;
        final var WIDTH_LETTERS_BORDER = WIDTH_LETTERS + (2 * OUTER_BORDER_LETTERS);
        final var HEIGHT_LETTERS_BORDER = HEIGHT_LETTERS + (2 * OUTER_BORDER_LETTERS);
        final var CURTAIN_LETTERS = 1;

        final var PARAGRAPH_LETTERS = WIDTH_LETTERS - (2 * CURTAIN_LETTERS) - 2;

        var letterMmWidthCalculated = (double)WIDTH_MM/(double)WIDTH_LETTERS;
        var letterMmHeightCalculated = (double)HEIGHT_MM/(double)HEIGHT_LETTERS;
        letterMmWidthCalculated = Math.round(letterMmWidthCalculated * 10)/10.0;
        letterMmHeightCalculated = Math.round(letterMmHeightCalculated * 10)/10.0;
        System.out.println("letters roughly " + letterMmWidthCalculated + "x" + letterMmHeightCalculated);

        var text = loadFile("book/selatenine.dream");
        var dream = new Dream(text, PARAGRAPH_LETTERS , false);
        var renderer = new TextRenderer(PARAGRAPH_LETTERS, CURTAIN_LETTERS);
        var renderedDream = renderer.render(dream, HEIGHT_LETTERS);

        var otherText = getAutomataPage(PARAGRAPH_LETTERS, HEIGHT_LETTERS);
        var otherDream = new Dream(otherText, PARAGRAPH_LETTERS , false);
        var otherRenderedDream = renderer.render(otherDream, HEIGHT_LETTERS);
        renderedDream = new Fade().fadeBetween(renderedDream, otherRenderedDream);

        var asciiHeight = renderedDream.split("\n").length;
        System.out.println("\n" + renderedDream + "\n\n" + asciiHeight  + " rows, remain " + (HEIGHT_LETTERS - asciiHeight));
        var diagnosticAscii = renderer.render(dream, Integer.MAX_VALUE);
        var diagnosticLength = diagnosticAscii.split("\n").length;
        var numberOfPages = ((double)diagnosticLength/(double)HEIGHT_LETTERS);
        System.out.println("Total length presumed to be " + diagnosticLength + " lines. " + numberOfPages + " pages yea");

        var drawing = new Drawing(WIDTH_MM, HEIGHT_MM, WIDTH_LETTERS_BORDER, HEIGHT_LETTERS_BORDER, OUTER_BORDER_LETTERS);
        var letters = new Text(renderedDream, new CosmogrammaAlphabet(), "1-letters");
        var grime = new Text(renderedDream, new Grimes2Alphabet(), "2-grime");
        drawing.drawText(letters, 0.8);
        drawing.setAccentPaint();
        drawing.drawText(grime);

        var outputPath = Path.of("output.svg");
        var output = drawing.getSvg();
        output = SvgSorter.sort(output);
        Files.writeString(outputPath, output);
    }

    private static String loadFile(String location) throws IOException {
        var path = Path.of(location);
        var file = Files.readString(path);
        return file.toLowerCase();
    }

    private static String getAutomataPage(int width, int height) {
        var automata = new AutomataCurtain(width, 0);
        automata.setOutputCharacters(new String[]{" ", "4"});
        String page = "^ curtains ^ automata ^\n^ align ^ none ^\n";
        for (var i = 0; i < height; i++) {
            page += automata.getNext().left() + "\n";
        }
        return page;
    }
}
