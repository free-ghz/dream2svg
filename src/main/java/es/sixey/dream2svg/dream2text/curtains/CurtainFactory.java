package es.sixey.dream2svg.dream2text.curtains;

import es.sixey.dream2svg.dream.CurtainType;

public class CurtainFactory {
    public static Curtain curtainFor(CurtainType type) {
        return switch (type) {
            case NONE -> new EmptyCurtain();
            case GLOW -> new GlowCurtain();
            case GLOW_REVERSE -> new ReverseGlowCurtain();
            case ZIGZAG -> new ZigzagCurtain();
            case STARS -> new StarCurtain();
            case UNDEFINED -> new UndefinedCurtain();
            default -> new EmptyCurtain();
        };
    }
}
