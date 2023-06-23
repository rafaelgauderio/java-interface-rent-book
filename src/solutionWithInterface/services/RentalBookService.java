package solutionWithInterface.services;

import solutionWithInterface.entities.BookRental;
import solutionWithInterface.entities.Invoice;

import java.time.Duration;

public class RentalBookService {

    private Double pricePerDay;
    private Double pricePerHour;
    private TaxService taxService;

    public RentalBookService(Double pricePerDay, Double pricePerHour, TaxService taxService) {
        this.pricePerDay = pricePerDay;
        this.pricePerHour = pricePerHour;
        this.taxService = taxService;
    }

    public void createInvoice(BookRental bookRental) {

        double minutes = Duration.between(bookRental.getBeginDate(), bookRental.getEndDate()).toMinutes();
        double fractionHours = Duration.between(bookRental.getBeginDate(),bookRental.getEndDate()).toMinutes() /60.0;

        /*
        System.out.println("\nminutos: " + minutes);
        System.out.println("fractionHours: " + fractionHours);
        System.out.println("HoursRoundUp: " + Math.ceil(fractionHours));
         */

        double basicPayment = 0.0;
        // payment calculate in days if hours bigger than 12 hours,
        // payment calculete in hours if hours less than 12 hours
        int limiteHours = 12;
        if (fractionHours > limiteHours) {
            int days = (int) Math.ceil(fractionHours / 24);
            basicPayment = this.pricePerDay * days;
        } else {
            basicPayment = this.pricePerHour * Math.ceil(fractionHours);
        }

        double tax = taxService.tax(basicPayment);

        bookRental.setInvoice(new Invoice(basicPayment,tax));
    }


}
