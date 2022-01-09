package test;

import java.util.ArrayList;

public class FCFS implements scheduling{
    int totalTime;
    int sumTurnaround;
    ArrayList <Process> prcsLst;
    float avgTurnaround;
    public FCFS(Process[] process){
        avgTurnaround  = this.calculate(process);
    }
    @Override
    public float calculate(Process[] process) {

        //int[] waitingTime = new int[process.length];
        prcsLst = new ArrayList<>(process.length);
        for(int i = 0 ; i < process.length ; i++){
            prcsLst.add(new Process( process[i].ArrivalTime, process[i].bursTime));
        }
        this.bubbleSort();//--> sort by ArrivalTime

        sumTurnaround = 0;
        for(int j = 0 ; j < prcsLst.size() ; j++ ) {
            if (j == 0 || (prcsLst.get(j).ArrivalTime > prcsLst.get(j - 1).finishTime)) {
                prcsLst.get(j).waitingTime = 0;
                prcsLst.get(j).finishTime = prcsLst.get(j).ArrivalTime + prcsLst.get(j).bursTime;
            }
            else {
                prcsLst.get(j).waitingTime = prcsLst.get(j - 1).finishTime - prcsLst.get(j).ArrivalTime;
                prcsLst.get(j).finishTime = prcsLst.get(j - 1).finishTime + prcsLst.get(j).bursTime;
            }
            sumTurnaround += prcsLst.get(j).waitingTime + prcsLst.get(j).bursTime;
        }
        return sumTurnaround;
    }

    public void bubbleSort() {
        int tempArrivalTime;
        Process tempProcess =new Process(0 , 0 );
        for (int i = 0; i < prcsLst.size() - 1  ; i++) {
            for (int j = 0; j < prcsLst.size() - i - 1; j++) {
                if(prcsLst.get(j).ArrivalTime > prcsLst.get(j + 1).ArrivalTime){

                    tempProcess.ArrivalTime =  prcsLst.get(j).ArrivalTime;
                    tempProcess.bursTime =  prcsLst.get(j).bursTime;

                    prcsLst.get(j).ArrivalTime  =  prcsLst.get(j + 1).ArrivalTime;
                    prcsLst.get(j).bursTime  =  prcsLst.get(j + 1).bursTime;

                    prcsLst.get(j + 1 ).ArrivalTime = tempProcess.ArrivalTime;
                    prcsLst.get(j + 1).bursTime = tempProcess.bursTime;
                }
            }
        }

    }

}