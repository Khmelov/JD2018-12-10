package by.it.yarmolenka.MathCalc.ReportCalc;

import by.it.yarmolenka.MathCalc.Strings.Report;
import by.it.yarmolenka.MathCalc.Translator;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

public class FullReportBuilder extends ReportBuilder {
    @Override
    public void buildHeader(Translator translator) {
        report.setHeader("\n\n" + translator.get(Report.HEADERFULL) + "\n\n");
    }

    @Override
    public void buildTime(Date start, Date finish, Translator translator) {
        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL);
        report.setTime(String.format("%s: %s\n%s: %s\n",translator.get(Report.START),
                df.format(start),translator.get(Report.FINISH), df.format(finish)));
    }

    @Override
    public void buildOperations(List<String> operationsList) {
        StringBuilder sb = new StringBuilder();
        for (String s : operationsList)
            sb.append(s).append('\n');
        report.setOperations(sb);
    }
}
