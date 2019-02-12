package by.it.skosirskiy.calculator;

import java.util.Arrays;

class Vector extends Var {

    private double[] value;

    public double[] getValue() {
        return value;
    }

    Vector(double[] value) {
        this.value = new double[value.length];
        System.arraycopy(value, 0, this.value, 0, value.length);
    }

//     Vector(Vector vector) {
//        this.value = vector.value;
//    }



    Vector(String strVector){
        strVector=strVector.replaceAll("\\{","");
        strVector=strVector.replaceAll("\\}","");
        String[] buf=strVector.split(",");

        this.value= new double[buf.length] ;
        for (int i = 0; i < buf.length; i++) {
            value[i]=Double.parseDouble(buf[i]);
        }
    }

    @Override
    public Var add(Var other) throws CalcException{
        if(other instanceof Scalar){
        double[] res= Arrays.copyOf(value,value.length);
            for (int i = 0; i < res.length; i++) {
                res[i]=res[i]+((Scalar)other).getValue();
            }
            return  new Vector(res);
        }

        else if (other instanceof Vector){
            if (this.value.length == ((Vector) other).value.length){
            double[] res=Arrays.copyOf(value,value.length);
            for (int i = 0; i < res.length; i++) {
                res[i]=res[i]+((Vector)other).value[i];

            }
            return new Vector(res);
            }
        }

        return super.add(other);
    }

    @Override
    public Var sub(Var other)  throws CalcException{
        if(other instanceof Scalar){
            double[] res= Arrays.copyOf(value,value.length);
            for (int i = 0; i < res.length; i++) {
                res[i]=res[i]-((Scalar)other).getValue();
            }
            return  new Vector(res);
        }

        else if (other instanceof Vector) {
            if (this.value.length == ((Vector) other).value.length) {
                double[] res = Arrays.copyOf(value, value.length);
                for (int i = 0; i < res.length; i++) {
                    res[i] = res[i] - ((Vector) other).value[i];

                }
                return new Vector(res);
            }
        }

        return super.sub(other);
    }

    @Override
    public Var mul(Var other)  throws CalcException{
        if(other instanceof Scalar){
            double[] res= Arrays.copyOf(value,value.length);
            for (int i = 0; i < res.length; i++) {
                res[i]=res[i]*((Scalar)other).getValue();
            }
            return  new Vector(res);
        }

        else if (other instanceof Vector) {
            if (this.value.length == ((Vector) other).value.length) {
                double[] res = Arrays.copyOf(value, value.length);
                double mul = 0;
                for (int i = 0; i < res.length; i++) {
                    res[i] = res[i] * ((Vector) other).value[i];
                    mul = mul + res[i];

                }
                return new Scalar(mul);
            }
        }

        return super.mul(other);
    }

    @Override
    public Var div (Var other) throws CalcException {
        if(other instanceof Scalar){
            double[] res= Arrays.copyOf(value,value.length);
            for (int i = 0; i < res.length; i++) {
                if (((Scalar)other).getValue()==0) throw new CalcException(" Деление на ноль");
                res[i]=res[i]/((Scalar)other).getValue();
            }
            return  new Vector(res);
        }



        return super.div(other);
    }



    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("{");
        String delimiter = "";
        for (double v : value) {
            out.append(delimiter).append(v);
            delimiter = ", ";
        }
        out.append("}");
        return out.toString();
    }
}
