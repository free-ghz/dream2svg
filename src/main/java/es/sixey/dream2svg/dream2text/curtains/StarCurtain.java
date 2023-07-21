package es.sixey.dream2svg.dream2text.curtains;

import es.sixey.dream2svg.util.LineUtil;

import javax.sound.sampled.Line;
import java.util.List;
import java.util.Random;

public class StarCurtain extends Curtain {
    private final Random random = new Random();
    private final String space;

    private static final List<String> STARS = List.of("5", "8", "9", "9", "9");

    public StarCurtain(int width) {
        super(width);
        space = LineUtil.spaces(width);
    }

    @Override
    public Seam getNext() {
        return new Seam(getPane(), getPane());
    }

    private String getPane() {
        if (random.nextInt(5) != 0) return space;
        var star = space + star() + space;
        var starPos = random.nextInt(width);
        return star.substring(starPos, starPos+width);
    }

    private String star() {
        var star = random.nextInt(STARS.size());
        return STARS.get(star);
    }
}
