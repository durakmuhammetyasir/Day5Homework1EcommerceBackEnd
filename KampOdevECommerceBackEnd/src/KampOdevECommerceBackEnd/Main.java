package KampOdevECommerceBackEnd;

import KampOdevECommerceBackEnd.business.concretes.AppUserManager;
import KampOdevECommerceBackEnd.business.concretes.VerifiedApplicantManager;
import KampOdevECommerceBackEnd.dataAccess.concretes.VerifiedApplicantDao;
import KampOdevECommerceBackEnd.entities.concretes.Applicant;

public class Main {

	public static void main(String[] args) {
		
		//�sim ve soy isim B�y�k Harle ba�layacak ve en az 2 harfli olacak
		//email default@default.com
		//en az 6 karakter uzunlu�unda en az birer tane b�y�k ve k���k harf,�zel karakter ve numara(0-9) olacak
		Applicant applicant1 = new Applicant("Seda", "K�z�l", "okul@okul.com", "asd$FAS78");
		Applicant applicant2 = new Applicant("Arda", "K�rm�z�", "arda@example.org", "432wer&&AS");
		Applicant applicant3 = new Applicant("Fik","Ret", "s@s.com", "y3&$*22A");
		Applicant applicant4 = new Applicant("Fi","Ko", "fiko@example.com", "y3&$*22A");
		//�lk d�rt true veriyor geri kalanlar false veriyor
		Applicant applicant5 = new Applicant("Fi","ko", "fiko@example.com", "y3&$*22A");
		Applicant applicant6 = new Applicant("fi","Ko", "fiko@example.com", "y3&$*22A");
		Applicant applicant7 = new Applicant("Fi","Ko", "fiko.example.com", "y3&$*22A");
		Applicant applicant8 = new Applicant("Fi","Ko", "fiko@examplecom", "y3&$*22A");
		Applicant applicant9 = new Applicant("Fi","Ko", "@example.com", "y3&$*22A");
		Applicant applicant11 = new Applicant("Fi","Ko", "fiko@example.c", "y3&$*22A");
		Applicant applicant12 = new Applicant("Fi","Ko", "fiko@example.com", "3&$*22A");	
		Applicant applicant13 = new Applicant("Fi","Ko", "fiko@example.com", "y3&$*22");
		Applicant applicant14 = new Applicant("Fi","Ko", "fiko@example.com", "y3224A");	
		Applicant applicant15 = new Applicant("Fi","Ko", "fiko@example.com", "y&$*AB");
		Applicant applicant16 = new Applicant("Fi","Ko", "fiko@example.com", "y3$2A");
		
		VerifiedApplicantDao verifiedApp = new VerifiedApplicantDao();
		System.out.println(verifiedApp.isVerified(applicant1));
		System.out.println(verifiedApp.isVerified(applicant2));
		System.out.println(verifiedApp.isVerified(applicant3));
		System.out.println(verifiedApp.isVerified(applicant4));
		System.out.println(verifiedApp.isVerified(applicant5));
		System.out.println(verifiedApp.isVerified(applicant6));
		System.out.println(verifiedApp.isVerified(applicant7));
		System.out.println(verifiedApp.isVerified(applicant8));
		System.out.println(verifiedApp.isVerified(applicant9));
		System.out.println(verifiedApp.isVerified(applicant11));
		System.out.println(verifiedApp.isVerified(applicant12));
		System.out.println(verifiedApp.isVerified(applicant13));
		System.out.println(verifiedApp.isVerified(applicant14));
		System.out.println(verifiedApp.isVerified(applicant15));
		System.out.println(verifiedApp.isVerified(applicant16));
		AppUserManager AppUser1 = new AppUserManager();
		System.out.println(AppUser1.isRegistered(applicant1));
		System.out.println(AppUser1.isRegistered(applicant2));
		System.out.println(AppUser1.isRegistered(applicant3));
		System.out.println(AppUser1.isRegistered(applicant4));
		System.out.println(AppUser1.isRegistered(applicant5));		
	}
}
