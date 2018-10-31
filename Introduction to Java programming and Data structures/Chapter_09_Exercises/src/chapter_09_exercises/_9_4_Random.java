package chapter_09_exercises;

/**
 * @author Samuel Bangslund
 */
public class _9_4_Random {
    
    private final java.util.Random random;
    
    public _9_4_Random(int seed) {
        this.random = new java.util.Random(seed);
    }
    
    public int[] getNumberOfRandoms(int number, int min, int max) {
        int[] randomNumbers = new int[number];
        for (int i = 0; i < number; i++) {
            randomNumbers[i] = random.nextInt(max) + min;
        }
        
        return randomNumbers;
    }
}
