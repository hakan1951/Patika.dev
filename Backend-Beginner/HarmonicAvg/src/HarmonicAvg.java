public class HarmonicAvg {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        printHarmonicAverage(numbers);
    }
    public static void printHarmonicAverage(int[] numbers){
        double sum = 0;
        for (int number : numbers) {
            sum += (1 / (double) number);
        }
        double result = numbers.length / sum;
        System.out.format("Harmonic average: %.2f", result);
    }
}