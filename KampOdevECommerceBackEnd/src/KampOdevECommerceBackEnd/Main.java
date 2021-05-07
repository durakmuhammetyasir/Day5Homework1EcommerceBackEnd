package KampOdevECommerceBackEnd;

import KampOdevECommerceBackEnd.business.abstracts.AppUserService;
import KampOdevECommerceBackEnd.business.abstracts.VerifiedApplicantService;
import KampOdevECommerceBackEnd.business.concretes.AppUserManager;
import KampOdevECommerceBackEnd.business.concretes.VerifiedApplicantManager;
import KampOdevECommerceBackEnd.core.GmailAccessManagerAdapter;
import KampOdevECommerceBackEnd.dataAccess.concretes.AbcAppUserDao;
import KampOdevECommerceBackEnd.dataAccess.concretes.VerifiedApplicantDao;
import KampOdevECommerceBackEnd.entities.concretes.AppUser;
import KampOdevECommerceBackEnd.entities.concretes.Applicant;

public class Main {

	public static void main(String[] args) {
		
		//Isim ve soy isim buyuk harle baþlayacak ve en az 2 harfli olacak þekilde denetlendi
		//email default@default.abc
		//parola en az 6 karakter uzunlugunda en az birer tane buyuk ve kucuk harf,ozel karakter ve numara(0-9) içeriyor.
		Applicant applicant1 = new Applicant("Seda", "Kýzýl", "okul@okul.com", "asd$FAS78");
		Applicant applicant2 = new Applicant("Arda", "Kýrmýzý", "arda@example.org", "432wer&&AS");
		Applicant applicant3 = new Applicant("Fik","Ret", "s@s.com", "y3&$*22A");
		Applicant applicant4 = new Applicant("Fi","Ko", "fiko@example.com", "y3&$*22A");
		//Ilk dort true veriyor, geri kalanlar false veriyor
		//Isim soyisim gecersiz oldugu icin hata mesaji verildi
		Applicant applicant5 = new Applicant("Fi","ko", "fiko@example.com", "y3&$*22A");
		Applicant applicant6 = new Applicant("fi","Ko", "fiko@example.com", "y3&$*22A");
		//Email gecersiz oldugu icin hata mesaji verildi
		Applicant applicant7 = new Applicant("Fi","Ko", "fiko.example.com", "y3&$*22A");
		Applicant applicant8 = new Applicant("Fi","Ko", "fiko@examplecom", "y3&$*22A");
		Applicant applicant9 = new Applicant("Fi","Ko", "@example.com", "y3&$*22A");
		Applicant applicant10 = new Applicant("Fi","Ko", "fiko@example.c", "y3&$*22A");
		//Sifre gecersiz oldugu icin hata mesaji verildi
		Applicant applicant12 = new Applicant("Fi","Ko", "fiko@example.com", "3&$*22A");	
		Applicant applicant13 = new Applicant("Fi","Ko", "fiko@example.com", "y3&$*22");
		Applicant applicant14 = new Applicant("Fi","Ko", "fiko@example.com", "y3224A");	
		Applicant applicant15 = new Applicant("Fi","Ko", "fiko@example.com", "y&$*AB");
		Applicant applicant16 = new Applicant("Fi","Ko", "fiko@example.com", "y3$2A");
		//Sistemde olan email ile ayný oldugu icin hata mesaji verildi
		Applicant applicant11 = new Applicant("Alice", "Race", "alice@example.com", "123qwe%&AA" );
		//gmail hesabi ile uyelik yapildi
		Applicant applicant17 = new Applicant("Ak", "e", "alice@gmail.com", "123qwe%&AA" );
		Applicant applicant18 = new Applicant("A", "R", "alic@gmail.com", "123qwe%&AA" );
		Applicant applicant19 = new Applicant("Av", "e", "alicen@gmail.com", "123qwe%&AA" );
		
		VerifiedApplicantDao applicantObject = new VerifiedApplicantDao();
		System.out.println(applicantObject.isVerified(applicant1));
		System.out.println(applicantObject.isVerified(applicant2));
		System.out.println(applicantObject.isVerified(applicant3));
		System.out.println(applicantObject.isVerified(applicant4));
		System.out.println(applicantObject.isVerified(applicant5));
		System.out.println(applicantObject.isVerified(applicant6));
		System.out.println(applicantObject.isVerified(applicant7));
		System.out.println(applicantObject.isVerified(applicant8));
		System.out.println(applicantObject.isVerified(applicant9));
		System.out.println(applicantObject.isVerified(applicant10));
		System.out.println(applicantObject.isVerified(applicant11));
		System.out.println(applicantObject.isVerified(applicant12));
		System.out.println(applicantObject.isVerified(applicant13));
		System.out.println(applicantObject.isVerified(applicant14));
		System.out.println(applicantObject.isVerified(applicant15));
		System.out.println(applicantObject.isVerified(applicant16));
		System.out.println("__________________________________");
		
		//Dogrulama maili ,Butonun týklanmasý, uyeligin kabul edilmesi ve uyelik aktivasyonu simule edildi.
		//Bilgileri yanlis olanlara hata bildirimi yapildi.
		VerifiedApplicantManager verifiedApplicant = new VerifiedApplicantManager();
		System.out.println(verifiedApplicant.isRegistered(applicant1));
		System.out.println(verifiedApplicant.isRegistered(applicant2));
		System.out.println(verifiedApplicant.isRegistered(applicant3));
		System.out.println(verifiedApplicant.isRegistered(applicant4));
		System.out.println(verifiedApplicant.isRegistered(applicant5));
		System.out.println(verifiedApplicant.isRegistered(applicant17));
		System.out.println(verifiedApplicant.isRegistered(applicant18));
		System.out.println(verifiedApplicant.isRegistered(applicant19));
		
		System.out.println("____________________________________");
		
		//Sistemde uyelik sartlarýný yerine getirenlere	uyelik hakký verildi. 
		//Sartlarý yerine getirmeyip gmail hesabi olanlara uyelik hakký verildi.
		VerifiedApplicantService verifiedApplicantService = new VerifiedApplicantManager(new VerifiedApplicantDao(), new GmailAccessManagerAdapter());
		verifiedApplicantService.access(applicant1);
		verifiedApplicantService.access(applicant2);
		verifiedApplicantService.access(applicant3);
		verifiedApplicantService.access(applicant4);
		verifiedApplicantService.access(applicant5);
		verifiedApplicantService.access(applicant17);
		verifiedApplicantService.access(applicant18);
		verifiedApplicantService.access(applicant19);
		
		System.out.println("___________________________");
		
		
		//Bu kayýt sistemde yok giris yapamaz
		AppUser appUser1 = new AppUser(1,"Ali","Sari","okul1@oku.com","klh123%&AS","alico");
		//Bu kayýt var sisteme giris izni var
		AppUser appUser2 = new AppUser(1,"Ali","Sari","okul1@okul.com","klh123%&AS","alico");
		AppUserService appUserService = new AppUserManager(new AbcAppUserDao());
		appUserService.logIn(appUser1);
		appUserService.logIn(appUser2);
		
		//Sadece email ve password bilgisi kontrol edilerek sisteme giris yapildi.
		AppUser appUser3 = new AppUser();
		appUser3.setEmail("okul@okul.com");
		appUser3.setPassword("asd$FAS78");
		appUserService.logIn(appUser3);
	}
}
