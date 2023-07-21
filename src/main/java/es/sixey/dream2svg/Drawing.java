package es.sixey.dream2svg;

import es.sixey.dream2svg.signs.Path;
import es.sixey.dream2svg.signs.Text;
import org.jfree.svg.*;

import java.awt.*;
import java.awt.geom.Path2D;

public class Drawing {

    private final SVGGraphics2D surface;
    private final double surfaceWidth;
    private final double surfaceHeight;
    private final double widthLetters;
    private final double heightLetters;
    private final double offsetLetters;

    public Drawing(int widthMm, int heightMm, int widthLetters, int heightLetters, double offsetLetters) {
        surface = new SVGGraphics2D(widthMm, heightMm, SVGUnits.MM);
        this.surfaceWidth = surface.getWidth();
        this.surfaceHeight = surface.getHeight();
        this.widthLetters = widthLetters;
        this.heightLetters = heightLetters;
        this.offsetLetters = offsetLetters;
        System.out.println(surfaceWidth + " " + surfaceHeight);
        surface.setPaint(Color.BLACK);
        surface.setStroke(new BasicStroke(0.6f));
    }

    public void drawText(Text text) {
        surface.setRenderingHint(SVGHints.KEY_BEGIN_GROUP, text.toString());
        double signWidth = surfaceWidth/widthLetters;
        double signHeight = surfaceHeight/heightLetters;
        double borderOffset = signWidth * offsetLetters;
        for (int x = 0; x < text.getWidth(); x++) {
            for (int y = 0; y < text.getHeight(); y++) {
                var letter = text.getGrid()[x][y];
                if (letter == null) continue;
                var paths = letter.getPaths(signWidth, signHeight);
                for (var path : paths) {
                    drawPath(path, borderOffset + (x * signWidth), borderOffset + (y * signHeight));
                }
            }
        }
        surface.setRenderingHint(SVGHints.KEY_END_GROUP, text.toString());
    }

    private void drawPath(Path path, double xOffset, double yOffset) {
        var points = path.getPoints();
        if (points.isEmpty()) return;
        if (points.size() == 1) throw new RuntimeException("I didnt implement points yet");

        Path2D path2D = new Path2D.Double();
        path2D.moveTo(xOffset + points.get(0).x(), yOffset + points.get(0).y());

        for (int i = 1; i < points.size(); i++) {
            var point = points.get(i);
            path2D.lineTo(point.x() + xOffset, point.y() + yOffset);
        }
        surface.draw(path2D);
    }

    public String getSvg() {
        var viewbox = new ViewBox(0, 0, surfaceWidth, surfaceHeight);
        return surface.getSVGElement(
                null,
                true, // include dimensions,
                viewbox,
                PreserveAspectRatio.XMAX_YMAX,
                MeetOrSlice.MEET
        );
    }
}
