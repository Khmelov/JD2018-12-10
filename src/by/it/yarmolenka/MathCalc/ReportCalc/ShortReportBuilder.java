package by.it.yarmolenka.MathCalc.ReportCalc;

import by.it.yarmolenka.MathCalc.Strings.Report;
import by.it.yarmolenka.MathCalc.Translator;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

public class ShortReportBuilder extends ReportBuilder {
    @Override
    public void buildHeader(Translator translator) {
        report.setHeader("\n\n" + translator.get(Report.HEADERSHORT) + "\n\n");
    }

    @Override
    public void buildTime(Date start, Date finish, Translator translator) {
        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
        report.setTime(String.format("%s: %s\n%s: %s\n", translator.get(Report.START),
                df.format(start), translator.get(Report.FINISH), df.format(finish)));
    }

    @Override
    public void buildOperations(List<String> operationsList) {
        StringBuilder sb = new StringBuilder();
        for (String s : operationsList) {
            if (s.contains("ERROR:")) {
                sb.append("ERROR").append('\n');
                continue;
            }
            if (s.contains("ОШИБКА:")) {
                sb.append("ОШИБКА").append('\n');
                continue;
            }
            if (s.contains("ПАМЫЛКА:")) {
                sb.append("ПАМЫЛКА").append('\n');
                continue;
            }
            sb.append(s).append('\n');
        }
        report.setOperations(sb);
    }
}
