package es.sixey.dream2svg.dream2text.curtains;

import java.util.Arrays;
import java.util.Random;

public class AutomataCurtain extends Curtain {

    public static void main(String[] fuckuppppp) {
        int width = 17;
        int height = 25;
        var automata = new AutomataCurtain(width, 0);
        for (var i = 0; i < height; i++) {
            System.out.println(automata.getNext().left());
        }
    }

    private static final int[] NICE_RULES = new int[]{60, 102, 99, 26, 129};

    private final int curtainWidth;
    private final int[] rule;
    private String[] outputCharacters;
    private int[] state;

    public AutomataCurtain(int curtainWidth, int pageWidth) {
        super(curtainWidth + curtainWidth + pageWidth);
        this.curtainWidth = curtainWidth;
        Random random = new Random();
        outputCharacters = new String[]{
                Integer.toString(random.nextInt(3) + 7),
                Integer.toString(random.nextInt(3) + 1)
        };
        var ruleNumber = NICE_RULES[random.nextInt(NICE_RULES.length)];
        rule = ruleForInt(ruleNumber);
        state = new int[width];
        for (var i = 0; i < width; i++) state[i] = random.nextInt(2);
    }

    @Override
    public Seam getNext() {
        state = iterate(state, rule);
        var spread = mapToCharacters(state, outputCharacters);
        return new Seam(spread.substring(0, curtainWidth), spread.substring(spread.length()-curtainWidth));
    }

    private int[] ruleForInt(int ruleNumber) {
        var ruleBinary = Integer.toBinaryString(ruleNumber);
        var paddedBinary = "00000000" + ruleBinary;
        return Arrays.stream(paddedBinary.substring(paddedBinary.length() - 8).split(""))
                .mapToInt(Integer::valueOf).toArray();
    }

    private int[] iterate(int[] previous, int[] rule) {
        var output = new int[previous.length];
        for (var i = 0; i < previous.length; i++) {
            var mask = 0;
            if (previous[(i + previous.length - 1) % previous.length] == 1) mask += 4;
            if (previous[i] == 1) mask += 2;
            if (previous[(i + previous.length + 1) % previous.length] == 1) mask += 1;
            output[i] = rule[mask];
        }
        return output;
    }

    // lookup table for what to give to the grimer. automata uses 0 or 1 for state, so we can use an array here
    // with a number in the 0th and 1st positions.
    private String mapToCharacters(int[] input, String[] values) {
        var output = "";
        for (int j : input) {
            output += values[j];
        }
        return output;
    }

    public void setOutputCharacters(String[] outputCharacters) {
        this.outputCharacters = outputCharacters;
    }
}
