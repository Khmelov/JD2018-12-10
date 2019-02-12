package by.it.subach.Calc_V6_fabric_and_logging;

public class VarCreator {

   static Var createScalar(String operand){
        return new Scalar(operand);
    }

   static Var createVector(String operand){
       return new Vector(operand);
   }

    static Var createMatrix(String operand){
        return new Matrix(operand);
    }

}
