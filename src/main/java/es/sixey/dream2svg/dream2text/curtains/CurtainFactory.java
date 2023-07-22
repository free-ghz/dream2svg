package es.sixey.dream2svg.dream2text.curtains;

import es.sixey.dream2svg.dream.CurtainType;

public class CurtainFactory {
    public static Curtain curtainFor(CurtainType type, int width, int pageWidth) {
        return switch (type) {
            case NONE -> new EmptyCurtain(width);
            case GLOW -> new GlowCurtain(width);
            case GLOW_REVERSE -> new ReverseGlowCurtain(width);
            case ZIGZAG -> new ZigzagCurtain(width);
            case STARS -> new StarCurtain(width);
            case AUTOMATA -> new AutomataCurtain(width, pageWidth);
            case UNDEFINED -> new UndefinedCurtain(width);
            default -> new GlowCurtain(width);
        };
    }
}
