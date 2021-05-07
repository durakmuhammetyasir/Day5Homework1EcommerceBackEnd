package KampOdevECommerceBackEnd.dataAccess.concretes;

import java.util.List;

import KampOdevECommerceBackEnd.dataAccess.abstracts.AppUserDao;
import KampOdevECommerceBackEnd.entities.concretes.AppUser;

public class AbcAppUserDao implements AppUserDao{
	
	@Override
	public void logIn(AppUser appUser) {
		String emailControl = appUser.getEmail();
		String passwordControl = appUser.getPassword();
		String[] emails = new String[5];
		emails[0] = "alice@example.com";
		emails[1] = "alice.bob@example.com";
	    emails[2] = "alice@example.me.org";
	    emails[3] = "okul1@okul.com";
	    emails[4] = "okul@okul.com";
	    String[] passwords = new String[5];
	    
	    passwords[0] ="pass12A&";
	    passwords[1] ="pass123A&";
	    passwords[2] ="pass1234A&";
	    passwords[3] ="klh123%&AS";
	    passwords[4] ="asd$FAS78";
	    boolean isFound =false;
	    for (int i = 0; i < emails.length; i++) {
			if(emails[i]==emailControl) {
				for (int j = 0; j < passwords.length; j++) {
			    	if(passwords[j]==passwordControl) {
			    		System.out.println("Abc ile sisteme giris yapildi : " + appUser.getFirstName());
			    		isFound = true;
			    		break;			    	
			    	}
				}
			}
		}if (!isFound) {
			System.out.println("Kayit bulunamadi.");
		}
				
	}	

	@Override
	public void update(AppUser appUser) {		
		
	}

	@Override
	public void delete(AppUser appUser) {
		
	}

	@Override
	public AppUser get(int id) {
		return null;
	}

	@Override
	public List<AppUser> getAll() {
		return null;
	}
}


	