package com.api.PDFgeneration.services;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.api.dtos.CollegeDetailsDTO;
import com.api.services.ICollegeService;
import com.itextpdf.io.source.ByteArrayOutputStream;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

@Service
public class PdfGenerationService {

    @Autowired
    private ICollegeService collegeService;
    
    // Injecting the file path from application.properties
    @Value("${pdf.save.path}")
    private String pdfSavePath;

    // Generate PDF as byte array
    public byte[] generatePdf(int id) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        
        try {
            PdfWriter writer = new PdfWriter(outputStream);
            PdfDocument pdfDocument = new PdfDocument(writer);
            Document document = new Document(pdfDocument);
            
            CollegeDetailsDTO collegeDetailsById = collegeService.getCollegeDetailsById(id);
            document.add(new Paragraph(collegeDetailsById.toString()));
            
            
			/*
			 * // PDF content List<CollegeDetailsDTO> allCollegeDetails =
			 * collegeService.getAllCollegeDetails(); for (CollegeDetailsDTO collegeDetails
			 * : allCollegeDetails) { document.add(new
			 * Paragraph(collegeDetails.toString())); }
			 */

            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return outputStream.toByteArray();
    }

    // Save PDF
    public void savePdfToFile(int id) {
        // Generate dynamic file name using date and time
        String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        String filePath = pdfSavePath + "/college_" + timeStamp + ".pdf"; 

        byte[] pdfData = generatePdf(id);
        
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            fos.write(pdfData);
            System.out.println("PDF saved to " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    
}
}