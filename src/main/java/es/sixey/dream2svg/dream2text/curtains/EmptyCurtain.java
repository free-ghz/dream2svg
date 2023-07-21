package es.sixey.dream2svg.dream2text.curtains;

import es.sixey.dream2svg.util.LineUtil;

public class EmptyCurtain extends Curtain {

    public EmptyCurtain(int width) {
        super(width);
    }

    @Override
    public Seam getNext() {
        return new Seam(
                LineUtil.spaces(width),
                LineUtil.spaces(width)
        );
    }
}
