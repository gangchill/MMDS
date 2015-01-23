package distance.function;

public class EuclideanDistance {
	
	public static double calculateEuclidianDistance(double[] a, double[] b){
        double sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += (a[i]-b[i]) * (a[i]-b[i]);
        }
        return Math.sqrt(sum);
    }
    
    
    public static double calculateEuclidianDistance(double[][] a, double[][] b) {
    	double sum = 0;
    	for (int i = 0; i < a.length; ++i)
    		sum += calculateEuclidianDistance(a[i], b[i]);
    	return sum;
    }
}
