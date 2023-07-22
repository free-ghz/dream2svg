package es.sixey.dream2svg.dream2text.align;

import es.sixey.dream2svg.dream.AlignStrategy;

public class AlignerFactory {

    public static Aligner alignerFor(AlignStrategy strategy, int paragraphWidth) {
        int threshold = (int)(paragraphWidth * 0.6);
        var aligner = switch (strategy) {
            case CENTER -> new CenterAligner();
            case NONE -> new LeftAligner();
            case BLOCK -> new BlockAligner();
            case AUTO_LEFT -> new AutoAligner(new LeftAligner(), threshold, new BlockAligner());
            default -> new AutoAligner(new CenterAligner(), threshold, new BlockAligner());
        };
        aligner.setWidth(paragraphWidth);
        return aligner;
    }
}
