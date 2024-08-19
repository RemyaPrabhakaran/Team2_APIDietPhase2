//package utilities;
//
//import java.io.IOException;
//
//import org.testng.annotations.DataProvider;
//
//public class DataProviders {
//	
//	@DataProvider(name = "Data")
//	
//	String[][] getAllData() throws IOException {
//	String path = System.getProperty("user.dir")+"src/test/resources/Data/updatePatient_SHEET.xls";
//	
//	XLUtils xl=new XLUtils();
//	
//	int rownum = XLUtils.getRowCount(path, "updateUser");
//	int colnum = XLUtils.getCellCount(path, "updateUser", 1);
//	
//	String progdata[][] = new String[rownum][colnum];
//	for (int i = 1; i <= rownum; i++) 
//	{
//	for (int j = 0; j < colnum; j++) 
//	{
//	progdata[i - 1][j] = XLUtils.getCellData(path, "updateUser", i, j);
//	}
//	}
//	return progdata;
//	}
//	
//	@DataProvider(name="GetuserName")
//	public String[] getUserName()throws IOException
//	{
//		String path = System.getProperty("user.dir")+"src/test/resources/Data/updatePatient_SHEET.xls";
//		
//		//XLUtils xl=new XLUtils();
//		int rownum=XLUtils.getRowCount(path,"updateUser");
//	
//		String[] apidata=new String[rownum];
//		
//		for(int i=1;i<=rownum;i++)
//		{	
//			apidata[i-1]=XLUtils.getCellData(path,"updateUser",  rownum, i);
//		
//		}
//		return apidata;
//	}
//	
//	
//	
////	@DataProvider(name="DELuserNames")
////	public String[] DelUserNames()throws IOException
////	{
////		String path = System.getProperty("user.dir")+"src/test/resources/Data/updatePatient_SHEET.xls";
////		
////		//XLUtils xl=new XLUtils();
////		int rownum=XLUtils.getRowCount(path,"updateUser");
////	
////		String[] apidata=new String[rownum];
////		
////		for(int i=1;i<=rownum;i++)
////		{	
////			apidata[i-1]=XLUtils.getCellData(path,"updateUser",  rownum, i);
////		
////		}
////		return apidata;
//	
//
//	
////	@Test(dataProvider = "progdata")
////	public void post_programs(String progdesc, String progname) 
////	{
////	//Creating Json object to send data along with post request
////	JSONObject requestparams = new JSONObject();
////	// requestparams.put("online", "true");
////	requestparams.put("programDescription", progdesc);
////	requestparams.put("programName", progname);
////	// requestparams.put("programId", "601");
////	Response resp_prog_details = given().auth().basic("Admin", "password").header("Content-Type", "application/json").body(requestparams.toJSONString()).when().post().then().assertThat().statusCode(200).log().all().extract().response();
////	//Asserting the status code is success
////	int statusCode = resp_prog_details.getStatusCode();
////	Assert.assertEquals(statusCode, 200);
////	System.out.println("The response code is "+statusCode);
////	String responseBody = resp_prog_details.getBody().asPrettyString();
////	//Asserting the correct values are posted
////	Assert.assertEquals(responseBody.contains(progdesc), true);
////	Assert.assertEquals(responseBody.contains(progname), true);
////	}
//
//}
//
