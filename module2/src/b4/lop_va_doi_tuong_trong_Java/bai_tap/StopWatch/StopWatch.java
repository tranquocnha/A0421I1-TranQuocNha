package b4.lop_va_doi_tuong_trong_Java.bai_tap.StopWatch;

public class StopWatch {
    private long startTime=0;
    private long endTime=0;
    private boolean running=false;
    public void start(){
        this.startTime=System.currentTimeMillis();
        this.running=true;
    }
    public void end(){
        this.endTime=System.currentTimeMillis();
        this.running=false;
    }

    public void setStartTime() {
        this.startTime = System.currentTimeMillis();
    }
    public void setEndTime(){
        this.endTime=System.currentTimeMillis();
    }
    public long getElapsedTime(){
        long elapsed;
        if (running){
            elapsed=(System.currentTimeMillis()-startTime);
        }else {
            elapsed=endTime-startTime;
        }
        return elapsed;
    }
}
