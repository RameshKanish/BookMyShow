package com.example.BookMyShow.service;

import com.example.BookMyShow.models.Ticket;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;


@Service
public class PDFGenerator {
    public static String generateTicketPDF(Ticket ticket) throws FileNotFoundException {
        // Define the PDF file path based on ticket ID
        String pdfPath = "ticket_" + ticket.getId() + ".pdf";

        // Initialize PDF Writer
        PdfWriter writer = new PdfWriter(pdfPath);

        // Initialize PDF Document
        PdfDocument pdf = new PdfDocument(writer);

        // Initialize Document object
        Document document = new Document(pdf);

        try {
            // Add details to the PDF
            document.add(new Paragraph("Ticket ID: " + ticket.getId()));
            document.add(new Paragraph("User: " + ticket.getUser().getName()));
//            document.add(new Paragraph("Movie: " + ticket.getMovie().getName()));
//            document.add(new Paragraph("Show Date/Time: " + ticket.getShow().getStartTime()));
//            document.add(new Paragraph("Seats:"));
//            ticket.getShowSeats().forEach(showSeat ->
//                    document.add(new Paragraph("- Seat: " + showSeat.getSeat().getName()))
//            );
            document.add(new Paragraph("Total Amount: $" + ticket.getTotal_amount()));
            document.add(new Paragraph("Status: " + ticket.getTicketStatus()));

            // Close the document
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error occurred while generating PDF for Ticket: " + ticket.getId());
        }

        return pdfPath; // Return the path of the generated PDF
    }
}