package es.sixey.dream2svg.signs;

import java.util.ArrayList;
import java.util.List;

public class Path {
    private final List<Point> points = new ArrayList<>();

    public Path addPoint(double x, double y) {
        points.add(new Point(x, y));
        return this;
    }
    public Path addPoint(Point point) {
        points.add(point);
        return this;
    }

    public List<Point> getPoints() {
        return points;
    }

    public Path size(double width, double height) {
        double xMax = 0, yMax = 0;
        for (var point : points) {
            xMax = Math.max(xMax, point.x());
            yMax = Math.max(yMax, point.y());
        }

        Path copy = new Path();
        for (var point : points) {
            copy.addPoint(new Point(point.x()/xMax*width, point.y()/yMax*width));

        }
        return copy;
    }
}
