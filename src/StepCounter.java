
public class StepCounter {

	/***
	 * 
	 * @param sensorData
	 *            an array with n rows, and 3 columns. Each row represents a
	 *            different measurement, and each column represents a different
	 *            axis of the sensor.
	 * @return
	 */

	public static double[] calculateMagnitudesFor(double[][] sensorData) {
		double[] magnitudes = new double[sensorData.length];

		for (int i = 0; i < magnitudes.length; i++) {
			magnitudes[i] = calculateMagnitude(sensorData[i][0], sensorData[i][1], sensorData[i][2]);

		}
		return magnitudes;

	}

	/***
	 * takes in three vectors and returns the magnitude
	 * 
	 * @param x
	 * @param y
	 * @param z
	 * @return a double representing the magnitude from the 3 inputs
	 */
	public static double calculateMagnitude(double x, double y, double z) {
		return Math.sqrt(x * x + y * y + z * z);
	}

	/***
	 * 
	 * @param times
	 * @param sensorData
	 * @return
	 */
	public static int countSteps(double[] times, double[][] sensorData) {
		double[] magnitudesOfAccelerations = calculateMagnitudesFor(sensorData);
		int count = 0;

		double threshold = calculateStandardDeviation(magnitudesOfAccelerations,
				calculateMean(magnitudesOfAccelerations));

		for (int i = 1; i < magnitudesOfAccelerations.length - 1; i++) {
			if (isPeak(magnitudesOfAccelerations, i) && magnitudesOfAccelerations[i] < threshold) {
				count++;
			}
		}

		return count;
	}

	private static boolean isPeak(double[] magnitudesOfAccelerations, int i) {
		if (magnitudesOfAccelerations[i - 1] < magnitudesOfAccelerations[i]
				&& magnitudesOfAccelerations[i + 1] < magnitudesOfAccelerations[i]) {
			return true;
		}
		return false;
	}

	/***
	 * 
	 * @param arr
	 * @return
	 */
	public static double calculateMean(double[] arr) {
		double sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		return sum / (double) arr.length;

	}

	/***
	 * 
	 * @param arr
	 * @param mean
	 */
	public static double calculateStandardDeviation(double[] arr, double mean) {
		double sum = 0;
		double stddev = 0;
		for (int i = 0; i < arr.length; i++) {
			stddev = (mean - arr[i]) * (mean - arr[i]);
			sum += stddev;
		}
		stddev = sum / (double) ((arr.length - 1) - 1);
		return Math.sqrt(stddev);

	}
}
