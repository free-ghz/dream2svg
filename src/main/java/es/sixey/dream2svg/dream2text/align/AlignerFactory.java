package es.sixey.dream2svg.dream2text.align;

import es.sixey.dream2svg.dream.AlignStrategy;

public class AlignerFactory {

    public static Aligner alignerFor(AlignStrategy strategy) {
        return switch (strategy) {
            case CENTER -> new CenterAligner();
            case NONE -> new LeftAligner();
            case BLOCK -> new BlockAligner();
            case AUTO_LEFT -> new AutoAligner(new LeftAligner(), 25, new BlockAligner());
            default -> new AutoAligner(new CenterAligner(), 25, new BlockAligner());
        };
    }
}
