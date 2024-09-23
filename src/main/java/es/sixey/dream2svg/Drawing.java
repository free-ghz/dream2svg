package es.sixey.dream2svg;

import es.sixey.dream2svg.signs.Path;
import es.sixey.dream2svg.signs.Text;
import es.sixey.dream2svg.util.Wave;
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

    private Wave offsetWave = new Wave();
    private Wave sizeWave = new Wave();

    public Drawing(int widthMm, int heightMm, int widthLetters, int heightLetters, double offsetLetters) {
        surface = new SVGGraphics2D(widthMm, heightMm, SVGUnits.MM);
        this.surfaceWidth = surface.getWidth();
        this.surfaceHeight = surface.getHeight();
        this.widthLetters = widthLetters;
        this.heightLetters = heightLetters;
        this.offsetLetters = offsetLetters;
        surface.setPaint(Color.BLACK);
        surface.setStroke(new BasicStroke(0.6f));
    }

    public void setDefaultPaint() {
        surface.setPaint(Color.BLACK);
    }
    public void setAccentPaint() {
        surface.setPaint(Color.LIGHT_GRAY);
    }
    public void rerollWaves() {
        offsetWave = new Wave();
        sizeWave = new Wave();
    }

    /* we are being naughty and doing an injection, kinda.
     * i should probably add the inkscape namespace too but fuck it */
    private String getGroupIdWithInkscapeLayer(String groupName) {
        String id = groupName + "' ";
        id += "inkscape:groupmode='layer' inkscape:label='" + groupName;
        return id;
    }

    public void drawText(Text text, int externalXOffset, int externalYOffset, boolean flip) {
        drawText(text, externalXOffset, externalYOffset, flip, 1);
    }
    public void drawText(Text text, int externalXOffset, int externalYOffset, boolean flip, double sizeFactor) {
        // startGroup(text.toString());
        double signWidth = surfaceWidth/widthLetters;
        double signHeight = surfaceHeight/heightLetters;
        for (int x = 0; x < text.getWidth(); x++) {
            for (int y = 0; y < text.getHeight(); y++) {
                double letterSizeFactor = sizeFactor;
                letterSizeFactor = sizeFactor * sizeWave.getWave(x, y, 0.7, 0.95);
                double sizeFactorOffset = (1 - letterSizeFactor) / 2;
                double borderOffset = signWidth * (offsetLetters + sizeFactorOffset);
                borderOffset += signWidth * offsetWave.getWave(x, y, -0.15, 0.15);
                var letter = text.getGrid()[x][y];
                if (letter == null) continue;
                var paths = letter.getPaths(signWidth * letterSizeFactor, signHeight * letterSizeFactor);
                for (var path : paths) {
                    double finalXOffset = externalXOffset + borderOffset + (x * signWidth);
                    double finalYOffset = externalYOffset + borderOffset + (y * signHeight);
                    if (flip) {
                        path = path.size(1, 1, -1, -1);
                        finalXOffset += signWidth;
                        finalYOffset += signHeight;
                    }
                    drawPath(path, finalXOffset, finalYOffset);
                }
            }
        }
        // endGroup(text.toString());
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

    public void startGroup(String name) {
        surface.setRenderingHint(SVGHints.KEY_BEGIN_GROUP, getGroupIdWithInkscapeLayer(name));
    }
    public void endGroup(String name) {
        surface.setRenderingHint(SVGHints.KEY_END_GROUP, name);
    }
}
