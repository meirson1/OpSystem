package test;

public class Swap {
    public static void swap(ProcessWraper p1,ProcessWraper p2){
        Process temp=new Process(p1.p.arriValTime,p1.p.bursTime);
        p1.p.clone(p2.p);
        p2.p.clone(temp);
    }
}
