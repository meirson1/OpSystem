package test;
import java.util.*;

public class LCFS implements scheduling{

    Stack<Process> stack,stack2;
    int runtime;

    @Override
    public float calculate(Process[] pro) {
        for (int i=pro.length-1;i>0;i--)
        {
            runtime+=pro[i].bursTime;
            stack.push(pro[i]);
        }
        int counter=1;
        Process working =new Process(0,0);
        working.clone(stack.pop());
        int endwork=counter+working.bursTime;
        ArrayList<Integer> TAT=new ArrayList<Integer>();
        int prosTAT=0;
        while (!stack.isEmpty())
        {
            if (counter==stack.peek().arriValTime){
                stack2.push(stack.pop());
            }
            if (endwork<counter)   {
                prosTAT=working.bursTime+(counter-working.arriValTime);//bursttime+waitingtime
                TAT.add(prosTAT);
                working.clone(stack2.pop());
                endwork=counter+working.bursTime;
            }
            counter++;
        }
        float avgTAT=0;
        for (Integer ta:TAT){
            avgTAT+=(float)ta;
        }
        avgTAT=avgTAT/(float)TAT.size();
        return avgTAT;
    }
}
