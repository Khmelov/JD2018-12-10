package by.it.titkovskaya.zForProject;

import by.it.titkovskaya.project.java.controller.Action;
import by.it.titkovskaya.project.java.controller.Cmd;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CmdChangeLang implements Cmd {

    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        String language = Util.findLanguage(req);
        HttpSession session = req.getSession();
        int languageID = 1;
        if (language != null) {
            if (language.equalsIgnoreCase("RU")) {
                language="EN";
                languageID=1;
            } else if (language.equalsIgnoreCase("EN")) {
                language="RU";
                languageID=2;
            }
        } else {
            language="EN";
        }
        session.setAttribute("language", language);
        session.setAttribute("languageID", languageID);
        return Action.INDEX;
    }
}
