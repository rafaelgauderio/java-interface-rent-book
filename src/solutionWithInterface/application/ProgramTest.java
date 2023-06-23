package solutionWithInterface.application;

import solutionWithInterface.entities.Book;
import solutionWithInterface.entities.BookRental;
import solutionWithInterface.services.RSTaxService;
import solutionWithInterface.services.RentalBookService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class ProgramTest {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        /*
        RSTaxService rsTaxService = new RSTaxService();
        System.out.println(rsTaxService.taxValue(100)); // 20
        System.out.println(rsTaxService.taxValue(200)); // 30
        */

        // mockData less than 12 hours
        LocalDateTime beginDate = LocalDateTime.parse("17/12/2021 10:30", dateTimeFormatter);
        LocalDateTime endDate = LocalDateTime.parse("17/12/2021 14:40", dateTimeFormatter);
        Book mmm = new Book("The Mythical Man-Month");
        BookRental bookRental = new BookRental(beginDate, endDate, mmm);

        double pricePerHour = 10.0;
        double pricePerDay = 130.0;
        RentalBookService rentalBookService = new RentalBookService(pricePerDay, pricePerHour, new RSTaxService());
        // this function create the invoice base on the given data
        rentalBookService.createInvoice(bookRental);
        printinInvoice(bookRental);

        // mock data, rent more than 12 hours
        beginDate = LocalDateTime.parse("20/12/2021 10:30", dateTimeFormatter);
        endDate = LocalDateTime.parse("22/12/2021 11:40", dateTimeFormatter);
        BookRental bookRentalMoreThan12Hours = new BookRental(beginDate, endDate, mmm);
        rentalBookService.createInvoice(bookRentalMoreThan12Hours);
        printinInvoice(bookRentalMoreThan12Hours);

    }

    public static void printinInvoice(BookRental bookRental) {
        System.out.println("\nInvoice Data");
        System.out.println("Basic payment: " + String.format("%.2f", bookRental.getInvoice().getBasicPayment()));
        System.out.println("Tax: " + String.format("%.2f", bookRental.getInvoice().getTax()));
        System.out.println("Total payment: " + String.format("%.2f", bookRental.getInvoice().totalPayment()));
    }
}
