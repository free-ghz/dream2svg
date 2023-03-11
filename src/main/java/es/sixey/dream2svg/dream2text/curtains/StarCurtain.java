package es.sixey.dream2svg.dream2text.curtains;

import java.util.List;
import java.util.Random;

public class StarCurtain implements Curtain {
    private final Random random = new Random();

    private static final List<String> STARS = List.of("5", "8", "9", "9", "9");

    @Override
    public Seam getNext() {
        return new Seam(getPane(), getPane());
    }

    private String getPane() {
        if (random.nextInt(5) != 0) return  "          ";
        var star = "          " + star() + "          ";
        var starPos = random.nextInt(10);
        return star.substring(starPos, starPos+10);
    }

    private String star() {
        var star = random.nextInt(STARS.size());
        return STARS.get(star);
    }
}
