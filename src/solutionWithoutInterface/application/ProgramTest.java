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

        RSTaxService rsTaxService = new RSTaxService();
        System.out.println(rsTaxService.taxValue(100)); // 20
        System.out.println(rsTaxService.taxValue(200)); // 30

        double pricePerHour = 10.0;
        double pricePerDay = 130.0;
        double basicPayment = 50.0;
        double tax = 10.0;
        LocalDateTime beginDate = LocalDateTime.parse("17/12/2021 10:30",dateTimeFormatter);
        LocalDateTime endDate = LocalDateTime.parse("17/12/2021 14:40",dateTimeFormatter);
        Book elite = new Book("A elite do Atraso");
        Invoice invoice = new Invoice(basicPayment,tax);

        BookRental bookRental = new BookRental(beginDate,endDate,elite);
        bookRental.setInvoice(invoice);
        RentalBookService rentalBookService = new RentalBookService(pricePerHour, pricePerDay, new RSTaxService());


        System.out.println("\nInvoice Data");
        System.out.println("Basic payment: " + bookRental.getInvoice().getBasicPayment());
        System.out.println("Tax: " + bookRental.getInvoice().getTax());
        System.out.println("Total payment: " + bookRental.getInvoice().totalPayment());

    }
}
