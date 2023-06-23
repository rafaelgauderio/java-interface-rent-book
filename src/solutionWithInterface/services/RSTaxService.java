package solutionWithInterface.services;

public class RSTaxService implements TaxService{

    @Override
    public double tax(double amount) {
        if(amount > 100.0) {
            return amount * 0.15;
        } else {
            return amount * 0.15;
        }
    }

}
