package KampOdevECommerceBackEnd.business.abstracts;

import java.util.List;

import KampOdevECommerceBackEnd.entities.concretes.AppUser;
import KampOdevECommerceBackEnd.entities.concretes.Applicant;

public interface AppUserService {
	void logIn(AppUser appUser);
	List<AppUser> getAll();
	boolean isRegistered(Applicant applicant);
	void save(Applicant applicant);

}
