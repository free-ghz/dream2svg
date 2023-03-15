package es.sixey.dream2svg.signs.alphabets;

import es.sixey.dream2svg.signs.Letter;
import es.sixey.dream2svg.signs.Path;

import java.util.List;

public class DefaultAlphabet implements Alphabet {

    private static final Letter unknown = new Letter(List.of(new Path()
            //.addPoint(0.5, 0.2).addPoint(0.8, 0.5).addPoint(0.5, 0.8).addPoint(0.2, 0.5).addPoint(0.5, 0.2)
            .addPoint(0.5, 0.4).addPoint(0.5, 0.6)
    ));

    @Override
    public Letter letterFor(char c) {
        return switch (c) {
            case '0' -> new Letter(List.of(
                    new Path().addPoint(0.5, 0.0).addPoint(0.85, 0.15).addPoint(1, 0.5).addPoint(0.85, 0.85).addPoint(0.5, 1).addPoint(0.15, 0.85).addPoint(0, 0.5).addPoint(0.15, 0.15).addPoint(0.5, 0),
                    new Path().addPoint(0.5, 0.1).addPoint(0.75, 0.25).addPoint(0.9, 0.5).addPoint(0.75, 0.75).addPoint(0.5, 0.9).addPoint(0.25, 0.75).addPoint(0.1, 0.5).addPoint(0.25, 0.25).addPoint(0.5, 0.1),
                    new Path().addPoint(0.5, 0.2).addPoint(0.8, 0.5).addPoint(0.5, 0.8).addPoint(0.2, 0.5).addPoint(0.5, 0.2 )
            ));
            case '2' -> new Letter(List.of(
                    new Path().addPoint(0.5, 0.15).addPoint(0.7, 0).addPoint(1, 0.3).addPoint(0.85, 0.5).addPoint(1, 0.7).addPoint(0.7, 1).addPoint(0.5, 0.85).addPoint(0.3, 1).addPoint(0, 0.7).addPoint(0.15, 0.5).addPoint(0, 0.3).addPoint(0.3, 0).addPoint(0.5, 0.15),
                    new Path().addPoint(0.7, 0.5).addPoint(0.5, 0.3).addPoint(0.3, 0.5).addPoint(0.5, 0.7).addPoint(0.7, 0.5)
            ));
            case '1' -> new Letter(List.of(
                    new Path().addPoint(0.1, 0.2).addPoint(0.55, 0.45).addPoint(0.9, 0.8).addPoint(0.45, 0.55).addPoint(0.1, 0.2),
                    new Path().addPoint(0.9, 0.2).addPoint(0.45, 0.45).addPoint(0.1, 0.8).addPoint(0.55, 0.55).addPoint(0.9, 0.2),
                    new Path().addPoint(0.5, 0).addPoint(0.6, 0.5).addPoint(0.5, 1).addPoint(0.4, 0.5).addPoint(0.5, 0)
            ));
            case '3' -> new Letter(List.of(
                    new Path().addPoint(0.1, 0.1).addPoint(0.4, 0.6).addPoint(0.9, 0.9).addPoint(0.6, 0.4).addPoint(0.1, 0.1),
                    new Path().addPoint(0.1, 0.9).addPoint(0.6, 0.6).addPoint(0.9, 0.1).addPoint(0.4, 0.4).addPoint(0.1, 0.9)
            ));
            case '4' -> new Letter(List.of(
                    new Path().addPoint(0.5, 0.0).addPoint(0.85, 0.15).addPoint(1, 0.5).addPoint(0.85, 0.85).addPoint(0.5, 1).addPoint(0.15, 0.85).addPoint(0, 0.5).addPoint(0.15, 0.15).addPoint(0.5, 0),
                    new Path().addPoint(0.7, 0.5).addPoint(0.5, 0.3).addPoint(0.3, 0.5).addPoint(0.5, 0.7).addPoint(0.7, 0.5)
            ));
            case '5' -> new Letter(List.of(
                    new Path().addPoint(0.5, 0.1).addPoint(0.9, 0.5).addPoint(0.5, 0.9).addPoint(0.1, 0.5).addPoint(0.5, 0.1),
                    new Path().addPoint(0.5, 0.6).addPoint(0.5, 0.4)
            ));
            case '6' -> new Letter(List.of(
                    new Path().addPoint(0.5, 0.2).addPoint(0.8, 0.5).addPoint(0.5, 0.8).addPoint(0.2, 0.5).addPoint(0.5, 0.2 )
            ));
            case '7' -> new Letter(List.of(
                    new Path().addPoint(0.2, 0.6).addPoint(0.4, 0.4).addPoint(0.6, 0.6).addPoint(0.8, 0.4)// .addPoint(0.2, 0.6) // could skip last point
            ));
            case '8' -> new Letter(List.of(
                    new Path().addPoint(0.7, 0.5).addPoint(0.5, 0.3).addPoint(0.3, 0.5).addPoint(0.5, 0.7)
            ));
            case '9' -> new Letter(List.of(
                    new Path().addPoint(0.5, 0.6).addPoint(0.6, 0.4).addPoint(0.4, 0.4)
            ));
            case 'a' -> new Letter(List.of(
                    new Path().addPoint(0,1).addPoint(0.5,0).addPoint(1, 1),
                    new Path().addPoint(0.25,0.5).addPoint(0.75, 0.5)
            ));
            case 'b' -> new Letter(List.of(
                    new Path().addPoint(0, 0).addPoint(0, 1).addPoint(0.7,1).addPoint(1, 0.7).addPoint(0, 0.5)
            ));
            case 'd' -> new Letter(List.of(
                    new Path().addPoint(1, 0).addPoint(1, 1).addPoint(0.3,1).addPoint(0, 0.7).addPoint(1, 0.5)
            ));
            case 'e' -> new Letter(List.of(
                    new Path().addPoint(1, 0).addPoint(0.5, 0).addPoint(0, 0.5).addPoint(0.5, 1).addPoint(1, 1),
                    new Path().addPoint(0, 0.5).addPoint(1, 0.5)
            ));
            case 'f' -> new Letter(List.of(
                    new Path().addPoint(0.1, 1).addPoint(0.1, 0).addPoint(0.5, 0).addPoint(0, 0.55).addPoint(1, 0.45)
            ));
            case 'h' -> new Letter(List.of(
                    new Path().addPoint(0, 0).addPoint(0, 1),
                    new Path().addPoint(0, 0.6).addPoint(0.7, 0.4).addPoint(0.9, 0.6).addPoint(1, 1)
            ));
            case 'i' -> new Letter(List.of(
                    new Path().addPoint(0.5, 0.2).addPoint(0.4, 0.1).addPoint(0.5, 0).addPoint(0.6, 0.1).addPoint(0.5, 0.2).addPoint(0.5, 1)
            ));
            case 'n' -> new Letter(List.of(
                    new Path().addPoint(0, 0.2).addPoint(0.2, 0).addPoint(0.2, 1),
                    new Path().addPoint(0.2, 0.2).addPoint(0.4, 0).addPoint(0.7, 0).addPoint(1, 0.15).addPoint(1, 1)
            ));
            case 'p' -> new Letter(List.of(
                    new Path().addPoint(0, 1).addPoint(0, 0).addPoint(0.7,0).addPoint(1, 0.3).addPoint(0, 0.5)
            ));
            case 'q' -> new Letter(List.of(
                    new Path().addPoint(1, 1).addPoint(1, 0).addPoint(0.3,0).addPoint(0, 0.3).addPoint(1, 0.5),
                    new Path().addPoint(1, 0.7).addPoint(0.8, 0.7)
            ));
            case 'r' -> new Letter(List.of(
                    new Path().addPoint(0, 1).addPoint(0, 0),
                    new Path().addPoint(0, 0.1).addPoint(0.7, 0).addPoint(0.9, 0.15).addPoint(1, 0.4)
            ));
            case 's' -> new Letter(List.of(
                    new Path().addPoint(0, 0.8).addPoint(0.2, 1).addPoint(0.8, 1).addPoint(1, 0.8).addPoint(0, 0.2).addPoint(0.2, 0).addPoint(0.8, 0).addPoint(1, 0.2).addPoint(1, 0)
            ));
            case 't' -> new Letter(List.of(
                    new Path().addPoint(0, 0).addPoint(1, 0),
                    new Path().addPoint(0.5, 0).addPoint(0.5, 1)
            ));
            case 'w' -> new Letter(List.of(
                    new Path().addPoint(0, 0).addPoint(0.25, 1).addPoint(0.5, 0.5).addPoint(0.75, 1).addPoint(1, 0)
            ));
            case 'y' -> new Letter(List.of(
                    new Path().addPoint(0, 0).addPoint(0.5, 0.5).addPoint(1, 0),
                    new Path().addPoint(0.5, 0.5).addPoint(0.5, 1)
            ));
            case ' ' -> null;
            default -> unknown;
        };
    }
}
