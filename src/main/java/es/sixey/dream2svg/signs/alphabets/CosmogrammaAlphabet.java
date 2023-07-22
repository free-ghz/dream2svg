package es.sixey.dream2svg.signs.alphabets;

import es.sixey.dream2svg.signs.Letter;
import es.sixey.dream2svg.signs.Path;

import java.util.List;

public class CosmogrammaAlphabet implements Alphabet {

    @Override
    public Letter letterFor(char c) {
        return switch (c) {
            case '.' -> new Letter(List.of(
                    new Path().addPoint(0.1, 0.8).addPoint(0.2, 0.9).addPoint(0.3, 0.8).addPoint(0.2, 0.7).addPoint(0.1, 0.8)
            ));
            case ':' -> new Letter(List.of(
                    new Path().addPoint(0.1, 0.8).addPoint(0.2, 0.9).addPoint(0.3, 0.8).addPoint(0.2, 0.7).addPoint(0.1, 0.8),
                    new Path().addPoint(0.1, 0.3).addPoint(0.2, 0.4).addPoint(0.3, 0.3).addPoint(0.2, 0.2).addPoint(0.1, 0.3)
            ));
            case ',' -> new Letter(List.of(
                    new Path().addPoint(0.3, 0.8).addPoint(0.3, 0.9).addPoint(0.15, 1)
            ));
            case '!' -> new Letter(List.of(
                    new Path().addPoint(0.5, 0.8).addPoint(0.4, 0.9).addPoint(0.5, 1).addPoint(0.6, 0.9).addPoint(0.5, 0.8),
                    new Path().addPoint(0.5, 0.7).addPoint(0.5, 0)
            ));
            case '?' -> new Letter(List.of(
                    new Path().addPoint(0.5, 0.8).addPoint(0.4, 0.9).addPoint(0.5, 1).addPoint(0.6, 0.9).addPoint(0.5, 0.8),
                    new Path().addPoint(0.5, 0.7).addPoint(0.5, 0.6).addPoint(0.8, 0.5).addPoint(0.9, 0.2).addPoint(0.7, 0).addPoint(0.3, 0).addPoint(0.1, 0.2).addPoint(0.2, 0.5)
            ));
            case '-' -> new Letter(List.of(
                    new Path().addPoint(0.25, 0.5).addPoint(0.75, 0.45)
            ));
            case '_' -> new Letter(1, 1.2, List.of(
                    new Path().addPoint(0.1, 1).addPoint(0.9, 1)
            ));
            case '/' -> new Letter(List.of(
                    new Path().addPoint(0.1, 1).addPoint(0.9, 0)
            ));
            case '\'' -> new Letter(List.of(
                    new Path().addPoint(0.5, 0).addPoint(0.5, 0.25)
            ));
            case '"' -> new Letter(List.of(
                    new Path().addPoint(0.25, 0).addPoint(0.2, 0.25),
                    new Path().addPoint(0.75, 0).addPoint(0.7, 0.25)
            ));
            case '(' -> new Letter(List.of(
                    new Path().addPoint(0.6, 0).addPoint(0.4, 0.4).addPoint(0.4, 0.6).addPoint(0.6, 1)
            ));
            case ')' -> new Letter(List.of(
                    new Path().addPoint(0.4, 0).addPoint(0.6, 0.4).addPoint(0.6, 0.6).addPoint(0.4, 1)
            ));
            case '~' -> new Letter(List.of(
                    new Path().addPoint(0.2, 0.6).addPoint(0.4, 0.4).addPoint(0.6, 0.6).addPoint(0.8, 0.4)
            ));
            case ' ' -> new Letter(List.of());


            default -> null;

            case 'a' -> new Letter(List.of(
                    new Path().addPoint(0, 1).addPoint(0.5, 0).addPoint(1, 1)
                            .addPoint(0.85, 0.7).addPoint(0.15, 0.7)
            ));
            case 'b' -> new Letter(List.of(
                    new Path()
                            .addPoint(0, 0.5).addPoint(0.9, 0.5).addPoint(1, 0.75).addPoint(0.9, 1).addPoint(0, 1)
                            .addPoint(0, 0).addPoint(0.8, 0).addPoint(0.9, 0.25).addPoint(0.8, 0.5)
            ));
            case 'c' -> new Letter(List.of(
                    new Path()
                            .addPoint(0.925, 0.2).addPoint(0.9, 0.1).addPoint(0.5, 0).addPoint(0.1, 0.1)
                            .addPoint(0, 0.5).addPoint(0.1, 0.9).addPoint(0.5, 1).addPoint(0.9, 0.9).addPoint(0.925, 0.8)
            ));
            case 'd' -> new Letter(List.of(
                    new Path()
                            .addPoint(0, 0).addPoint(0, 1).addPoint(0.7, 1).addPoint(0.9, 0.9)
                            .addPoint(1, 0.5).addPoint(0.9, 0.1).addPoint(0.7, 0).addPoint(0, 0)
            ));
            case 'e' -> new Letter(List.of(
                    new Path().addPoint(1, 0).addPoint(0, 0).addPoint(0, 1).addPoint(1, 1),
                    new Path().addPoint(0, 0.5).addPoint(1, 0.5)
            ));
            case 'f' -> new Letter(List.of(
                    new Path().addPoint(1, 0).addPoint(0, 0).addPoint(0, 1),
                    new Path().addPoint(0, 0.5).addPoint(1, 0.5)
            ));
            case 'g' -> new Letter(List.of(
                    new Path()
                            .addPoint(0.925, 0.2).addPoint(0.9, 0.1).addPoint(0.5, 0).addPoint(0.1, 0.1)
                            .addPoint(0, 0.5).addPoint(0.1, 0.9).addPoint(0.5, 1).addPoint(0.9, 0.9)
                            .addPoint(1, 0.5).addPoint(0.5, 0.5)
            ));
            case 'h' -> new Letter(List.of(
                    new Path() // lazy version without lifting
                            .addPoint(0, 0).addPoint(0, 1).addPoint(0, 0.5)
                            .addPoint(1, 0.5).addPoint(1, 0).addPoint(1, 1)
            ));
            case 'i' -> new Letter(List.of(
                    new Path().addPoint(0.5, 1).addPoint(0.5, 0)
            ));
            case 'j' -> new Letter(List.of(
                    new Path()
                            .addPoint(0, 0.7).addPoint(0.1, 0.9).addPoint(0.5, 1)
                            .addPoint(0.9, 0.9).addPoint(1, 0.7).addPoint(1, 0)
            ));
            case 'k' -> new Letter(List.of(
                    new Path().addPoint(0, 0).addPoint(0, 1).addPoint(0, 0.5).addPoint(0.4, 0.5),
                    new Path().addPoint(1, 1).addPoint(0.4, 0.5).addPoint(1, 0)
            ));
            case 'l' -> new Letter(List.of(
                    new Path().addPoint(0, 0).addPoint(0, 1).addPoint(1, 1)
            ));
            case 'm' -> new Letter(List.of(
                    new Path()
                            .addPoint(0, 1).addPoint(0, 0).addPoint(0.1, 0).addPoint(0.5, 1)
                            .addPoint(0.9, 0).addPoint(1, 0).addPoint(1, 1)
            ));
            case 'n' -> new Letter(List.of(
                    new Path()
                            .addPoint(0, 1).addPoint(0, 0).addPoint(0.1, 0)
                            .addPoint(0.9, 1).addPoint(1, 1).addPoint(1, 0)
            ));
            case 'o' -> new Letter(List.of(
                    new Path().addPoint(0, 0.5).addPoint(0.1, 0.9).addPoint(0.5, 1).addPoint(0.9, 0.9)
                            .addPoint(1, 0.5).addPoint(0.9, 0.1).addPoint(0.5, 0).addPoint(0.1, 0.1)
                            .addPoint(0, 0.5)
            ));
            case 'p' -> new Letter(List.of(
                    new Path()
                            .addPoint(0, 1).addPoint(0, 0).addPoint(0.7, 0).addPoint(0.9, 0.1).addPoint(1, 0.25)
                            .addPoint(0.9, 0.4).addPoint(0.7, 0.5).addPoint(0, 0.5)
            ));
            case 'q' -> new Letter(List.of(
                    new Path().addPoint(0, 0.5).addPoint(0.1, 0.9).addPoint(0.5, 1).addPoint(0.9, 0.9)
                            .addPoint(1, 0.5).addPoint(0.9, 0.1).addPoint(0.5, 0).addPoint(0.1, 0.1)
                            .addPoint(0, 0.5),
                    new Path().addPoint(0.5, 0.5).addPoint(1, 1)
            ));
            case 'r' -> new Letter(List.of(
                    new Path()
                            .addPoint(0, 1).addPoint(0, 0).addPoint(0.7, 0).addPoint(0.9, 0.1).addPoint(1, 0.25)
                            .addPoint(0.9, 0.4).addPoint(0.7, 0.5).addPoint(0, 0.5),
                    new Path().addPoint(0.7, 0.5).addPoint(0.9, 0.6).addPoint(1, 0.7).addPoint(1, 1)
            ));
            case 's' -> new Letter(List.of(
                    new Path()
                            .addPoint(0.925, 0.2).addPoint(0.9, 0.1).addPoint(0.5, 0).addPoint(0.1, 0.1)
                            .addPoint(0, 0.3).addPoint(0.1, 0.5).addPoint(0.9, 0.5).addPoint(1, 0.7)
                            .addPoint(0.9, 0.9).addPoint(0.5, 1).addPoint(0.1, 0.9).addPoint(0.075, 0.8)
            ));
            case 't' -> new Letter(List.of(
                    new Path().addPoint(0.5, 1).addPoint(0.5, 0).addPoint(1, 0).addPoint(0, 0)
            ));
            case 'u' -> new Letter(List.of(
                    new Path()
                            .addPoint(0, 0).addPoint(0, 0.7).addPoint(0.1, 0.9).addPoint(0.5, 1)
                            .addPoint(0.9, 0.9).addPoint(1, 0.7).addPoint(1, 0)
            ));
            case 'v' -> new Letter(List.of(
                    new Path().addPoint(0, 0).addPoint(0.5, 1).addPoint(1, 0)
            ));
            case 'w' -> new Letter(List.of(
                    new Path().addPoint(0, 0).addPoint(0.25, 1).addPoint(0.5, 0).addPoint(0.75, 1).addPoint(1, 0)
            ));
            case 'x' -> new Letter(List.of(
                    new Path().addPoint(0, 0).addPoint(1, 1),
                    new Path().addPoint(0, 1).addPoint(1, 0)
            ));
            case 'y' -> new Letter(List.of(
                    new Path().addPoint(1, 0).addPoint(0.5, 0.6).addPoint(0.5, 1),
                    new Path().addPoint(0.5, 0.6).addPoint(0, 0)
            ));
            case 'z' -> new Letter(List.of(
                    new Path().addPoint(0, 0).addPoint(1, 0).addPoint(0, 1).addPoint(1, 1)
            ));
        };
    }
}
