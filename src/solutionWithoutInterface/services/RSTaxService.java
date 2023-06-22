package solutionWithoutInterface.services;

public class RSTaxService {

    public double taxValue (double amout) {
        if (amout > 100.0) {
            return amout * 0.15;
        } else {
            return amout * 0.20;
        }
    }
}
