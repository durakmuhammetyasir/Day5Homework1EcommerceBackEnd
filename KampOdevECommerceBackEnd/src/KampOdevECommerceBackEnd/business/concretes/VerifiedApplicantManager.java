package KampOdevECommerceBackEnd.business.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import KampOdevECommerceBackEnd.business.abstracts.VerifiedApplicantService;
import KampOdevECommerceBackEnd.core.AccessService;
import KampOdevECommerceBackEnd.dataAccess.abstracts.AppUserDao;
import KampOdevECommerceBackEnd.dataAccess.abstracts.ApplicantDao;
import KampOdevECommerceBackEnd.dataAccess.concretes.VerifiedApplicantDao;
import KampOdevECommerceBackEnd.entities.concretes.AppUser;
import KampOdevECommerceBackEnd.entities.concretes.Applicant;

public class VerifiedApplicantManager extends VerifiedApplicantDao implements VerifiedApplicantService{
	
	private ApplicantDao applicantDao;
	private AccessService accessService;
	

	public VerifiedApplicantManager() {
		
	}

	public VerifiedApplicantManager(ApplicantDao applicantDao, AccessService accessService) {
		super();
		this.applicantDao = applicantDao;
		this.accessService = accessService;		
	}
	
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
	public boolean isRegistered(Applicant applicant) {
		if(add(applicant)) {
			System.out.println("Yeni uye sisteme eklendi :" + applicant.getFirstName());
			return true;
		}else {		
			return false;
		}
	}
	
	@Override
	public void save(Applicant applicant) {
		if (isRegistered(applicant)) {
			System.out.println("Sistemimize Hoþ Geldiniz.");
		}
	}
	@Override
	public void access(Applicant applicant) {
		String data1 = applicant.getEmail();	       
		String regex = "\\b@gmail\\b";
		 
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(data1);
		if (matcher.find())
		{
			this.accessService.AccessToSystem(applicant.getFirstName());
		}		
		if (isVerified(applicant)) {
			this.applicantDao.access(applicant);
			
		}else {
			System.out.println("Sistemde kaydiniz yok.");
		}
	}	

	@Override
	public void feedback(Applicant applicant) {
		System.out.println("Hata loglandi.");
	}
	
	
}
