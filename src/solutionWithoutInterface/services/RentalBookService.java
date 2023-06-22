package solutionWithoutInterface.services;

import solutionWithoutInterface.entities.BookRental;
import solutionWithoutInterface.entities.Invoice;

import java.time.Duration;

public class RentalBookService {

    private Double pricePerDay;
    private Double pricePerHour;
    private RSTaxService rsTaxService;

    public RentalBookService(Double pricePerDay, Double pricePerHour, RSTaxService rsTaxService) {
        this.pricePerDay = pricePerDay;
        this.pricePerHour = pricePerHour;
        this.rsTaxService = rsTaxService;
    }

    public void createInvoice(BookRental bookRental) {

        double minutes = Duration.between(bookRental.getBeginDate(), bookRental.getEndDate()).toMinutes();
        double fractionHours = minutes /60.0;

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

        double tax = rsTaxService.taxValue(basicPayment);

        bookRental.setInvoice(new Invoice(basicPayment,tax));
    }


}
