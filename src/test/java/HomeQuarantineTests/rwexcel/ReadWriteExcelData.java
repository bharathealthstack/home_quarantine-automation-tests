package HomeQuarantineTests.rwexcel;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class ReadWriteExcelData {

	public static void processTemplateData() throws IOException {

		List downloadlist = new ArrayList();
		List uploadHheaderList = null;
		List uploadFirstRowList = new ArrayList();

		downloadlist = ReadExcelData.processTemplateData("Request_File_swasth-to-sp", "Search", "LastRow", true);
		uploadHheaderList = new ArrayList(Arrays.asList("Name of Patient", "Mobile Number", "DOB(dd/mm/yyyy)", "AGE", "Platform Reference Number", "Gender", "Address", "ZONE", "Pincode", "Language", "Patient Condition", "Upload reference", "Medical reference", "Onboarding call date(dd/mm/yyyy)", "call Connected", "Eligible for Home quarantine", "Reason non-eligibility", "Patient Consent", "Onboarding Calls", "Reason for admission", "Covid test result", "Date of Covid test result(dd/mm/yyyy)", "Other conditions and ongoing medications", "Caregiver full name", "Caregiver contact number", "Caregiver relationship"));
		uploadFirstRowList = new ArrayList(Arrays.asList( getCurrentDate(), "Yes", "Yes", "", "Yes", "Yes", "Mild_Asymptomatic", "Positive", "10/07/2020", "Good", "God", "1234567895", "Myself"));

		System.out.println("downloadlist:"+ downloadlist);
		System.out.println("uploadHheaderList:" +uploadHheaderList);
		System.out.println("uploadFirstRowList:" + uploadFirstRowList);

		List uploadMergeList = new ArrayList();
		int i = 0;
		for(i = 0; i < 13; i++){
			uploadMergeList.add(downloadlist.get(i));

		}
		System.out.println("1:" +uploadMergeList);
		uploadMergeList.addAll(uploadFirstRowList);
		System.out.println("2:" +uploadMergeList);

		WriteExcelData.processTemplateWrite(uploadHheaderList, uploadMergeList);

	}


	public static void processTemplateDataPatients() throws IOException {

		List downloadlist = new ArrayList();
		List uploadHheaderList = null;
		List uploadFirstRowList = new ArrayList();


		downloadlist = ReadExcelData.processTemplateData("Patient-tracker-bulk-download", "Search", "LastRow", true);

		uploadHheaderList = new ArrayList(Arrays.asList("PATIENT_NAME","MOBILE_NUMBER","PATIENT_DOB","PLATFORM_REF_NUMBER","GENDER","ADDRESS","ZONE","ONBOARDING","MEDICAL_REFERENCE_NUMBER","MONITORING_DATE","CALL_CONNECTED","CONSULTATION_BY","NURSE_DOCTOR_NAME","DOCTOR_NAME","SPOKEN_TO","SPOKEN_TO_NAME","PATIENT_CONDITION","PATIENT_OVERALL_VITALS","DOC_ATTENTION_NEEDED","NEED_FOR_DISCHARGE","FAMILY_MEMBER_SYMPTOMS","ESSENTIAL_SUPPLIES_AVAILABLE","MEDICAL_SUPPLIES_AVILABLE","FEVER","BREATHLESSNESS","FATIGUE","DRY_COUGH","OTHER_SYMPTOMS","ACHES_PAINS","SORE_THROAT","DIARRHOEA","CONJUNCTIVITIS","HEADACHE","LOSS_OF_TASTE_OR_SMELL","RASH_ON_SKIN","VOMITTING","CHEST_PAIN","LOSS_OF_SPEECH","TEMPERATURE","RESPIRATORY_RATE","OXYGEN","BLOOD_PRESSURE","PULSE_RATE","PATIENT_STATUS"));
		uploadFirstRowList = new ArrayList(Arrays.asList("10/08/2020","Yes","Nurse","Mina","Vivekanand","Ramesh","Caregiver","Improving","Stable","Immediate","DISCHARGE_CHECK_UP","Yes","Yes","Yes","Mild","Moderate","Severe","Mild","","","","","","","","","","Yes","Yes","","","","","","ACTIVE"));

		System.out.println("downloadlist:"+ downloadlist);
		downloadlist.remove(downloadlist.size()-1);
		System.out.println("Final download list:"+ downloadlist);
		System.out.println("uploadHheaderList:" +uploadHheaderList);
		System.out.println("uploadFirstRowList:" + uploadFirstRowList);

		List uploadMergeList = new ArrayList();
		int i = 0;
		for(i = 0; i < downloadlist.size(); i++){
			uploadMergeList.add(downloadlist.get(i));

		}
		System.out.println("1:" +uploadMergeList);
		uploadMergeList.addAll(uploadFirstRowList);
		System.out.println("2:" +uploadMergeList);

		WriteExcelData.processTemplateWritePatient(uploadHheaderList, uploadMergeList);

	}


	public static String getCurrentDate()  {
		Date date = new Date();

		SimpleDateFormat format = new SimpleDateFormat("dd/MM/YYYY");
		String newDate = format.format(date);
		return newDate;
	}

	public static void main(String[] args)  {
		System.out.println(ReadWriteExcelData.getCurrentDate());

	}

}
