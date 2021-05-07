package KampOdevECommerceBackEnd.core;

import KampOdevECommerceBackEnd.gmailAccess.GmailAccessManager;

public class GmailAccessManagerAdapter implements AccessService{
	@Override
	public void AccessToSystem(String message) {
		GmailAccessManager manager = new GmailAccessManager();
		manager.access(message);
		
	}

}
