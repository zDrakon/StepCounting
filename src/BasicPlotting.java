import java.util.Arrays;
import java.util.Random;
import javax.swing.JFrame;
import org.math.plot.Plot2DPanel;

public class BasicPlotting {
	public static void main(String[] args) {
		int size = 100;
		
		double[] sample1 = new double[size];
		double[] sample2 = new double[size];
		
		for (int i = 0; i < size; i++) {
			sample1[i] = Math.random()*20 + 10;
			sample2[i] = i + -5 + Math.random()*5;
		}
		
		Plot2DPanel plot = new Plot2DPanel();
		
		// add a line plot to the PlotPanel
		plot.addLinePlot("Random signal", sample1);
		plot.addLinePlot("y = x + noise", sample2);

		// put the PlotPanel in a JFrame, as a JPanel
		JFrame frame = new JFrame("Results");
		frame.setSize(800, 600);
		frame.setContentPane(plot);
		frame.setVisible(true);
	}
}
