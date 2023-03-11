package es.sixey.dream2svg.dream2text.curtains;

public class ReverseGlowCurtain implements Curtain {
    private Curtain glow = new GlowCurtain();

    @Override
    public Seam getNext() {
        var glowSeam = glow.getNext();
        return new Seam(glowSeam.right(), glowSeam.left());
    }
}
