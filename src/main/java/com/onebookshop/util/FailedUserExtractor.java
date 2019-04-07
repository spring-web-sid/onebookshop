package com.onebookshop.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.util.Strings;

public class FailedUserExtractor {

	public static void main(String[] args) {

		String location = "C:\\Users\\SiddharthaKLet\\Desktop\\faild user log\\faileduser.txt";
		String matchStr = "Failed user login id :";
		String formatBeforeDate = "INFO   | jvm 1    | main    |";

		File file = new File(location);
		BufferedReader reader = null;
		List<String> userDateList = new ArrayList<>();
		
		try {
			reader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null) {
				if (line.indexOf(matchStr) != -1 && line.indexOf(formatBeforeDate) != -1) {
					String user = line.substring(line.lastIndexOf(matchStr));
					user = user.replace(matchStr, "").trim();

					String date = line.replace(formatBeforeDate, "");
					date = date.substring(0, date.indexOf("|"));

					// userMap.put(user, date);
					if (!Strings.isBlank(user)) {
						/*userList.add(user);*/
						userDateList.add(date +"\t"+ user);
						//dateAndTimeUserMap.put(date +"\t"+ user, user);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		//dateAndTimeUserMap.entrySet().forEach(data -> System.out.println(data.getKey()+"\t"+data.getValue()));
		//userDateList.forEach(data -> System.out.println(data));
		
		String phone = "133-123-1234 x123";
		System.out.println(isValid(phone));
	}

	public static boolean isValid(String phoneNo) {
		if(phoneNo == null){
			return false;
		}
		//validate phone numbers of format "1234567890"
        if (phoneNo.matches("\\d{10}")) return true;
        else if(phoneNo.matches("\\d{3}-\\d{3}-\\d{4}\\s(x|(ext))\\d{3,5}")) return true;
        //validating phone number where area code i
        else return false;

}
}
