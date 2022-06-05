package bd.edu.seu;
import java.time.LocalDate;

public class Entry implements Comparable<Entry> {
    private LocalDate Date;
    private String time;
    private int systolic;
    private int diastolic;
    private float weight;

    public Entry(LocalDate date, String time, int systolic, int diastolic, float weight) {
        Date = date;
        this.time = time;
        this.systolic = systolic;
        this.diastolic = diastolic;
        this.weight = weight;
    }

    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate date) {
        Date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getSystolic() {
        return systolic;
    }

    public void setSystolic(int systolic) {
        this.systolic = systolic;
    }

    public int getDiastolic() {
        return diastolic;
    }

    public void setDiastolic(int diastolic) {
        this.diastolic = diastolic;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "Date=" + Date +
                ", time='" + time + '\'' +
                ", systolic=" + systolic +
                ", diastolic=" + diastolic +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(Entry entry) {
        return this.getDate().compareTo(entry.getDate());
    }
}
