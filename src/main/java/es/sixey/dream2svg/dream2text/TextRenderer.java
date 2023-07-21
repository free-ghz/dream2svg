package es.sixey.dream2svg.dream2text;

import es.sixey.dream2svg.dream.Dream;
import es.sixey.dream2svg.dream2text.align.AlignerFactory;
import es.sixey.dream2svg.dream2text.curtains.CurtainFactory;

import java.util.ArrayList;
import java.util.StringJoiner;

public class TextRenderer {
    private final int curtainWidth;
    private final int paragraphWidth;

    public TextRenderer(int paragraphWidth, int curtainWidth) {
        this.paragraphWidth = paragraphWidth;
        this.curtainWidth = curtainWidth;
    }

    public String render(Dream dream, int maxHeight) {
        var document = new ArrayList<String>();

        var aligner = AlignerFactory.alignerFor(dream.getSegments().get(0).getAlignStrategy(), paragraphWidth);
        var curtain = CurtainFactory.curtainFor(dream.getSegments().get(0).getCurtainType(), curtainWidth);
        bleble: for (var segment : dream.getSegments()) {
            if (segment.getAlignStrategy() != null) aligner = AlignerFactory.alignerFor(segment.getAlignStrategy(), paragraphWidth);
            if (segment.getCurtainType() != null) curtain = CurtainFactory.curtainFor(segment.getCurtainType(), curtainWidth);
            for (var line : segment.getLines()) {
                var lineText = aligner.align(line);
                var curtains = curtain.getNext();
                var leftCurtain = curtains.left();
                var rightCurtain = curtains.right();
                var total = leftCurtain + " " + lineText + " " + rightCurtain;
                document.add(total);
                if (document.size() == maxHeight) break bleble;
            }
        }

        var joiner = new StringJoiner("\n");
        document.forEach(joiner::add);
        return joiner.toString();
    }
}
