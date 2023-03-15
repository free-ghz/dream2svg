package es.sixey.dream2svg.signs.alphabets;

import es.sixey.dream2svg.signs.Letter;
import es.sixey.dream2svg.signs.Path;

import java.util.List;

public class DefaultLettersAlphabet implements Alphabet {

    @Override
    public Letter letterFor(char c) {
        return switch (c) {
            case 'a' -> new Letter(1.1, 1.2, List.of(
                    new Path().addPoint(0,1).addPoint(0.5,0).addPoint(1, 1),
                    new Path().addPoint(0.25,0.5).addPoint(0.75, 0.5)
            ));
            case 'b' -> new Letter(1.1, 1.2, List.of(
                    new Path().addPoint(0, 0).addPoint(0, 1).addPoint(0.7,1).addPoint(1, 0.7).addPoint(0, 0.5)
            ));
            case 'c' -> new Letter(1.1, 1.2, List.of(
                    new Path().addPoint(1, 0).addPoint(0.5, 0).addPoint(0, 0.5).addPoint(0.5, 1).addPoint(1, 1)
            ));
            case 'd' -> new Letter(1.1, 1.2, List.of(
                    new Path().addPoint(1, 0).addPoint(1, 1).addPoint(0.3,1).addPoint(0, 0.7).addPoint(1, 0.5)
            ));
            case 'e' -> new Letter(1.1, 1.2, List.of(
                    new Path().addPoint(1, 0).addPoint(0.5, 0).addPoint(0, 0.5).addPoint(0.5, 1).addPoint(1, 1),
                    new Path().addPoint(0, 0.5).addPoint(1, 0.5)
            ));
            case 'f' -> new Letter(1.1, 1.2, List.of(
                    new Path().addPoint(0.1, 1).addPoint(0.1, 0).addPoint(0.5, 0).addPoint(0, 0.55).addPoint(1, 0.45)
            ));
            case 'g' -> new Letter(1.1, 1.2, List.of(
                    new Path().addPoint(0, 1).addPoint(0.8, 1).addPoint(1, 0.8).addPoint(0.8, 0.6).addPoint(0.2, 0.6).addPoint(0.1, 0.5).addPoint(0.2, 0.4).addPoint(0.7, 0.4).addPoint(0.9, 0.2).addPoint(0.7, 0).addPoint(0.2, 0).addPoint(0, 0.2).addPoint(0.2, 0.4),
                    new Path().addPoint(0.8, 0.1).addPoint(0.9, 0)
            ));
            case 'h' -> new Letter(1.1, 1.2, List.of(
                    new Path().addPoint(0, 0).addPoint(0, 1),
                    new Path().addPoint(0, 0.6).addPoint(0.7, 0.4).addPoint(0.9, 0.6).addPoint(1, 1)
            ));
            case 'i' -> new Letter(1.1, 1.2, List.of(
                    new Path().addPoint(0.5, 0.2).addPoint(0.4, 0.1).addPoint(0.5, 0).addPoint(0.6, 0.1).addPoint(0.5, 0.2).addPoint(0.5, 1)
            ));
            case 'j' -> new Letter(1.1, 1.2, List.of(
                    new Path().addPoint(0, 0.1).addPoint(0.9, 0).addPoint(1, 0.1).addPoint(1, 0.6).addPoint(0.9, 1).addPoint(0, 0.7)
            ));
            case 'k' -> new Letter(1.1, 1.2, List.of(
                    new Path().addPoint(0, 0).addPoint(0, 1).addPoint(0.5, 0).addPoint(0, 0.5).addPoint(1, 1)
            ));
            case 'l' -> new Letter(1.1, 1.2, List.of(
                    new Path().addPoint(0,0).addPoint(0, 0.9).addPoint(0.1, 1).addPoint(1, 1)
            ));
            case 'm' -> new Letter(1.1, 1.2, List.of(
                    new Path().addPoint(0, 1).addPoint(0.25, 0).addPoint(0.5, 0.5).addPoint(0.75, 0).addPoint(1, 1)
            ));
            case 'n' -> new Letter(1.1, 1.2, List.of(
                    new Path().addPoint(0, 0.2).addPoint(0.2, 0).addPoint(0.2, 1),
                    new Path().addPoint(0.2, 0.2).addPoint(0.4, 0).addPoint(0.7, 0).addPoint(1, 0.15).addPoint(1, 1)
            ));
            case 'o' -> new Letter(1.1, 1.2, List.of(
                    new Path().addPoint(0.5, 0.0).addPoint(0.85, 0.15).addPoint(1, 0.5).addPoint(0.85, 0.85).addPoint(0.5, 1).addPoint(0.15, 0.85).addPoint(0, 0.5).addPoint(0.15, 0.15).addPoint(0.5, 0)
            ));
            case 'p' -> new Letter(1.1, 1.2, List.of(
                    new Path().addPoint(0, 1).addPoint(0, 0).addPoint(0.7,0).addPoint(1, 0.3).addPoint(0, 0.5)
            ));
            case 'q' -> new Letter(1.1, 1.2, List.of(
                    new Path().addPoint(1, 1).addPoint(1, 0).addPoint(0.3,0).addPoint(0, 0.3).addPoint(1, 0.5),
                    new Path().addPoint(1, 0.7).addPoint(0.8, 0.7)
            ));
            case 'r' -> new Letter(1.1, 1.2, List.of(
                    new Path().addPoint(0, 1).addPoint(0, 0),
                    new Path().addPoint(0, 0.1).addPoint(0.7, 0).addPoint(0.9, 0.15).addPoint(1, 0.4)
            ));
            case 's' -> new Letter(1.1, 1.2, List.of(
                    new Path().addPoint(0, 0.8).addPoint(0.2, 1).addPoint(0.8, 1).addPoint(1, 0.8).addPoint(0, 0.2).addPoint(0.2, 0).addPoint(0.8, 0).addPoint(1, 0.2).addPoint(1, 0)
            ));
            case 't' -> new Letter(1.1, 1.2, List.of(
                    new Path().addPoint(0, 0).addPoint(1, 0),
                    new Path().addPoint(0.5, 0).addPoint(0.5, 1)
            ));
            case 'u' -> new Letter(1.1, 1.2, List.of(
                    new Path().addPoint(0, 0).addPoint(0, 0.5).addPoint(0.15, 0.85).addPoint(0.5, 1).addPoint(0.85, 0.85).addPoint(1, 0.5).addPoint(1, 0)
            ));
            case 'v' -> new Letter(1.1, 1.2, List.of(
                    new Path().addPoint(0, 0).addPoint(0.5, 1).addPoint(1, 0)
            ));
            case 'w' -> new Letter(1.1, 1.2, List.of(
                    new Path().addPoint(0, 0).addPoint(0.25, 1).addPoint(0.5, 0.5).addPoint(0.75, 1).addPoint(1, 0)
            ));
            case 'x' -> new Letter(1.1, 1.2, List.of(
                    new Path().addPoint(0, 0).addPoint(1, 1),
                    new Path().addPoint(1, 0).addPoint(0, 1)
            ));
            case 'y' -> new Letter(1.1, 1.2, List.of(
                    new Path().addPoint(0, 0).addPoint(0.5, 0.5).addPoint(1, 0),
                    new Path().addPoint(0.5, 0.5).addPoint(0.5, 1)
            ));
            case 'z' -> new Letter(1.1, 1.2, List.of(
                    new Path().addPoint(0.1, 0).addPoint(0.9, 0).addPoint(0, 1).addPoint(1, 1),
                    new Path().addPoint(0.4, 0.5).addPoint(0.6, 0.5)
            ));
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
            case '(' -> new Letter(List.of(
                    new Path().addPoint(0.6, 0).addPoint(0.4, 0.4).addPoint(0.4, 0.6).addPoint(0.6, 1)
            ));
            case ')' -> new Letter(List.of(
                    new Path().addPoint(0.4, 0).addPoint(0.6, 0.4).addPoint(0.6, 0.6).addPoint(0.4, 1)
            ));
            case ' ' -> new Letter(List.of());
            default -> null;
        };
    }
}
