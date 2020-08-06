package HomeQuarantineTests.rwexcel;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadWriteExcelData {

	public static void processTemplateData() throws IOException {

		List downloadlist = new ArrayList();
		List uploadHheaderList = null;
		List uploadFirstRowList = new ArrayList();

		downloadlist = ReadExcelData.processTemplateData("Request_File_swasth-to-sp", "Search", "LastRow", true);
//		uploadHheaderList = ReadExcelDataDownload.processTemplateData("Patient Onboarding Details - SP to Swasth", "Search", "FirstRow",false);
		//uploadFirstRowList = ReadExcelDataDownload.processTemplateData("Upload -SP to Swasth.xlsx", "Direct", "LastRow",true);

		uploadHheaderList = new ArrayList(Arrays.asList("Name of Patient", "Mobile Number", "DOB(dd/mm/yyyy)", "AGE", "Platform Reference Number", "Gender", "Address", "ZONE", "Pincode", "Language", "Patient Condition", "Upload reference", "Medical reference", "Onboarding call date(dd/mm/yyyy)", "call Connected", "Eligible for Home quarantine", "Reason non-eligibility", "Patient Consent", "Onboarding Calls", "Reason for admission", "Covid test result", "Date of Covid test result(dd/mm/yyyy)", "Other conditions and ongoing medications", "Caregiver full name", "Caregiver contact number", "Caregiver relationship"));
		uploadFirstRowList = new ArrayList(Arrays.asList( "13/07/2020", "Yes", "Yes", "", "Yes", "Yes", "Mild_Asymptomatic", "Positive", "10/07/2020", "Good", "God", "1234567895", "Myself"));

		System.out.println("downloadlist:"+ downloadlist);
		System.out.println("uploadHheaderList:" +uploadHheaderList);
		System.out.println("uploadFirstRowList:" + uploadFirstRowList);

		List uploadMergeList = new ArrayList();
		int i = 0;
		for(i = 0; i < 13; i++){
//			System.out.println(i);
			uploadMergeList.add(downloadlist.get(i));

		}
		System.out.println("1:" +uploadMergeList);
//		for(int j = i; j <= uploadFirstRowList.size(); j++){
//			uploadMergeList.add(uploadFirstRowList.get(j));
//		}
		uploadMergeList.addAll(uploadFirstRowList);
		System.out.println("2:" +uploadMergeList);

		WriteExcelData.processTemplateWrite(uploadHheaderList, uploadMergeList);

	}


	
	public static void main(String[] args) throws IOException {
		
		ReadWriteExcelData.processTemplateData();
		
	}

}
