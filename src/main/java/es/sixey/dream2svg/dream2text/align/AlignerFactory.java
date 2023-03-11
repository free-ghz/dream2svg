package es.sixey.dream2svg.dream2text.align;

import es.sixey.dream2svg.dream.AlignStrategy;

public class AlignerFactory {

    public static Aligner alignerFor(AlignStrategy strategy) {
        return new CenterAligner(); // hehe
    }
}
