package test;
import java.io.*;

public class processor {

    public static void main(String[] args) throws Exception
    {
        File file = new File("input1.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        int numOfProcess=Integer.parseInt(br.readLine());
        Process[] pro=new Process[numOfProcess];

        for(int i=0;i<numOfProcess;i++)
        {
            String line= br.readLine();
            String[] times=line.split(",");
            pro[i]=new Process(Integer.parseInt(times[0]),Integer.parseInt(times[1]));
        }
        System.out.println("Average of Round Robin with quantum of 2 is: "+new RR(pro).output);
    }
}
