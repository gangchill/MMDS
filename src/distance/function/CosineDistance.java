package distance.function;

public class CosineDistance {

	 
    public static double calculateCosineDistance(final double[] a, final double[] b){
    	return 1 - multiplication(a, b) / (vector(a) * vector(b));
    }
    
    
    public static double calculateCosineDistance(final double[][] a, final double[][] b) {
    	double sum = 0;
    	for (int i = 0; i < a.length; ++i)
    		sum += calculateCosineDistance(a[i], b[i]);
    	return sum;
    }
    

    
    
    private static double multiplication(final double[] a, final double[] b) {
    	if (a.length != b.length)
    		throw new AssertionError();
    	double d = 0;
    	for (int i = 0; i < a.length; ++i)
    		d += a[i] * b[i];
    	return d;
    }
    
    
    private static double vector(final double[] vector) {
    	double d = 0;
    	for (int i = 0; i < vector.length; ++i)
    		d += vector[i] * vector[i];
    	return Math.sqrt(d);
    }
    
}
