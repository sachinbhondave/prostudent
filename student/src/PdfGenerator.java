
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
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.LineSeparator;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.ListItem;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import com.sun.javafx.font.FontFactory;

public class PdfGenerator {
	
//	public static void main(String[] args) {
//		ArrayList<String> list=new ArrayList<String>();
////		list.add(null);
//		list.add("25");
//		list.add("Faizan");
//		list.add("Mirza");
//		list.add("Pune");
//		list.add("Kanpur");
//		list.add("Male");
//		list.add("Kanpur");
//		list.add("BTECH");
//		list.add("Pune");
//		list.add("Maharashtra");
//		list.add("411057");
//		list.add("faizan.mirza@gmail.tom");
//		list.add("02-01-1994");
//		list.add("9999999999");
//		list.add("02-01-1993");
//		list.add("08-01-1993");
//		list.add("5500");
////		System.out.println(list.get(0));
//		PdfGenerator p=new PdfGenerator();
//		p.generateInvoice(list);
//		/*
//		 * id   0
//		 * first name 1
//		 * family name 2
//		 * postal addr 3
//		 * perm add 4
//		 * sex 5
//		 * city 6
//		 * course 7
//		 * district 8
//		 * state 9
//		 * pin code 10
//		 * email 11
//		 * dob 12
//		 * contact 13
//		 * exam date 14
//		 * exam end date 15
//		 * reg fee 16w
//		 */
//		
//	}
	
	
	
	public void generateInvoice(ArrayList<String> list){
		try{
			if(list.size()<17){
				throw new Exception("Not all values for Student available");
			}
			Calendar c=Calendar.getInstance();
			SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
			String billingDate=f.format(c.getTime());
//			System.out.println("Date is "+ billingDate);
//			list.add("Id1");
//			list.add("Faizan");
//			list.add("Mirza");
//			list.add("StandardX");
//			list.add("Total fee paid");
//			list.add("remaining fee");
//			list.add("Fine");
			PdfFont font = PdfFontFactory.createFont(FontConstants.TIMES_ROMAN);
			PdfFont yellowFont = PdfFontFactory.createFont(FontConstants.TIMES_BOLD);
			Text schoolName = new Text("CREED SCHOOL").setFontColor(Color.RED).setFont(PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD));
			PdfWriter writer = new PdfWriter(list.get(0)+" Bill.pdf");
			PdfDocument pdfDoc=new PdfDocument(writer);
			Document doc=new Document(pdfDoc);
			Paragraph p = new Paragraph(schoolName);
//			LineSeparator ls=new LineSeparator();
			
			doc.add(p);
			p = new Paragraph("......................................................................................................................");
			doc.add(p);
			doc.add(new Paragraph("\n\n"));
//			List l=new List().setSymbolIndent(12).setListSymbol("\u2022").setFont(font);
//			l.add(new ListItem("Student Id		   :				"+list.get(0)));
//			l.add(new ListItem("Name			   :				"+list.get(1)+" "+list.get(2)));
//			l.add(new ListItem("Postal Address     :				"+list.get(3)));
//			l.add(new ListItem("Permanent Address  :				"+list.get(4)+", "+list.get(6)+", "+list.get(8)+", "+list.get(9)+"-"+list.get(10)));
//			l.add(new ListItem("Sex				   :				"+list.get(5)));
//			l.add(new ListItem("Course			   :				"+list.get(7)));
//			l.add(new ListItem("Email			   :				"+list.get(11)));
//			l.add(new ListItem("Date Of Birth	   :				"+list.get(12)));
//			l.add(new ListItem("Contact			   :				"+list.get(13)));
//			l.add(new ListItem("Exam date		   :				"+list.get(14)));
//			l.add(new ListItem("Exam End date	   :				"+list.get(15)));
//			l.add(new ListItem("Registration Fee   :				"+list.get(16)));
//			l.add(new ListItem("Billing Date       :                "+billingDate));
//			doc.add(l);
			Table table=new Table(3);
			
			Cell col1=new Cell(1,1).add("Student Id");
			Cell col2= new Cell(1,2).add(list.get(0));
			table.addCell(col1);
			table.addCell(col2);
			
			col1=new Cell(1,1).add("Name");
			col2= new Cell(1,2).add(list.get(1));
			table.addCell(col1);
			table.addCell(col2);
			
			col1=new Cell(1,1).add("Postal Address");
			col2= new Cell(1,2).add(list.get(3));
			table.addCell(col1);
			table.addCell(col2);
			
			col1=new Cell(1,1).add("Permanent Address");
			col2= new Cell(1,2).add(list.get(4)+", "+list.get(6)+", "+list.get(8)+", "+list.get(9)+"-"+list.get(10));
			table.addCell(col1);
			table.addCell(col2);
			
			col1=new Cell(1,1).add("Sex");
			col2= new Cell(1,2).add(list.get(5));
			table.addCell(col1);
			table.addCell(col2);
			
			col1=new Cell(1,1).add("Course");
			col2= new Cell(1,2).add(list.get(7));
			table.addCell(col1);
			table.addCell(col2);
			
			col1=new Cell(1,1).add("Email");
			col2= new Cell(1,2).add(list.get(11));
			table.addCell(col1);
			table.addCell(col2);
			
			col1=new Cell(1,1).add("Date of Birth");
			col2= new Cell(1,2).add(list.get(12));
			table.addCell(col1);
			table.addCell(col2);
			
			col1=new Cell(1,1).add("Contact");
			col2= new Cell(1,2).add(list.get(13));
			table.addCell(col1);
			table.addCell(col2);
			
			col1=new Cell(1,1).add("Exam Date");
			col2= new Cell(1,2).add(list.get(14));
			table.addCell(col1);
			table.addCell(col2);
			
			col1=new Cell(1,1).add("Exam End Date");
			col2= new Cell(1,2).add(list.get(15));
			table.addCell(col1);
			table.addCell(col2);
			
			col1=new Cell(1,1).add("Registration Fee");
			col2= new Cell(1,2).add(list.get(16));
			table.addCell(col1);
			table.addCell(col2);
			
			col1=new Cell(1,1).add("Billing Date");
			col2= new Cell(1,2).add(billingDate);
			table.addCell(col1);
			table.addCell(col2);
			
			doc.add(table);
			
			p=new Paragraph("\n\n\n");
			doc.add(p);
			Image sign = new Image(ImageDataFactory.create("sign.PNG"));
//			p = new Paragraph().add(sign);
//			
//			
////			doc.add(new Paragraph("Billing Invoice:"));
////			List list1=new List().setSymbolIndent(12).setListSymbol("\u2022").setFont(font);
////			list1.add(new ListItem("Student Id:  "+list.get(0)));
////			list1.add(new ListItem("Name:        "+list.get(1)));
////			doc.add(list1);
//			doc.add(p);
			
			
//			
//			Table t=new Table(3);
//			Cell col1=new Cell(1,1).add("Student Idjasdkhasbduadvbsjdvufvbahbfuiadbfkjabdsbfiahbdfuadfjibafuybsiudfbhadbfisandbfiusbi");
//			Cell col2=new Cell(1,2).add(list.get(0));
//			t.addCell(col1);
//			t.addCell(col2);
//			t.addCell(col1);
//			t.addCell(col2);
//			col1=new Cell(1,1).add("Name");
//			col2=new Cell(1,2).add(list.get(1));
//			doc.add(t);
			p=new Paragraph().add(sign);
			doc.add(p);
			doc.close();
			System.out.println("List values are:: "+list.toString());
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
