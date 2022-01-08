package test;

public class Process {
        int arriValTime;
        int bursTime;

        public Process(int arriValTime, int bursTime) {
                this.arriValTime = arriValTime;
                this.bursTime = bursTime;
        }

        public int getArriValTime() {
                return this.arriValTime;
        }

        public int getBursTime() {
                return this.bursTime;
        }

        public void setArriValTime(int arriValTime1) {
                this.arriValTime = arriValTime1;
        }

        public void setBursTime(int bursTime1) {
                this.bursTime = bursTime1;
        }
}

