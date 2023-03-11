package es.sixey.dream2svg.dream;

import java.util.ArrayList;
import java.util.List;

class DreamSegment {
    private AlignStrategy alignStrategy;
    private CurtainType curtainType;
    private List<List<String>> lines;
    public DreamSegment() {
        lines = new ArrayList<>();
    }
    public DreamSegment(AlignStrategy alignStrategy, CurtainType curtainType) {
        this();
        this.alignStrategy = alignStrategy;
        this.curtainType = curtainType;
    }

    public AlignStrategy getAlignStrategy() {
        return alignStrategy;
    }

    public void setAlignStrategy(AlignStrategy alignStrategy) {
        this.alignStrategy = alignStrategy;
    }

    public CurtainType getCurtainType() {
        return curtainType;
    }

    public void setCurtainType(CurtainType curtainType) {
        this.curtainType = curtainType;
    }

    public List<List<String>> getLines() {
        return lines;
    }

    public void setLines(List<List<String>> lines) {
        this.lines = lines;
    }

    @Override
    public String toString() {
        var header = "* " + alignStrategy + " " + curtainType + " len " + lines.size() + "\n";
        for (var line : lines) {
            header += "  " + line.toString() + "\n";
        }
        return header;
    }
}
