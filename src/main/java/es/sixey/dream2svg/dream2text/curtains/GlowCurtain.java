package es.sixey.dream2svg.dream2text.curtains;

import java.util.Random;

public class GlowCurtain implements Curtain {
    private final Random random = new Random();

    @Override
    public Seam getNext() {
        var bias = random.nextInt(-1 , 4);
        var right = "";
        for (var i = 0; i < 10; i++) {
            var digit = i;
            if (bias >= 1) digit = digit + bias;
            if (digit > 9) digit = 9;
            if (digit < 0) digit = 0;
            if (bias >= 1) {
                bias += random.nextInt(-1, 2);
                if (bias < -1) bias = -1;
            }
            right += digit;
        }
        var left = new StringBuilder(right).reverse().toString();
        return new Seam(left, right);
    }
}
