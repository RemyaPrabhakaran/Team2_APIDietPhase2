package utilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class ExcelUtilities {

	public static List<Map<String, String>> getTestDataInMap(String testDataFile, String sheetName, String feature) {
		
		List<Map<String, String>> testDataList = new ArrayList<Map<String,String>>();
		String query = null;
		query = String.format("SELECT * FROM %s WHERE Feature = '%s'", sheetName,feature);
		Fillo fillo = new Fillo();
		Connection conn = null;
		Recordset recordSet = null;
		
		try {
			conn = fillo.getConnection(testDataFile);
			System.out.println("*************Connected************");
			recordSet = conn.executeQuery(query);
			
			while (recordSet.next())
			{
				Map<String, String> dataRow = new HashMap<>();
	                for (String field : recordSet.getFieldNames()) {
	                    dataRow.put(field, recordSet.getField(field));
	                }
	                testDataList.add(dataRow);
	            }
			
		} catch (FilloException e) {
			// TODO Auto-generated catch block
			
		}
		conn.close();
		
		return testDataList;
		
	}
	

	
}
