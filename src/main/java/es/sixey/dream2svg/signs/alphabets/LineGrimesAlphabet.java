package es.sixey.dream2svg.signs.alphabets;

import es.sixey.dream2svg.signs.Letter;
import es.sixey.dream2svg.signs.Path;

import java.util.List;

public class LineGrimesAlphabet implements Alphabet{
    @Override
    public Letter letterFor(char c) {
        return switch (c) {
            case '0' -> new Letter(List.of(
                    new Path().addPoint(0, 1).addPoint(1, 0)
            ));
            case '1' -> new Letter(List.of(
                    new Path().addPoint(0.04, 1-0.05).addPoint(1-0.04, 0.05)
            ));
            case '2' -> new Letter(List.of(
                    new Path().addPoint(0.08, 0.9).addPoint(1-0.08, 0.1)
            ));
            case '3' -> new Letter(List.of(
                    new Path().addPoint(0.12, 0.85).addPoint(1-0.12, 0.15)
            ));
            case '4' -> new Letter(List.of(
                    new Path().addPoint(0.16, 0.8).addPoint(1-0.16, 0.2)
            ));
            case '5' -> new Letter(List.of(
                    new Path().addPoint(0.2, 0.75).addPoint(1-0.2, 0.25)
            ));
            case '6' -> new Letter(List.of(
                    new Path().addPoint(0.24, 0.7).addPoint(1-0.24, 0.3)
            ));
            case '7' -> new Letter(List.of(
                    new Path().addPoint(0.28, 0.65).addPoint(1-0.28, 0.35)
            ));
            case '8' -> new Letter(List.of(
                    new Path().addPoint(0.32, 0.6).addPoint(1-0.32, 0.4)
            ));
            case '9' -> new Letter(List.of(
                    new Path().addPoint(0.36, 0.55).addPoint(1-0.36, 0.45)
            ));
            default -> null;
        };
    }
}
