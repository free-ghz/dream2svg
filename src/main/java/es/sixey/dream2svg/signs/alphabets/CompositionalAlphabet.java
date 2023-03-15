package es.sixey.dream2svg.signs.alphabets;

import es.sixey.dream2svg.signs.Letter;
import es.sixey.dream2svg.signs.Path;

import java.util.ArrayList;
import java.util.List;

public class CompositionalAlphabet implements Alphabet{

    private static final Letter unknown = new Letter(List.of(
            new Path().addPoint(0, 0).addPoint(0, 1).addPoint(1, 1).addPoint(1, 0).addPoint(0, 0).addPoint(1, 1),
            new Path().addPoint(1, 0).addPoint(0, 1)
    ));

    private final List<Alphabet> alphabets;

    public CompositionalAlphabet(List<Alphabet> alphabets) {
        this.alphabets = alphabets;
    }

    @Override
    public Letter letterFor(char c) {
        for (var alphabet : alphabets) {
            var attempt = alphabet.letterFor(c);
            if (attempt != null) return attempt;
        }
        return unknown;
    }
}
