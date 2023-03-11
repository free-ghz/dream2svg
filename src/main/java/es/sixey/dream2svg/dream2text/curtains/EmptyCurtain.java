package es.sixey.dream2svg.dream2text.curtains;

public class EmptyCurtain implements Curtain {

    @Override
    public Seam getNext() {
        return new Seam("          ", "          ");
    }
}
