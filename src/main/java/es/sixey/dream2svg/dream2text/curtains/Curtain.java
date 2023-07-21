package es.sixey.dream2svg.dream2text.curtains;

public abstract class Curtain {
    protected int width;

    public Curtain(int width) {
        this.width = width;
    }

    public abstract Seam getNext();

    public record Seam(String left, String right) {}
}
