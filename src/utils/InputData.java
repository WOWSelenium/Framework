package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class InputData {
	
	public static Collection<String[]> getTestData(String fileName) throws IOException{
		List<String[]> records = new ArrayList<String[]>();
		String record;
		
		BufferedReader file = new BufferedReader (new FileReader (fileName));
		
		while ((record = file.readLine())!=null){
			if(record.trim().length()==0){
				break;
			}
			String fields[] = record.split(",");
			records.add(fields);
		}
		file.close();
		return records;
	}
	
	public static Collection<String[]> getTestDataWithCommas(String fileName) throws IOException{
		List<String[]> records = new ArrayList<String[]>();
		String record;
		//new FileReader (fileName)
		BufferedReader file = new BufferedReader(new FileReader (fileName));
		
		while ((record = file.readLine())!=null){
			
			String fields[] = record.split(",");
			
			//Routine to fix the comma value used in the face amount
			
			String tf = "";
			boolean q = false;
			List<String> fieldList = new ArrayList<String>();
			for (int i = 0; i < fields.length; i++) {
				String f = fields[i];
				if (f.startsWith("\"")) {
					tf += f.substring(1) + ",";
					q = true;
					continue;
				} if (q) {
					tf += f;
					if (f.endsWith("\"")) {
						q = false;
						fieldList.add(tf.substring(0, tf.length() - 1));
						tf = "";
					}
				} else {
					fieldList.add(f);
				}
				
			}
			String [] fieldArray = new String[fieldList.size()];
			int i = 0;
			for (String string : fieldList) {
				fieldArray[i++] = string;
			}
			records.add(fieldArray);
		}
		file.close();
		return records;
	}

	public static List<Map<String,String>> getTestDataMap(String csvFile) throws IOException{
		
		List<Map<String,String>> csvLines = new ArrayList<Map<String,String>>();
		
		BufferedReader br = null;
	    String line = "";
	    String csvDelimiter = ",";

	    try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
            	if (line.trim().length() == 0) {
            		break;
            	}
                // use comma as separator
                String[] columnsInLine = line.split(csvDelimiter);
				Map<String, String> nameValuePairs = new LinkedHashMap<>();
				int pos = 0;
                for (int i = 0; i < columnsInLine.length - 1; i+=2) {
					nameValuePairs.put(columnsInLine[pos++], columnsInLine[pos++]);
				}
				csvLines.add(nameValuePairs);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
		return csvLines;
	}
	
	public static List<Element> getTestData4Ele(String csvFile) throws IOException{
		List<Element> csvLines = new ArrayList<>();  //Element
		
		BufferedReader br = null;
	    String line = "";
	    String csvDelimiter = ",";
	    
	    try{
	    	br = new BufferedReader(new FileReader (csvFile));
	    	while ((line = br.readLine())!=null){
	    		if (line.trim().length()==0){
	    			break;
	    		}
	    		// use comma as separator
	    		String[] columnsInLine = line.split(csvDelimiter);
	    		List<Element> eachElement = new ArrayList<>();  //<Element>
	    		int pos = 0;
	    		for (int i=0; i < columnsInLine.length -1; i+=4){
	    			Element individualObj = new Element();
	    			individualObj.setLocatorType(columnsInLine[pos++]);
	    			individualObj.setLocatorValue(columnsInLine[pos++]);
	    			individualObj.setEleValue(columnsInLine[pos++]);
	    			individualObj.setObjType(columnsInLine[pos++]);	    			
	    			eachElement.add(individualObj);
	    			individualObj = null;
	    		}
	    		csvLines.addAll(eachElement);
	    	 }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
		return csvLines;
	}

}
