package es.sixey.dream2svg.dream2text.curtains;

import java.util.Random;

public class ZigzagCurtain extends Curtain {
    private static final int MIN_WIDTH_ADD = 1;
    private static final int MAX_WIDTH_ADD = 13;
    private final Random random = new Random();

    private boolean currentDirection = random.nextBoolean();
    private final boolean reverseOutput;
    private String basePattern = "";
    private int position = 0;
    private final int maxPosition;

    public ZigzagCurtain(int width) {
        super(width);
        var windowWidth = random.nextInt(width + MIN_WIDTH_ADD, width + MAX_WIDTH_ADD);
        var generationBias = random.nextInt(-2, 1);
        for (var i = windowWidth - 1; i >= 0 ; i--) {
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

        maxPosition = windowWidth - width;
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
        var current = basePattern.substring(position, position + width);
        if (currentDirection) {
            position -= 1;
            if (position <= 0) {
                position = 0;
                currentDirection = false;
            }
        } else {
            position += 1;
            if (position >= maxPosition) {
                position = maxPosition;
                currentDirection = true;
            }
        }

        var reversed = new StringBuilder(current).reverse().toString();
        if (reverseOutput) return new Seam(current, reversed);
        return new Seam(reversed, current);
    }
}
