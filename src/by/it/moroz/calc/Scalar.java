package by.it.moroz.calc;

class Scalar extends Var {

    private double value;

    Scalar(double value) {
        this.value = value;
    }

    Scalar(Scalar scalar) {
        this.value = scalar.value;
    }

    Scalar(String strValue) {
        value = Double.parseDouble(strValue);
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar){
            double res = this.value+((Scalar) other).value;
            return new Scalar(res);
        }
        return other.add(this);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar){
            double res = this.value-((Scalar) other).value;
            return new Scalar(res);
        }
        Scalar minus = new Scalar(value-1);
        return other.add(this.mul(minus));
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar){
            double res = this.value*((Scalar) other).value;
            return new Scalar(res);
        }
        return other.mul(this);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar){
            if(((Scalar) other).value==0)
                throw new CalcException("Деление на ноль");
            else {double res = this.value/((Scalar) other).value;
            return new Scalar(res);}
        }
        return super.div(other);
    }

    protected double getValue() {
        return value;
    }

    @Override
    public String toString() {
        //return Double.toString(value);
        return String.valueOf(value);
    }
}
