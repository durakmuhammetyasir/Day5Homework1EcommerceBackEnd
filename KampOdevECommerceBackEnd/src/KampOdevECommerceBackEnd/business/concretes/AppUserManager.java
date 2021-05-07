package KampOdevECommerceBackEnd.business.concretes;

import KampOdevECommerceBackEnd.business.abstracts.AppUserService;
import KampOdevECommerceBackEnd.dataAccess.abstracts.AppUserDao;
import KampOdevECommerceBackEnd.entities.concretes.AppUser;

public class AppUserManager implements AppUserService{
	
	private AppUserDao appUserDao;
	

	public AppUserManager(AppUserDao appUserDao) {
		super();
		this.appUserDao = appUserDao;
	}


	@Override
	public void logIn(AppUser appUser) {
		this.appUserDao.logIn(appUser);
		
	}

	
}
