package KampOdevECommerceBackEnd.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import KampOdevECommerceBackEnd.dataAccess.abstracts.ApplicantDao;
import KampOdevECommerceBackEnd.entities.concretes.Applicant;

public class VerifiedApplicantDao implements ApplicantDao{
	
	@Override
	public boolean checkFirstName(Applicant applicant) {
		Pattern pattern1 = Pattern.compile("^(?=.*[A-Z].*[a-z]{1,}).{2,}$");
		String _firstName = applicant.getFirstName();
	    Matcher matcher = pattern1.matcher(_firstName);
		boolean matchFound = matcher.find();
	    if(matchFound) {
	    	return true;
	    } else {
	    	return false;
	    }
	}

	@Override
	public boolean checkLastName(Applicant applicant) {
		Pattern pattern2 = Pattern.compile("^(?=.*[A-Z].*[a-z]{1,}).{2,}$");
		String _lastName = applicant.getLastName();
		Matcher matcher = pattern2.matcher(_lastName);
	    boolean matchFound = matcher.find();
	    if(matchFound) {
	    	return true;
	    } else {
	    	return false;
	    }
	}
	
	@Override
	public boolean checkEmail(Applicant applicant) {
		String line3 =applicant.getEmail();
		String pattern3 = "\\b[\\w.%-]+@[-,\\w]+\\.[A-Za-z]{2,4}\\b";
		Pattern r = Pattern.compile(pattern3);
		Matcher m = r.matcher(line3);
		if(m.find()) {
			return true;
		}else {
			return false;
		}
	}
	
	
	@Override
	public boolean checkUsedEmail(Applicant applicant) {
		String value = applicant.getEmail();
		List<String> emails = new ArrayList<>();
		emails.add("alice@example.com");
		emails.add("alice.bob@example.com");
	    emails.add("alice@example.me.org");
	    boolean isExisted = emails.contains(value);
	    if (!isExisted && checkEmail(applicant)) {
			emails.add(value);
			return true;
		}else {
			return false;
		}
	}	

	@Override
	public boolean checkPassword(Applicant applicant) {
		Pattern pattern5 = Pattern.compile("^(?=.*[A-Z]{1,})(?=.*[!@#$&*]{1,})(?=.*[0-9]{1,})(?=.*[a-z]{1,}).{6,}$");
	    Matcher matcher = pattern5.matcher(applicant.getPassword());
	    boolean matchFound = matcher.find();
	    if(matchFound) {
	    	return true;
	    } else {
	    	return false;
	    }
		
	}

	@Override
	public boolean isVerified(Applicant applicant) {
		if(checkFirstName(applicant)&&checkLastName(applicant)&& checkUsedEmail(applicant) &&checkPassword(applicant)) {
			return true;
		}else {
			return false;
		}
	}

	
}

