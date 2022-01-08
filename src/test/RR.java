package test;

public class RR implements scheduling {

    float output;

    public RR(Process[] process) {
        setOutput(RR(process,2));
    }

    public float RR(Process[] process, int quantum) {
        int time = 1;//running time
        int[] at = new int[process.length];//arrival time array
        int[] bt = new int[process.length];//burst time array
        int[] rem_bt = new int[process.length];//burst time for changes array
        int[] wt = new int[process.length];//waiting time array

        for (int i = 0; i < process.length; ++i) {//create an array of arrival time, burst time and one more burst time for changes
            at[i] = process[i].getArrivalTime();
            bt[i] = process[i].getBursTime();
            rem_bt[i] = process[i].getBursTime();
        }

        while (!IsDone(rem_bt)) {

            for (int i = 0; i < process.length; ++i) {
                if (time>=at[i]) {
                    if (rem_bt[i] >= quantum) {
                        rem_bt[i] -= quantum;
                        for (int j = 0; j < process.length; j++) {
                            if ((process[i] != process[j]) && (rem_bt[j] != 0)&&(time>at[j]))
                                wt[j] += quantum;
                        }
                        time += quantum;
                    } else {
                        time += rem_bt[i];
                        wt[i] -= rem_bt[i];
                        rem_bt[i] = 0;
                    }
                }
            }
        }
        float TAT = 0;
        for (int i = 0; i < process.length; i++) {
            TAT += ((float) bt[i] + wt[i]);
        }
        return (TAT / process.length);
    }

    private boolean IsDone(int[] rem_bt) {
        for (int i = 0; i < rem_bt.length; i++) {
            if (rem_bt[i]!=0)
                return false;
        }
        return true;
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