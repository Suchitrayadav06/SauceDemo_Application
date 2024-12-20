package utilities;

	import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import java.io.IOException;

	import org.apache.poi.ss.usermodel.CellStyle;
	import org.apache.poi.ss.usermodel.FillPatternType;
	import org.apache.poi.ss.usermodel.IndexedColors;
	import org.apache.poi.xssf.usermodel.XSSFCell;
	import org.apache.poi.xssf.usermodel.XSSFRow;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;

	public class ExcelUtility {
	    private String path; // File path for the Excel file
	    private FileInputStream fi;
	    private FileOutputStream fo;
	    private XSSFWorkbook workbook;
	    private XSSFSheet sheet;
	    private XSSFRow row;
	    private XSSFCell cell;

	    // Constructor to initialize the file path
	    public ExcelUtility(String path) {
	        this.path = path;
	    }

	    // Method to get the row count from a given sheet
	    public int getRowCount(String sheetName) throws IOException {
	        fi = new FileInputStream(path); // Open the file
	        workbook = new XSSFWorkbook(fi); // Load the workbook
	        sheet = workbook.getSheet(sheetName); // Get the specified sheet
	        int rowCount = sheet.getLastRowNum(); // Get the last row number (0-based index)
	        workbook.close(); // Close the workbook
	        fi.close(); // Close the file input stream
	        return rowCount + 1; // Add 1 to convert 0-based index to row count
	    }

	    // Method to get the cell count (columns) in a specific row
	    public int getCellCount(String sheetName, int rownum) throws IOException {
	        fi = new FileInputStream(path); // Open the file
	        workbook = new XSSFWorkbook(fi); // Load the workbook
	        sheet = workbook.getSheet(sheetName); // Get the specified sheet
	        row = sheet.getRow(rownum); // Get the specified row
	        int cellCount = row.getLastCellNum(); // Get the number of cells in the row
	        workbook.close(); // Close the workbook
	        fi.close(); // Close the file input stream
	        return cellCount;
	    }

	    // Method to read data from a cell
	    public String getCellData(String sheetName, int rownum, int colnum) throws IOException {
	        fi = new FileInputStream(path); // Open the file
	        workbook = new XSSFWorkbook(fi); // Load the workbook
	        sheet = workbook.getSheet(sheetName); // Get the specified sheet
	        row = sheet.getRow(rownum); // Get the specified row
	        cell = row.getCell(colnum); // Get the specified cell
	        String data;
	        try {
	            data = cell.toString(); // Convert the cell value to a string
	        } catch (Exception e) {
	            data = ""; // Return empty string if the cell is null
	        }
	        workbook.close(); // Close the workbook
	        fi.close(); // Close the file input stream
	        return data;
	    }

	    // Method to write data to a cell
	    public void setCellData(String sheetName, int rownum, int colnum, String data) throws IOException {
	        fi = new FileInputStream(path); // Open the file
	        workbook = new XSSFWorkbook(fi); // Load the workbook
	        sheet = workbook.getSheet(sheetName); // Get the specified sheet
	        row = sheet.getRow(rownum); // Get the specified row
	        if (row == null) { // If the row doesn't exist, create it
	            row = sheet.createRow(rownum);
	        }
	        cell = row.getCell(colnum); // Get the specified cell
	        if (cell == null) { // If the cell doesn't exist, create it
	            cell = row.createCell(colnum);
	        }
	        cell.setCellValue(data); // Set the value of the cell
	        fo = new FileOutputStream(path); // Open the file for writing
	        workbook.write(fo); // Write changes to the file
	        workbook.close(); // Close the workbook
	        fi.close(); // Close the file input stream
	        fo.close(); // Close the file output stream
	    }

	    // Method to fill a cell with green color
	    public void fillGreenColor(String sheetName, int rownum, int colnum) throws IOException {
	        fi = new FileInputStream(path); // Open the file
	        workbook = new XSSFWorkbook(fi); // Load the workbook
	        sheet = workbook.getSheet(sheetName); // Get the specified sheet
	        row = sheet.getRow(rownum); // Get the specified row
	        if (row == null) { // Create row if it doesn't exist
	            row = sheet.createRow(rownum);
	        }
	        cell = row.getCell(colnum); // Get the specified cell
	        if (cell == null) { // Create cell if it doesn't exist
	            cell = row.createCell(colnum);
	        }

	        // Create a style for filling the cell
	        CellStyle style = workbook.createCellStyle();
	        style.setFillForegroundColor(IndexedColors.GREEN.getIndex()); // Set foreground color to green
	        style.setFillPattern(FillPatternType.SOLID_FOREGROUND); // Set fill pattern to solid
	        cell.setCellStyle(style); // Apply the style to the cell

	        fo = new FileOutputStream(path); // Open the file for writing
	        workbook.write(fo); // Write changes to the file
	        workbook.close(); // Close the workbook
	        fi.close(); // Close the file input stream
	        fo.close(); // Close the file output stream
	    }
	}


