package es.sixey.dream2svg.signs;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Letter implements Sign {
    private List<Path> paths;

    public Letter() {
        paths = new ArrayList<>();
    }

    public Letter(List<Path> paths) {
        this.paths = paths;
    }

    @Override
    public List<Path> getPaths(double width, double height) {
        return paths.stream().map(path -> path.size(width, height)).collect(Collectors.toList());
    }
}
