package solutionWithoutInterface.application;

import solutionWithoutInterface.entities.Book;
import solutionWithoutInterface.entities.BookRental;
import solutionWithoutInterface.services.RSTaxService;
import solutionWithoutInterface.services.RentalBookService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class ProgramScanner {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        System.out.println("Enter the book rental details");
        System.out.print("The book title");
        String title = input.nextLine();
        System.out.print("Inform the withdrawal data and time (dd/MM/yyyy HH:mm): ");
        LocalDateTime withdrawalDate = LocalDateTime.parse(input.nextLine(),dateTimeFormatter);
        System.out.print("Inform the return data and time (dd/MM/yyyy HH:mm): ");
        LocalDateTime returnDate = LocalDateTime.parse(input.nextLine(),dateTimeFormatter);

        BookRental bookRental = new BookRental(withdrawalDate,returnDate,new Book(title));

        System.out.print("Enter the price per hour: ");
        double pricePerHour = input.nextDouble();
        System.out.print("Enter the price per day: ");
        double pricePerDay = input.nextDouble();

        RentalBookService rentalBookService = new RentalBookService(pricePerDay, pricePerHour, new RSTaxService());
        rentalBookService.createInvoice(bookRental);

        printinInvoice(bookRental);

    }

    public static void printinInvoice(BookRental bookRental) {
        System.out.println("\nInvoice Data");
        System.out.println("Basic payment: " + String.format("%.2f", bookRental.getInvoice().getBasicPayment()));
        System.out.println("Tax: " + String.format("%.2f", bookRental.getInvoice().getTax()));
        System.out.println("Total payment: " + String.format("%.2f", bookRental.getInvoice().totalPayment()));
    }
}

