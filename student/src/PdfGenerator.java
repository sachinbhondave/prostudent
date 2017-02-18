
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.annotation.Generated;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.draw.DottedLine;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.LineSeparator;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.ListItem;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;

public class PdfGenerator {
	public void generateInvoice(ArrayList<String> list){
		try{
			if(list.size() < 16){
				throw new Exception("Not all values for Student available");
			}
			
			PdfWriter writer = new PdfWriter("D:\\Bill.pdf");
			PdfDocument pdfDoc=new PdfDocument(writer);
			Document doc=new Document(pdfDoc);
			Image schoolLogo = new Image(ImageDataFactory.create("C:\\Users\\shree\\git\\prostudent\\student\\src\\images\\Logo.jpg")).scaleToFit(220f, 220f);
			Image officeStamp = new Image(ImageDataFactory.create("C:\\Users\\shree\\git\\prostudent\\student\\src\\images\\sign.PNG"));
			Paragraph p = new Paragraph().add(schoolLogo);
			doc.add(p);
			p= new Paragraph("Office Copy for Register");
			doc.add(p);
			Table details=new Table(4);
			Cell col1=new Cell(1,2).add("Registration Number");
			Cell col2= new Cell(1,2).add(list.get(0));
			details.addCell(col1);
			details.addCell(col2);
			col1=new Cell(1,2).add("Full Name");
			col2= new Cell(1,2).add(list.get(1)+" "+list.get(2));
			details.addCell(col1);
			details.addCell(col2);
			
			col1=new Cell(1,2).add("Postal Address");
			col2= new Cell(1,2).add(list.get(4)+", "+list.get(6)+", "+list.get(8)+", "+list.get(9)+"-"+list.get(10));
			details.addCell(col1);
			details.addCell(col2);
			
			col1=new Cell(1,2).add("Sex");
			col2= new Cell(1,2).add(list.get(5));
			details.addCell(col1);
			details.addCell(col2);
			
			col1=new Cell(1,2).add("Class Applied for");
			col2= new Cell(1,2).add(list.get(7));
			details.addCell(col1);
			details.addCell(col2);
			
			col1=new Cell(1,2).add("Exam slot(Date & Time)");
			col2= new Cell(1,2).add(list.get(14));
			details.addCell(col1);
			details.addCell(col2);
			
			col1=new Cell(1,2).add("Registration Fee");
			col2= new Cell(1,2).add(list.get(15));
			details.addCell(col1);
			details.addCell(col2);
			
			Calendar c=Calendar.getInstance();
			SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
			String billingDate=f.format(c.getTime());
			
			col1=new Cell(1,2).add("Registration Date");
			col2= new Cell(1,2).add(billingDate);
			details.addCell(col1);
			details.addCell(col2);
			doc.add(details);
			Table disclaimer = new Table(4);
			col1=new Cell(1,2).add("Disclaimer : Should be configurable and school mgmt. can write any message they\r\n" + 
					" want ,this is an example. This is and example contact no 12234449994 , \r\n" + 
					"www.xmxll.com <http://www.xmxll.com>, refer to school website").setBorder(Border.NO_BORDER);
			col2=new Cell(1, 2).add(officeStamp).setBorder(Border.NO_BORDER);
			disclaimer.addCell(col1);
			disclaimer.addCell(col2);
			doc.add(disclaimer);
			LineSeparator ls = new LineSeparator(new DottedLine());
			doc.add(ls);
			p= new Paragraph().add(schoolLogo);
			doc.add(p);
			p = new Paragraph("Student copy handover");
			doc.add(p);
			doc.add(details);
			doc.add(disclaimer);
			doc.close();
		}
		catch(FileNotFoundException fe){
			fe.printStackTrace();
			System.out.println("File not found");
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Exception handled");
		}
		}
}
