package KampOdevECommerceBackEnd.business.concretes;

import java.util.List;

import KampOdevECommerceBackEnd.business.abstracts.AppUserService;
import KampOdevECommerceBackEnd.entities.concretes.AppUser;
import KampOdevECommerceBackEnd.entities.concretes.Applicant;

public class AppUserManager extends VerifiedApplicantManager implements AppUserService{
	

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
	public List<AppUser> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void logIn(AppUser appUser) {
				
	}

	

	
}
