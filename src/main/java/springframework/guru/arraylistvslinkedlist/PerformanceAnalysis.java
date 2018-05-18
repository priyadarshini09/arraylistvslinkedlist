package springframework.guru.arraylistvslinkedlist;

public abstract class PerformanceAnalysis {

    private static final int WARMUP_RUNS = 10000;
    private static final int AVERAGE_RUNS = 100000;

    abstract String getName();
    abstract void setup();
    abstract void runMethod();

    public void doPerformanceTest() {
        int warmupRuns = WARMUP_RUNS;
        int averageRuns = AVERAGE_RUNS;
        for(int i=0; i<warmupRuns; i++){
            setup();
            runMethod();
        }

            // Timing loop
        long totalTime = 0;
        for(int i=0; i<averageRuns; i++) {
            setup();
            long startTime = System.nanoTime();
            runMethod();
            long endTime = System.nanoTime();
            totalTime += (endTime-startTime);
            }
        System.out.println(getName()+" took "+totalTime/averageRuns+" ns/run");
    }
}
