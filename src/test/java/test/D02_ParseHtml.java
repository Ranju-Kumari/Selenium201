package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;



public class D02_ParseHtml {

    public D02_ParseHtml() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static final String HTML = "//certificateProblem//ExtentReports//Test-Report-2019.03.01.15.12.html";
    public static final String DEST = "//certificateProblem//ExtentReports//report.pdf";

    /**
     * Html to pdf conversion example.
     * @param file
     * @throws IOException
     * @throws DocumentException
     */
    public void createPdf(String file) throws IOException, DocumentException {
        // step 1
        Document document = new Document();
        // step 2
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(file));
        // step 3
        document.open();
        // step 4
        XMLWorkerHelper.getInstance().parseXHtml(writer, document,
                new FileInputStream(HTML));
        // step 5
        document.close();
    }

    /**
     * Main method
     */
    public static void main(String[] args) throws IOException, DocumentException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new D02_ParseHtml().createPdf(DEST);
    }
}