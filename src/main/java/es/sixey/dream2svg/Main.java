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

        String location = "book/engine.dream";
        var text = loadFile(location);
        var dream = new Dream(text, PARAGRAPH_LETTERS , false);
        var renderer = new TextRenderer(PARAGRAPH_LETTERS, CURTAIN_LETTERS);
        var renderedDream = renderer.render(dream, Integer.MAX_VALUE);

        var asciiHeight = renderedDream.split("\n").length;
        System.out.println("\n" + renderedDream + "\n\n" + asciiHeight  + " rows, remain " + (HEIGHT_LETTERS - asciiHeight));
        var diagnosticAscii = renderer.render(dream, Integer.MAX_VALUE);
        var diagnosticLength = diagnosticAscii.split("\n").length;
        var numberOfPages = ((double)diagnosticLength/(double)HEIGHT_LETTERS);
        System.out.println("Total length presumed to be " + diagnosticLength + " lines. " + numberOfPages + " pages yea");

        var drawing = new Drawing(WIDTH_MM, HEIGHT_MM, WIDTH_LETTERS_BORDER, HEIGHT_LETTERS_BORDER, OUTER_BORDER_LETTERS);
        for (int i = 0; i < 8; i++) {
            System.out.println("°°> Page " + (i + 1));
            var letters = new Text(renderedDream, new CosmogrammaAlphabet(), "" + i + "-1 letters " + location);
            drawing.setDefaultPaint();
            drawing.drawText(letters, 0.8);

            var grime = new Text(renderedDream, new Grimes2Alphabet(), "" + i + "-2 grime " + location);
            drawing.setAccentPaint();
            drawing.drawText(grime);

            try {
                renderedDream = letters.getRemainingText();
                if (renderedDream == null || renderedDream.length() == 0) {
                    break;
                }
            } catch (Exception e) {
                System.err.println("Whelp, couldn't proceed to next page.");
                break;
            }
        }

        var outputPath = Path.of("output/output.svg");
        var output = drawing.getSvg();
        output = SvgSorter.sort(output);

        // this is getting out of hand
        output = output.substring(0, 4) + " xmlns:inkscape='http://www.inkscape.org/namespaces/inkscape'" + output.substring(4);

        Files.writeString(outputPath, output);
    }

    private static String loadFile(String location) throws IOException {
        var path = Path.of(location);
        var file = Files.readString(path);
        return file.toLowerCase();
    }

    private static String getAutomataPage(int width, int height) {
        var automata = new AutomataCurtain(width, 0);
        automata.setOutputCharacters(new String[]{" ", "6"});
        String page = "^ curtains ^ automata ^\n^ align ^ none ^\n";
        for (var i = 0; i < height; i++) {
            page += automata.getNext().left() + "\n";
        }
        return page;
    }
}
