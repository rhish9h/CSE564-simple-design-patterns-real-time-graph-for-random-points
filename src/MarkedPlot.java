import java.awt.*;
import java.util.List;

/**
 * Decorated Plot that decorates Drawable
 * Plots marked plot in the Plot panel - squares at points
 * <p>
 * Pattern Used - Decorator
 */
public class MarkedPlot extends DecoratedPlot {
    MarkedPlot(Drawable drawable) {
        super(drawable);
    }

    @Override
    public void draw(Graphics g, List<Integer> numberList) {
        drawable.draw(g, numberList);
        g.setColor(Color.BLUE);
        for (int j = 1; j < numberList.size(); j++) {
            g.fillRect(40 * j - 3,
                    (170 - (3 * numberList.get(j) / 4)) - 3,
                    6, 6);
        }
    }
}
