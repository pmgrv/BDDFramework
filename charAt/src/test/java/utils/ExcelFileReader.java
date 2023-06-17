package utils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFCell;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ExcelFileReader {
	private FileInputStream fis ;
	private FileOutputStream fos ;
	private XSSFWorkbook workbook ;
	private XSSFSheet sheet;
	final private String sheetName = "UserCredentials";
	final private String userhead = "Username";
	final private String passhead = "Password";
//	private XSSFRow rows ;
//	private XSSFCell cells ;
	private String fileLoc= System.getProperty("user.dir")+"\\testData\\TestingReadWrite.xlsx";
//	private File files = new File(fileLoc);
	private void WriteInExcelFile() throws IOException,FileNotFoundException {
		try {
			System.out.println("At Excel File Writer" + fileLoc);
			fos = new FileOutputStream(fileLoc);		
			workbook = new XSSFWorkbook();
			sheet = workbook.createSheet(sheetName);
			sheet.createRow(0).createCell(0).setCellValue(userhead);
			sheet.getRow(0).createCell(1).setCellValue(passhead);
			sheet.createRow(1).createCell(0).setCellValue("Pravinkumar");
			sheet.getRow(1).createCell(1).setCellValue("pmgrv1432");
			sheet.createRow(2).createCell(0).setCellValue("man");
			sheet.getRow(2).createCell(1).setCellValue("man1432");
			sheet.createRow(3).createCell(0).setCellValue("gaj");
			sheet.getRow(3).createCell(1).setCellValue("gaj1432");
			sheet.createRow(4).createCell(0).setCellValue("raj");
			sheet.getRow(4).createCell(1).setCellValue("raj1432");
		} catch(Exception e) {
			System.out.println(e.getStackTrace());
		} finally{
			workbook.write(fos);
			if(fos != null) {
				fos.close();
			}
		}
	}
	public void ReadExcelData() throws IOException,FileNotFoundException {
		try {
			WriteInExcelFile();
			fis = new FileInputStream(fileLoc);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet(sheetName);
			int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
			int colCount = sheet.getRow(0).getLastCellNum() ;

			for(int i = 1; i<=rowCount; i++) {
				for(int j = 0; j<colCount; j++) {
					System.out.println(sheet.getRow(i).getCell(j));
				}
			}
		}catch(Exception e) {
			System.out.println(e.getStackTrace());
		}finally {
			if(fis != null) {
				fis.close();
			}
		}
	}
}
