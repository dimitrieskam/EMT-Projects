package mk.finki.emt.docktormanagement.domain.valueobjects;

import jakarta.persistence.Embeddable;
import mk.finki.emt.sharedkernel.domain.base.ValueObject;

import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalTime;
import java.util.Objects;

@Embeddable
public class WorkTime implements ValueObject {
    private final LocalTime startTime;
    private final LocalTime endTime;

    protected WorkTime(){
        this.startTime=null;
        this.endTime=null;
    }
    public WorkTime(LocalTime startTime, LocalTime endTime){
        this.startTime=startTime;
        this.endTime=endTime;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkTime workTime = (WorkTime) o;
        return Objects.equals(startTime, workTime.startTime) && Objects.equals(endTime, workTime.endTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startTime, endTime);
    }

    @Override
    public String toString() {
        return "WorkTime{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }


    @Override
    public void serialize(Object object, OutputStream outputStream) throws IOException {

    }
}
