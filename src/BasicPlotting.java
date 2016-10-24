import javax.swing.JFrame;

import org.math.plot.Plot2DPanel;

public class BasicPlotting {
	public static void main(String[] args) {
		CSVData data = new CSVData("data/walkingSampleData-out.txt", 1);

		Plot2DPanel plot = new Plot2DPanel();

		double[][] sensorData = data.getCols(1, 4);
		// add a line plot to the PlotPanel
		plot.addLinePlot("3d Acceleration", StepCounter.calculateMagnitudesFor(sensorData));

		// put the PlotPanel in a JFrame, as a JPanel
		JFrame frame = new JFrame("Results");
		frame.setSize(800, 600);
		frame.setContentPane(plot);
		frame.setVisible(true);
	}
}
