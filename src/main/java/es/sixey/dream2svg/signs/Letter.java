package es.sixey.dream2svg.signs;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Letter implements Sign {
    private final List<Path> paths;
    private final double width;
    private final double height;

    public Letter(double width, double height, List<Path> paths) {
        this.width = width;
        this.height = height;
        this.paths = paths;
    }
    public Letter(List<Path> paths) {
        this(1, 1, paths);
    }

    @Override
    public List<Path> getPaths(double newWidth, double newHeight) {
        return paths.stream().map(path -> path.size(newWidth, newHeight, width, height)).collect(Collectors.toList());
    }

}
