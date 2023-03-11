package es.sixey.dream2svg.dream2text;

import es.sixey.dream2svg.dream.Dream;
import es.sixey.dream2svg.dream2text.align.AlignerFactory;
import es.sixey.dream2svg.dream2text.curtains.CurtainFactory;

import java.util.ArrayList;
import java.util.StringJoiner;

public class TextRenderer {

    public String render(Dream dream) {
        var document = new ArrayList<String>();

        var aligner = AlignerFactory.alignerFor(dream.getSegments().get(0).getAlignStrategy());
        var curtain = CurtainFactory.curtainFor(dream.getSegments().get(0).getCurtainType());
        for (var segment : dream.getSegments()) {
            if (segment.getAlignStrategy() != null) aligner = AlignerFactory.alignerFor(segment.getAlignStrategy());
            if (segment.getCurtainType() != null) curtain = CurtainFactory.curtainFor(segment.getCurtainType());
            for (var line : segment.getLines()) {
                var lineText = aligner.align(line);
                var curtains = curtain.getNext();
                var total = curtains.left() + " " + lineText + " " + curtains.right();
                document.add(total);
            }
        }

        var joiner = new StringJoiner("\n");
        document.forEach(joiner::add);
        return joiner.toString();
    }
}
