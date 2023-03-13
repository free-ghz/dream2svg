package es.sixey.dream2svg.signs.alphabets;

import es.sixey.dream2svg.signs.Letter;
import es.sixey.dream2svg.signs.Path;

import java.util.List;

public class DefaultAlphabet implements Alphabet {

    private static Letter unknown = new Letter(List.of(new Path()
            .addPoint(0.5, 0.2).addPoint(0.8, 0.5).addPoint(0.5, 0.8).addPoint(0.2, 0.5).addPoint(0.5, 0.2)
    ));

    @Override
    public Letter letterFor(char c) {
        return switch (c) {
            case 'a' -> new Letter(List.of(
                    new Path().addPoint(0,1).addPoint(0.5,0).addPoint(1, 1),
                    new Path().addPoint(0.25,0.5).addPoint(0.75, 0.5)
            ));
            case 'e' -> new Letter(List.of(
                    new Path().addPoint(1, 0).addPoint(0.5, 0).addPoint(0, 0.5).addPoint(0.5, 1).addPoint(1, 1),
                    new Path().addPoint(0, 0.5).addPoint(1, 0.5)
            ));
            case 't' -> new Letter(List.of(
                    new Path().addPoint(0, 0).addPoint(1, 0),
                    new Path().addPoint(0.5, 0).addPoint(0.5, 1)
            ));
            case ' ' -> null;
            default -> unknown;
        };
    }
}
