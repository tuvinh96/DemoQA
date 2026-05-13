package common;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;

public class Utils {
	public String[][] readDataFromCSV(String fileName) {
		String[][] dataTable = null;
		String csvFilePath = System.getProperty("user.dir") + "\\testcase\\TestData\\" + fileName;
		FileReader fileReader;
		try {
			fileReader = new FileReader(csvFilePath);
			CSVReader reader = new CSVReader(fileReader);
//			List <String[]> rows = reader.readAll();
			reader.skip(1);
			List <String[]> rows = new ArrayList<String[]>();
			String[] line;
			while ((line = reader.readNext())!=null) {
				rows.add(line);
				
			}
			dataTable = rows.toArray(new String [0][]);
		} catch (Exception e) {
			System.out.println("CSV file not found");
			e.printStackTrace();
		}
		return dataTable;
	}
}
