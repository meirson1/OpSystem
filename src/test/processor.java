package test;
import java.io.*;
import java.util.Scanner;

public class processor {

    public static void main(String[] args) throws Exception
    {
        String file = "input1.txt";
        Scanner br = new Scanner(new FileReader(file));
        int numOfProcess=br.nextInt();
        br.nextLine();
        Process[] pro=new Process[numOfProcess];
        for(int i=0;i<numOfProcess;i++)
        {
            String line= br.nextLine();
            String[] times=line.split(",");
            pro[i]=new Process(Integer.parseInt(times[0]),Integer.parseInt(times[1]));
        }
        BSorter sorter=new BSorter();
        sorter.sort(pro);
        LCFS last=new LCFS();
        float lcfsAvg=last.calculate(pro);
        System.out.println("Average of LCFS is: " +lcfsAvg);
        System.out.println("Average of Round Robin with quantum of 2 is: "+new RR(pro).output);
    }
}
