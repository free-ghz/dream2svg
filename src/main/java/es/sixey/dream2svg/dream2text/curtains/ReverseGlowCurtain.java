package es.sixey.dream2svg.dream2text.curtains;

public class ReverseGlowCurtain extends Curtain {
    private Curtain glow = new GlowCurtain(width);

    public ReverseGlowCurtain(int width) {
        super(width);
    }

    @Override
    public Seam getNext() {
        var glowSeam = glow.getNext();
        return new Seam(glowSeam.right(), glowSeam.left());
    }
}
