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
        var cavePath = Path.of("book/selkie.dream");
        var caveFile = Files.readString(cavePath);
        var swag = "abcdef_ghijk".toLowerCase();
        // var cave = new Dream(swag + "\n" + swag + "\n" + swag);
        var cave = new Dream(caveFile.toLowerCase());
        var renderer = new TextRenderer();
        var asciiCave = renderer.render(cave);

        var letters = new Text(asciiCave, new DefaultLettersAlphabet());
        var grime = new Text(asciiCave, new DefaultGrimesAlphabet());
        var drawing = new Drawing();
        drawing.drawText(letters);
        drawing.drawText(grime);
        var outputPath = Path.of("output.svg");
        Files.writeString(outputPath, SvgSorter.sort(drawing.getSvg()));
    }
}
