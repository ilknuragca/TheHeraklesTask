package utilities;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelUtil {

    private Workbook workBook;
    private Sheet workSheet;
    private String path;

    public ExcelUtil(String path,String sheetName){
        //this constructor is to open and access the excel file
        this.path=path;
        try {
            //opening the excel file
            FileInputStream fileInputStream = new FileInputStream(path);
            //accessing the workbook
            workBook=WorkbookFactory.create(fileInputStream);
            ///getting the worksheet
            workSheet=workBook.getSheet(sheetName);

        }catch(Exception e){
            //e.printStackTrace();
            throw new RuntimeException(e); //the specified detail message and cause
        }

    }


   //read column
    public  List<String> getColumnsNames(){
        List<String> columns = new ArrayList<>();

        /*
        Row row=sheet.getRow(x);
        Cell cell= row.getCell(y);
        */

        //going to the first row and reading each column one by one
        for(Cell cell: workSheet.getRow(0)){
            columns.add(cell.toString());
        }
        return columns;
    }

    //getting the last row number
    public int rowCount(){
        return workSheet.getLastRowNum()+1; //index start at 0 so adding 1 to get the actual count
    }


    //getting the number of columns in a specific single row
    public int columnCount(){
        return workSheet.getRow(0).getLastCellNum();
    }

    //When you enter row and column number, then you get the data
      public String getCellData(int rowNum, int colNum){
        Cell cell;
        try{
            cell=workSheet.getRow(rowNum).getCell(colNum);
            String cellData=cell.toString();
            return cellData;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
      }

    //This is a list of map of string.
    // This takes the data as string and will return the data as a Map of String
    public List<Map<String,String>> getDataList(){
        //get all columns
        List<String> columns=getColumnsNames();
         //method will return this
        List<Map<String,String>> data= new ArrayList<>();
        for(int i=1;i<rowCount();i++){
            //get each row
            Row row=workSheet.getRow(i);

            // creating map of the row using the column and value
            // key=column, value=cell
            Map<String,String> rowMap= new HashMap<String,String>();
            for(Cell cell:row){
                int columnIndex= cell.getColumnIndex();
                rowMap.put(columns.get(columnIndex) , cell.toString());
            }
            data.add(rowMap);
        }
        return data;
    }
}
