package KampOdevECommerceBackEnd.business.abstracts;

import KampOdevECommerceBackEnd.entities.concretes.AppUser;
import KampOdevECommerceBackEnd.entities.concretes.Applicant;

public interface VerifiedApplicantService {
	boolean sentEmail(Applicant applicant);
	boolean isEmailAnswered(Applicant applicant);
	boolean add(Applicant applicant);
	boolean isRegistered(Applicant applicant);
	void save(Applicant applicant);
	void feedback(Applicant applicant);
	void access(Applicant applicant);
}
