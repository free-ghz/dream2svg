package es.sixey.dream2svg.dream2text.curtains;

public class UndefinedCurtain extends Curtain {
    public UndefinedCurtain(int width) {
        super(width);
    }

    @Override
    public Seam getNext() {
        return new Seam("~undefined".substring(0, width), "undefined~".substring(10-width));
    }
}
