package test;

public class Process {
        int ArrivalTime;
        int bursTime;
        int finishTime;
        int waitingTime;

        public Process(int ArrivalTime, int bursTime) {
                this.ArrivalTime = ArrivalTime;
                this.bursTime = bursTime;
        }

        public int getArrivalTime() {
                return this.ArrivalTime;
        }

        public int getBursTime() {
                return this.bursTime;
        }

        public void setArrivalTime(int ArrivalTime1) {
                this.ArrivalTime = ArrivalTime1;
        }

        public void setBursTime(int bursTime1) {
                this.bursTime = bursTime1;
        }
           public void clone(Process p) {
                   this.ArrivalTime = p.ArrivalTime;
                   this.bursTime = p.bursTime;
           }
}

