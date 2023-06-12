package es.sixey.dream2svg.dream;

public enum CurtainType {
    RANDOM,
    GLOW,
    GLOW_REVERSE,
    ZIGZAG,
    AUTOMATA,
    STARS,
    UNDEFINED,
    TEXT,
    NONE;

    public static CurtainType forValue(String string) {
        return switch (string) {
            case "random" -> RANDOM;
            case "glow" -> GLOW;
            case "reverseglow" -> GLOW_REVERSE;
            case "zigzag" -> ZIGZAG;
            case "automata" -> AUTOMATA;
            case "stars" -> STARS;
            case "undefined" -> UNDEFINED;
            case "none" -> NONE;
            default -> TEXT;
        };
    }
}
