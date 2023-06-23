package solutionWithInterface.entities;

import java.time.LocalDateTime;

public class BookRental {

    private LocalDateTime beginDate;
    private LocalDateTime endDate;
    private Book book;
    private Invoice invoice;

    public BookRental () {

    }
    // in the begin of the rental we do not have a invoice yet
    public BookRental(LocalDateTime beginDate, LocalDateTime endDate, Book book) {
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.book = book;
    }

    public LocalDateTime getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(LocalDateTime beginDate) {
        this.beginDate = beginDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
}
