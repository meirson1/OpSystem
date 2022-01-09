package test;

public class BSorter {

    public void sort(Process[] pro)
    {
        ProcessWraper pw1,pw2;
        boolean swapped;
        for(int i=0;i<pro.length;i++)
        {
            swapped=false;
            for (int j=0;j<pro.length-i-1;j++)
            {
                if(pro[j].arriValTime>pro[j+1].arriValTime){
                    Swap.swap(pw1=new ProcessWraper(pro[j]),pw2=new ProcessWraper(pro[j+1]));
                    pro[j]=pw1.p;
                    pro[j+1]=pw2.p;
                    swapped=true;
                }
            }
            if (swapped==false)
                break;
        }

    }

}
