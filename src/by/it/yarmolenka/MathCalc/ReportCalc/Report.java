package by.it.yarmolenka.MathCalc.ReportCalc;

public class Report {
    private String header;
    private String time;
    private StringBuilder operations;

    public void setHeader(String header) {
        this.header = header;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setOperations(StringBuilder operations){
        this.operations = operations;
    }

    @Override
    public String toString() {
        return header + time + operations;
    }
}
