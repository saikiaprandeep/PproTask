package com.ppro.web.util;


import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import java.io.IOException;
import java.io.InputStream;

/**
 * This class reads pdf file from folder --- src-test-resources-pdfFiles
 */
public class ReadPdfFile {

    /**
     * This method reads pdf file from folder --- (src-test-resources-pdfFiles)
     * @param :  only pdf the file name like ("pdffile.pdf")
     * @returns : String containing the contents of the pdf file
     */
    public String readPdf(String pdfFilename) throws IOException {

        InputStream in = getClass().getResourceAsStream("/pdfFiles/" + pdfFilename);

        PDDocument doc = PDDocument.load(in);
        String pdfContent  = new PDFTextStripper().getText(doc);
        doc.close();
        return  pdfContent;

    }


}
