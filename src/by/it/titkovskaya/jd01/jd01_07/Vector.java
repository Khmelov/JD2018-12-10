package by.it.titkovskaya.jd01.jd01_07;

public class Vector extends Var{

    private double[] value;

    Vector(double[] value){
        this.value = new double[value.length];
        System.arraycopy(value,0,this.value,0,value.length);
    }

    Vector(Vector otherVector) {
        this.value=otherVector.value;
    }

    Vector(String strVector){
        String[] otherVector = strVector.replaceAll("[^.,0-9]","").split(",");
        this.value=new double[otherVector.length];
        for (int i = 0; i < otherVector.length; i++) {
            value[i]=Double.parseDouble(otherVector[i]);
        }
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("{");
        String delimiter = "";
        for (double v: value){
            out.append(delimiter).append(v);
            delimiter=", ";
        }
        out.append('}');
        return out.toString();
    }
}
