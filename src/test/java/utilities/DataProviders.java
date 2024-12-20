package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	// DataProvider 1
    @DataProvider(name = "LoginData")
    public String[][] getData() throws IOException {
        // Taking Excel file from the testData folder
        String path = ".\\testData\\Login_TestData2.xlsx"; 

        // Creating an object for ExcelUtility
        ExcelUtility xlutil = new ExcelUtility(path);

        // Getting the total rows and columns from the Excel sheet
        int totalrows = xlutil.getRowCount("Sheet1");
        int totalcols = xlutil.getCellCount("Sheet1", 1);

        // Creating a two-dimensional array to store the data
        String logindata[][] = new String[totalrows][totalcols];

        // Reading the data from Excel and storing it in the 2D array
        for (int i = 1; i <= totalrows; i++) { // Start from 1 (assuming row 0 is a header)
            for (int j = 0; j < totalcols; j++) { // Columns start from 0
                logindata[i - 1][j] = xlutil.getCellData("Sheet1", i, j); // Adjust index for array (i-1)
            }
        }

        // Returning the 2D array
        return logindata;
    }
}

