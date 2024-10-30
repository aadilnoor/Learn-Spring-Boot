package com.api.PDFgeneration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.PDFgeneration.services.PdfGenerationService;

@RestController 
@RequestMapping("/pdf")
public class PdfController {

	
	  @Autowired 
	  private PdfGenerationService pdfGenerationService;
	 
    @PostMapping("/generate-pdf/{collegeId}")
    public String generatePdf(int id) {
    	pdfGenerationService.savePdfToFile(id);
        return "PDF generated and saved to the fixed path.";
    }
    
	/*
	 * @GetMapping("/create-pdf") public String createPdf() { return
	 * pdfGenerationService.generatePdf(); }
	 */
}
