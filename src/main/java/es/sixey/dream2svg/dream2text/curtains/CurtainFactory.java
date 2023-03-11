package es.sixey.dream2svg.dream2text.curtains;

import es.sixey.dream2svg.dream.CurtainType;

public class CurtainFactory {
    public static Curtain curtainFor(CurtainType type) {
        return new EmptyCurtain(); // hehe
    }
}
