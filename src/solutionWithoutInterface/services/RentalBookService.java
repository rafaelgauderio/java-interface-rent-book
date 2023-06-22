package solutionWithoutInterface.services;

import solutionWithoutInterface.entities.BookRental;
import solutionWithoutInterface.entities.Invoice;

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

        bookRental.setInvoice(new Invoice());
    }


}
