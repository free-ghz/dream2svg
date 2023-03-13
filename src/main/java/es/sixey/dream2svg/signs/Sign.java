package es.sixey.dream2svg.signs;

import java.util.List;

public interface Sign {
    List<Path> getPaths(double width, double height);
}
