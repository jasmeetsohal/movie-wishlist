package com.wishlist.model;

public class User {
	private int uId;

	private String uEmail;

	private String uName;

	private String EMAIL_VERIFICATION_HASH;

	private int EMAIL_VERIFICATION_ATTEMPTS;

	private String uPassword;

	private String STATUS;

	private String CREATED_TIME;

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	public String getuEmail() {
		return uEmail;
	}

	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getEMAIL_VERIFICATION_HASH() {
		return EMAIL_VERIFICATION_HASH;
	}

	public void setEMAIL_VERIFICATION_HASH(String eMAIL_VERIFICATION_HASH) {
		EMAIL_VERIFICATION_HASH = eMAIL_VERIFICATION_HASH;
	}

	public int getEMAIL_VERIFICATION_ATTEMPTS() {
		return EMAIL_VERIFICATION_ATTEMPTS;
	}

	public void setEMAIL_VERIFICATION_ATTEMPTS(int eMAIL_VERIFICATION_ATTEMPTS) {
		EMAIL_VERIFICATION_ATTEMPTS = eMAIL_VERIFICATION_ATTEMPTS;
	}

	public String getuPassword() {
		return uPassword;
	}

	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
	}

	public String getSTATUS() {
		return STATUS;
	}

	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}

	public String getCREATED_TIME() {
		return CREATED_TIME;
	}

	public void setCREATED_TIME(String cREATED_TIME) {
		CREATED_TIME = cREATED_TIME;
	}

	@Override
	public String toString() {
		return "User [uId=" + uId + ", uEmail=" + uEmail + ", uName=" + uName + ", EMAIL_VERIFICATION_HASH="
				+ EMAIL_VERIFICATION_HASH + ", EMAIL_VERIFICATION_ATTEMPTS=" + EMAIL_VERIFICATION_ATTEMPTS
				+ ", uPassword=" + uPassword + ", STATUS=" + STATUS + ", CREATED_TIME=" + CREATED_TIME + "]";
	}

}