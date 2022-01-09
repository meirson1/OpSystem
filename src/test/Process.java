package test;

public class Process {
        int arriValTime;
        int bursTime;


        public Process(int arriValTime, int bursTime) {
                this.arriValTime = arriValTime;
                this.bursTime = bursTime;
        }

        public int getArriValTime(){
                return arriValTime;
        }
        public int getBursTime(){
                return bursTime;
        }

        public void setArriValTime(int arriValTime1){
                this.arriValTime=arriValTime1;
        }
        public void setBursTime(int bursTime1){
                this.bursTime=bursTime1;
        }
           public void clone(Process p){
                this.arriValTime=p.arriValTime;
                this.bursTime=p.bursTime;
}

