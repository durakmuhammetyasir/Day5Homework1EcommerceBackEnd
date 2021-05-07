package KampOdevECommerceBackEnd.dataAccess.abstracts;

import java.util.List;

import KampOdevECommerceBackEnd.entities.concretes.AppUser;

public interface AppUserDao {
	void logIn (AppUser appUser);
	void update(AppUser appUser);
	void delete(AppUser appUser);
	AppUser get(int id);
	List<AppUser> getAll();

}
