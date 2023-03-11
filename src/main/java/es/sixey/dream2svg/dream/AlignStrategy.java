package es.sixey.dream2svg.dream;

import java.util.Random;

public enum AlignStrategy {
        AUTO,
        AUTO_LEFT,
        CENTER,
        NONE,
        BLOCK;

        public static AlignStrategy forValue(String string) {
                return switch (string) {
                        case "auto" -> AUTO;
                        case "left" -> AUTO_LEFT;
                        case "center" -> CENTER;
                        case "none", "no"-> NONE;
                        case "block" -> BLOCK;
                        case "random" -> {
                                Random random = new Random();
                                var which = random.nextInt(AlignStrategy.values().length);
                                yield AlignStrategy.values()[which];
                        }
                        default -> {
                                System.err.println("I don't understand AlignStrategy " + string);
                                yield null;
                        }
                };
        }
}