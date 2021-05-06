package KampOdevECommerceBackEnd.business.concretes;

import KampOdevECommerceBackEnd.business.abstracts.VerifiedApplicantService;
import KampOdevECommerceBackEnd.dataAccess.concretes.VerifiedApplicantDao;
import KampOdevECommerceBackEnd.entities.concretes.Applicant;

public class VerifiedApplicantManager extends VerifiedApplicantDao implements VerifiedApplicantService{
	
	@Override
	public boolean isVerified(Applicant applicant) {
		return super.isVerified(applicant);
	}	
	
	@Override
	public boolean sentEmail(Applicant applicant) {
		if (isVerified(applicant)) {
			System.out.println("Lutfen kaydinizi doðrulayin");
			return true;
		}else {
			System.out.println("Bilgileriniz hatali. Tekrar deneyin.");
			return false;
		}		
	}
	
	@Override
	public boolean isEmailAnswered(Applicant applicant) {
		System.out.println("Dogrulama bekleniyor...");
		return true;
	}

	@Override
	public boolean add(Applicant applicant) {
		if(sentEmail(applicant) && isEmailAnswered(applicant)) {
			System.out.println("Uyelik kabul edilldi.");
			return true;
		}
		return false;
	}

	@Override
	public void feedback(Applicant applicant) {
		System.out.println("Hata loglandi.");
	}
}
