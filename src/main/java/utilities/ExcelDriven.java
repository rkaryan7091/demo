package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDriven {
      
	String url;
	XSSFWorkbook workbook;
	public Iterator<Object> searchItem(String path, String sheet) throws IOException
	{
		FileInputStream seaa= new FileInputStream(path);
		 workbook = new XSSFWorkbook(seaa);
		 int sheetCount=workbook.getNumberOfSheets();
		ArrayList<Object> searchItem = new ArrayList<>();
		Iterator<Sheet> wk=workbook.iterator();
		while (wk.hasNext())
		{
			Sheet currentSheet=wk.next();
			if (currentSheet.getSheetName().equalsIgnoreCase(sheet))
			{

                   Iterator<Row> rows=currentSheet.rowIterator();
                   while (rows.hasNext())
                   {
                	  Row currentRow=rows.next();
                	  Iterator<Cell> ce=currentRow.cellIterator();
                	  while(ce.hasNext())
                	  {
                		  Cell currentCell= ce.next();
                		  searchItem.add(currentCell.getStringCellValue());
                	  }
                		  
                   }
			}
		
		}
		return searchItem.iterator();

}
}
