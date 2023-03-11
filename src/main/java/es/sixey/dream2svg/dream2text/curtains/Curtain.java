package es.sixey.dream2svg.dream2text.curtains;

public interface Curtain {
    Seam getNext();

    public record Seam(String left, String right) {}
}
