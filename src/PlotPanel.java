import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class PlotPanel extends JPanel implements Observer {
    PlotType plotType;
    Drawable plot;
    List<Integer> numberList;

    public PlotPanel(PlotType plotType) {
        this.plotType = plotType;
        Source source = new Source();
        numberList = source.getNumberList();

        switch (plotType) {
            case SIMPLE -> {
                plot = new SimplePlot();
            }
            case MARKED_SIMPLE -> {
                plot = new MarkedPlot(new SimplePlot());
            }
            case BAR_MARKED_SIMPLE -> {
                plot = new BarPlot(new MarkedPlot(new SimplePlot()));
            }
        }

        setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        plot.draw(g, numberList);
    }

    @Override
    public void update(Observable o, Object arg) {
        Source source = (Source) o;
        numberList = source.getNumberList();
        double average = Evaluator.getInstance().getAverageOf(source.getNumberList());
        repaint();
    }
}
