package KampOdevECommerceBackEnd.business.abstracts;

import KampOdevECommerceBackEnd.entities.concretes.Applicant;

public interface VerifiedApplicantService {
	boolean sentEmail(Applicant applicant);
	boolean isEmailAnswered(Applicant applicant);
	boolean add(Applicant applicant);
	void feedback(Applicant applicant);
	

}
