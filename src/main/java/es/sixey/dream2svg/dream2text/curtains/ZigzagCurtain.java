package es.sixey.dream2svg.dream2text.curtains;

import java.util.Random;

public class ZigzagCurtain implements Curtain {
    private static final int MIN_WIDTH = 11;
    private static final int MAX_WIDTH = 24;
    private final Random random = new Random();

    private boolean currentDirection = random.nextBoolean();
    private boolean reverseOutput;
    private String basePattern = "";
    private int position = 0;
    private final int maxPosition;

    public ZigzagCurtain() {
        var width = random.nextInt(MIN_WIDTH, MAX_WIDTH);
        var generationBias = random.nextInt(-2, 1);
        for (var i = 0; i < width; i++) {
            var digit = i;
            if (generationBias >= 1) digit = digit + generationBias;
            if (digit > 9) digit = 9;
            if (digit < 0) digit = 0;
            if (generationBias >= 1) {
                generationBias += random.nextInt(-1, 2);
                if (generationBias < -1) generationBias = -1;
            }
            basePattern += digit;
        }
        basePattern += basePattern;

        maxPosition = width - 10; // curtains are 10 wide
        var i = random.nextInt(maxPosition);
        if (i == 0) {
            currentDirection = false;
        } else if (i == maxPosition) {
            currentDirection = true;
        }
        reverseOutput = random.nextBoolean();
    }

    @Override
    public Seam getNext() {
        var current = basePattern.substring(position, position + 10);
        if (currentDirection) {
            position -= 1;
            if (position <= 0) currentDirection = false;
        } else {
            position += 1;
            if (position >= maxPosition) currentDirection = true;
        }

        var reversed = new StringBuilder(current).reverse().toString();
        if (reverseOutput) return new Seam(current, reversed);
        return new Seam(reversed, current);
    }
}
