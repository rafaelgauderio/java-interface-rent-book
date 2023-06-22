package solutionWithoutInterface.application;

import solutionWithoutInterface.entities.Book;
import solutionWithoutInterface.entities.BookRental;
import solutionWithoutInterface.entities.Invoice;
import solutionWithoutInterface.services.RSTaxService;
import solutionWithoutInterface.services.RentalBookService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class ProgramTest {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        DateTimeFormatter  dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        /*
        RSTaxService rsTaxService = new RSTaxService();
        System.out.println(rsTaxService.taxValue(100)); // 20
        System.out.println(rsTaxService.taxValue(200)); // 30
        */

        // mockData less than 12 hours
        LocalDateTime beginDate = LocalDateTime.parse("17/12/2021 10:30",dateTimeFormatter);
        LocalDateTime endDate = LocalDateTime.parse("17/12/2021 14:40",dateTimeFormatter);
        Book mmm = new Book("The Mythical Man-Month");
        BookRental bookRental = new BookRental(beginDate,endDate,mmm);

        double pricePerHour = 10.0;
        double pricePerDay = 130.0;
        RentalBookService rentalBookService = new RentalBookService(pricePerDay, pricePerHour, new RSTaxService());
        // this function create the invoice base on the given data
        rentalBookService.createInvoice(bookRental);

        System.out.println("\nInvoice Data 01");
        System.out.println("Basic payment: " + bookRental.getInvoice().getBasicPayment());
        System.out.println("Tax: " + bookRental.getInvoice().getTax());
        System.out.println("Total payment: " + bookRental.getInvoice().totalPayment());

        // mock data, rent more than 12 hours
        beginDate = LocalDateTime.parse("20/12/2021 10:30",dateTimeFormatter);
        endDate = LocalDateTime.parse("22/12/2021 11:40",dateTimeFormatter);
        BookRental bookRentalMoreThan12Hours = new BookRental(beginDate,endDate, mmm);
        rentalBookService.createInvoice(bookRentalMoreThan12Hours);

        System.out.println("\nInvoice Data 02");
        System.out.println("Basic payment: " + bookRentalMoreThan12Hours.getInvoice().getBasicPayment());
        System.out.println("Tax: " + bookRentalMoreThan12Hours.getInvoice().getTax());
        System.out.println("Total payment: " + bookRentalMoreThan12Hours.getInvoice().totalPayment());
    }
}
