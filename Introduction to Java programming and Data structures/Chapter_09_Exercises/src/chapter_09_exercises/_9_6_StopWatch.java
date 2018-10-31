package chapter_09_exercises;

/**
 * @author Samuel Bangslund
 */
public class _9_6_StopWatch {
    private long startTime;
    private long endTime;
    
    public _9_6_StopWatch() {
        this.startTime = System.currentTimeMillis();
    }
    
    public void startTime() {
        this.startTime = System.currentTimeMillis();
        this.endTime = 0;
    }
    
    public void stopTime() {
        this.endTime = System.currentTimeMillis();
    }
    
    public long getElapsedTime() {
        return endTime - startTime;
    }
    
    public long getStartTime() {
        return this.startTime;
    }
    
    public long getEndTime() {
        return this.endTime;
    }
}
