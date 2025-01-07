//package com.example.BookMyShow.service;
//
//import com.example.BookMyShow.models.Ticket;
//import com.itextpdf.kernel.colors.Color;
//import com.itextpdf.kernel.colors.DeviceRgb;
//import com.itextpdf.kernel.pdf.PdfDocument;
//import com.itextpdf.kernel.pdf.PdfWriter;
//import com.itextpdf.layout.Document;
//import com.itextpdf.layout.element.Cell;
//import com.itextpdf.layout.element.Paragraph;
//import com.itextpdf.layout.element.Table;
//import com.itextpdf.layout.property.TextAlignment;
//import com.itextpdf.layout.property.UnitValue;
//import org.springframework.stereotype.Service;
//
//import java.io.FileNotFoundException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//@Service
//public class PDFGenerator {
//
//    public static String generateTicketPDF(Ticket ticket) throws FileNotFoundException {
//        // Define the PDF file path based on ticket ID
//        String pdfPath = "ticket_" + ticket.getId() + ".pdf";
//
//        // Initialize PDF Writer
//        PdfWriter writer = new PdfWriter(pdfPath);
//
//        // Initialize PDF Document
//        PdfDocument pdf = new PdfDocument(writer);
//
//        // Initialize Document object
//        Document document = new Document(pdf);
//
//        try {
//            // Define Colors
//            Color headerColor = new DeviceRgb(230, 230, 250); // Light lavender
//
//            // Add Title
//            Paragraph title = new Paragraph("Your Ticket Details")
//                    .setFontSize(24)
//                    .setBold()
//                    .setTextAlignment(TextAlignment.CENTER);
//            document.add(title);
//
//            // Add Spacer
//            document.add(new Paragraph(" "));
//
//            // Ticket Information Table
//            Table table = new Table(UnitValue.createPercentArray(new float[]{1, 2})) // Two columns
//                    .setWidth(UnitValue.createPercentValue(100));
//
//            // Add rows for Ticket Details
//            table.addCell(createHeaderCell("Ticket ID", headerColor));
//            table.addCell(createValueCell(String.valueOf(ticket.getId())));
//
//            table.addCell(createHeaderCell("User", headerColor));
//            table.addCell(createValueCell(ticket.getUser().getName()));
//
//            table.addCell(createHeaderCell("Total Amount", headerColor));
//            table.addCell(createValueCell("\u20B9" + ticket.getTotal_amount()));
//
//            table.addCell(createHeaderCell("Status", headerColor));
//            table.addCell(createValueCell(ticket.getTicketStatus().toString()));
//
//            document.add(table);
//
//            // Add Show and Seat Details
//            document.add(new Paragraph(" ")); // Spacer
//
//            document.add(new Paragraph("Additional Details:")
//                    .setFontSize(16)
//                    .setBold());
//
//            Table showSeatTable = new Table(UnitValue.createPercentArray(new float[]{1, 2}))
//                    .setWidth(UnitValue.createPercentValue(100));
//
//            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy HH:mm");
//            showSeatTable.addCell(createHeaderCell("Show Details", headerColor));
//            showSeatTable.addCell(createValueCell(
//                    "Movie: Ganguva\n" +
//                            "Date: " + dateFormat.format(new Date())
//            ));
//
//            showSeatTable.addCell(createHeaderCell("Theatre Name" , headerColor));
//            String value = ticket.getShow().getScreen().getTheatre().getName()+ " " +
//                    ticket.getShow().getScreen().getTheatre().getCity().getName();
//
//            Cell cell = createValueCell(value);
//            showSeatTable.addCell(cell);
//
//            showSeatTable.addCell(createHeaderCell("Seats", headerColor));
//            StringBuilder seats = new StringBuilder();
//            ticket.getShowSeats().forEach(showSeat ->
//                    seats.append("\u2022 Seat: ").append(showSeat.getSeat().getName()).append("\n")
//            );
//            showSeatTable.addCell(createValueCell(seats.toString()));
//
//            document.add(showSeatTable);
//
//            // Add a footer
//            document.add(new Paragraph("Cancellation Policy: Cut-off time of 4 hrs before showtime.")
//                    .setFontSize(10)
//                    .setTextAlignment(TextAlignment.CENTER));
//
//            // Close the document
//            document.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new RuntimeException("Error occurred while generating PDF for Ticket: " + ticket.getId());
//        }
//
//        return pdfPath; // Return the path of the generated PDF
//    }
//
//    private static Cell createHeaderCell(String text, Color backgroundColor) {
//        return new Cell()
//                .add(new Paragraph(text).setBold())
//                .setBackgroundColor(backgroundColor)
//                .setTextAlignment(TextAlignment.CENTER);
//    }
//
//    private static Cell createValueCell(String text) {
//        return new Cell()
//                .add(new Paragraph(text))
//                .setTextAlignment(TextAlignment.LEFT);
//    }
//}