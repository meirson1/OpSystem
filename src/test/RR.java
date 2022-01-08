package test;

public class RR implements scheduling {

    float output;

    public RR(Process[] process) {
        setOutput(RR(process,2));
    }

    public float RR(Process[] process, int quantum) {
        int time = 0;
        int[] at = new int[process.length];
        int[] bt = new int[process.length];
        int[] wt = new int[process.length];

        for(int i = 0; i < process.length; ++i) {
            at[i] = process[i].getArriValTime();
            bt[i] = process[i].getBursTime();
        }

        boolean done = false;

        while(!done) {
            done = true;

            for(int i = 0; i < process.length; ++i) {
                if (bt[i] > quantum) {
                    time += quantum;
                    bt[i] -= quantum;
                } else {
                    time += bt[i];
                    wt[i] = time - bt[i];
                }
            }
        }
        return 0;
    }

    public float calculate(Process[] pro) {
        return RR(pro,2);
    }

    public float getOutput() {
        return output;
    }

    public void setOutput(float output) {
        this.output = output;
    }
}