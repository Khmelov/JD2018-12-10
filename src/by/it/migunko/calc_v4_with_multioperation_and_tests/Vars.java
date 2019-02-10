package by.it.migunko.calc_v4_with_multioperation_and_tests;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
public class Vars {

    private static HashMap<String, Var> vars = new HashMap<>();

    static void setVar(String key, Var value){
        vars.put(key, value);
    }

    static Var getVar(String key){
        return vars.get(key);
    }

    public static String printVar() {
        StringBuilder sb = new StringBuilder();
        sb.append("Содержимое:\n");
        for (Map.Entry<String, Var> entry : vars.entrySet()){
            sb.append(entry.getKey());
            sb.append("=");
            sb.append(entry.getValue());
            sb.append("\n");
        }
        return sb.toString();
    }

    public static String sortVar() {
        TreeMap<String, Var> map = new TreeMap<>(Vars.vars);
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Var> entry : map.entrySet()){
            sb.append(entry.getKey());
            sb.append("=");
            sb.append(entry.getValue());
            sb.append("\n");
        }
        return sb.toString();
    }
}
