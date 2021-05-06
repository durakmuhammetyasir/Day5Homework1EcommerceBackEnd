package KampOdevECommerceBackEnd.dataAccess.abstracts;

import KampOdevECommerceBackEnd.entities.concretes.Applicant;

public interface ApplicantDao {
	boolean checkFirstName(Applicant applicant);
	boolean checkLastName(Applicant applicant);
	boolean checkEmail(Applicant applicant);
	boolean checkUsedEmail(Applicant applicant);
	boolean checkPassword(Applicant applicant);
	boolean isVerified(Applicant applicant);
	
	
}
