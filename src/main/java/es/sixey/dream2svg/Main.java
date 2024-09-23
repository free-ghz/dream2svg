package es.sixey.dream2svg;

import es.sixey.dream2svg.dream.Dream;
import es.sixey.dream2svg.dream2text.TextRenderer;
import es.sixey.dream2svg.dream2text.curtains.AutomataCurtain;
import es.sixey.dream2svg.signs.Text;
import es.sixey.dream2svg.signs.alphabets.*;
import es.sixey.dream2svg.util.SvgSorter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public final static int PAPER_WIDTH_MM = 297;
    public final static int PAPER_HEIGHT_MM = 210;
    public final static int PAGE_WIDTH_MM = 74;
    public final static int PAGE_HEIGHT_MM = 105;
    public final static int TOTAL_COLUMNS_PER_PAGE = 17;
    public final static int TEXT_ROWS_PER_PAGE = 25;
    public final static int OUTER_BORDER_LETTERS = 1;
    public final static int WIDTH_LETTERS_BORDER = TOTAL_COLUMNS_PER_PAGE + (2 * OUTER_BORDER_LETTERS);
    public final static int HEIGHT_LETTERS_BORDER = TEXT_ROWS_PER_PAGE + (2 * OUTER_BORDER_LETTERS);
    public final static int CURTAIN_LETTERS = 1;

    final static int TEXT_COLUMNS_PER_PAGE = TOTAL_COLUMNS_PER_PAGE - (2 * CURTAIN_LETTERS) - 2;

    public static void main(String[] args) throws IOException {

        String location = "book/engine.dream";
        var text = loadFile(location);
        var dream = new Dream(text, TEXT_COLUMNS_PER_PAGE, false);
        var renderer = new TextRenderer(TEXT_COLUMNS_PER_PAGE, CURTAIN_LETTERS);
        var renderedDream = renderer.render(dream, Integer.MAX_VALUE);

        var asciiHeight = renderedDream.split("\n").length;
        System.out.println("\n" + renderedDream + "\n\n" + asciiHeight  + " rows, remain " + (TEXT_ROWS_PER_PAGE - asciiHeight));
        var diagnosticAscii = renderer.render(dream, Integer.MAX_VALUE);
        var diagnosticLength = diagnosticAscii.split("\n").length;
        var numberOfPages = ((double)diagnosticLength/(double) TEXT_ROWS_PER_PAGE);
        System.out.println("Total length presumed to be " + diagnosticLength + " lines. " + numberOfPages + " pages yea");

        var drawing = new Drawing(PAPER_WIDTH_MM, PAPER_HEIGHT_MM, WIDTH_LETTERS_BORDER, HEIGHT_LETTERS_BORDER, OUTER_BORDER_LETTERS);
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
