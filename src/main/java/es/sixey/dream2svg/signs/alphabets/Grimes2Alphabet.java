package es.sixey.dream2svg.signs.alphabets;

import es.sixey.dream2svg.signs.Letter;
import es.sixey.dream2svg.signs.Path;

import java.util.List;

public class Grimes2Alphabet implements Alphabet {
    @Override
    public Letter letterFor(char c) {
        return switch (c) {
            case '0' -> new Letter(List.of(
                    new Path()
                            .addPoint(0.5, 0.0).addPoint(0.85, 0.15).addPoint(1, 0.5).addPoint(0.85, 0.85).addPoint(0.5, 1).addPoint(0.15, 0.85).addPoint(0, 0.5).addPoint(0.15, 0.15)
                            .addPoint(0.5, 0.2).addPoint(0.8, 0.5).addPoint(0.5, 0.8).addPoint(0.2, 0.5).addPoint(0.5, 0.3 )
            ));
            case '1' -> new Letter(List.of(
                    new Path()
                            .addPoint(0.9, 0.2).addPoint(0.5, 0.1).addPoint(0.1, 0.2)
                            .addPoint(0, 0.4).addPoint(0.1, 0.5).addPoint(0.9, 0.5).addPoint(1, 0.6)
                            .addPoint(0.9, 0.8).addPoint(0.5, 0.9).addPoint(0.1, 0.8),
                    new Path().addPoint(0.5, 1).addPoint(0.5, 0)
            ));
            case '3' -> new Letter(List.of(
                    new Path().addPoint(0.1, 0.2).addPoint(0.9, 0.8),
                    new Path().addPoint(0.9, 0.2).addPoint(0.1, 0.8),
                    new Path().addPoint(0.5, 0).addPoint(0.5, 1)
            ));
            case '2' -> new Letter(List.of(
                    new Path()
                            .addPoint(0, 0.5).addPoint(0.5, 0).addPoint(1, 0.5).addPoint(0.5, 1).addPoint(0, 0.5).addPoint(1, 0.5)
            ));
            case '4' -> new Letter(List.of(
                    new Path()
                            .addPoint(0, 0.5).addPoint(0.5, 0).addPoint(1, 0.5).addPoint(0.5, 1).addPoint(0, 0.5)
            ));
            case '5' -> new Letter(List.of(
                    new Path().addPoint(0.5, 0.9).addPoint(0.5,0.1).addPoint(0.5,0.35).addPoint(0.8, 0.35).addPoint(0.2, 0.35)
            ));
            case '6' -> new Letter(List.of(
                    new Path()
                            .addPoint(0.5, 0.3).addPoint(0.2 , 0.8).addPoint(0.8, 0.8).addPoint(0.5, 0.3)
            ));
            case '7' -> new Letter(List.of(
                    new Path().addPoint(0.1, 0.6).addPoint(0.4, 0.4).addPoint(0.6, 0.6).addPoint(0.9, 0.4)
            ));
            case '8' -> new Letter(List.of(
                    new Path().addPoint(0.65, 0.65).addPoint(0.35, 0.35).addPoint(0.65, 0.35).addPoint(0.35, 0.65)
            ));
            case '9' -> new Letter(List.of(
                    new Path().addPoint(0.5, 0.6).addPoint(0.5, 0.4)
            ));
            default -> null;
        };
    }
}
