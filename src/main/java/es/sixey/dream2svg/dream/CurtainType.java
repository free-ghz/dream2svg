package es.sixey.dream2svg.dream;

public enum CurtainType {
    RANDOM,
    GLOW,
    GLOW_REVERSE,
    ZIGZAG,
    ZIGZAG_REVERSE,
    AUTOMATA,
    TEXT,
    NONE;

    public static CurtainType forValue(String string) {
        return switch (string) {
            case "random" -> RANDOM;
            case "glow" -> GLOW;
            case "reverseglow" -> GLOW_REVERSE;
            case "zigzag" -> ZIGZAG;
            case "reversezigzag" -> ZIGZAG_REVERSE;
            case "automata" -> AUTOMATA;
            case "none" -> NONE;
            default -> {
                System.err.println("I don't understand AlignStrategy " + string);
                yield null;
            }
        };
    }
}
