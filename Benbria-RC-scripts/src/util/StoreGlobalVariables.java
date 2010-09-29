package util;

public class StoreGlobalVariables {

	private String sa;
	private String uid;
	private String cid;
	private String gid;
	private String bid;
	private String sid;
	private String pid;
	private String mid;
	private String tid;
	private String sapd;
	private String aupd;
	private String rupd;
	private String recordNumber1;
	private String recordNumber2;
	private String recordNumber3;
	private String recordNumber4;
	private String recordNumber5;
	private String pc;
	private String pc1;
	private String pc2;
	private String code;
	private String email;
	private String badEmail;
	private String text;
	private String extratext;
	private String importDirectory;
	private String illegalSignal;
	private String message;
	private String browser;
	
	public StoreGlobalVariables() {
		uid = String.valueOf((int)Math.floor(Math.random()*9999));
		cid = String.valueOf((int)Math.floor(Math.random()*9999));
		gid = String.valueOf((int)Math.floor(Math.random()*9999));
		bid = String.valueOf((int)Math.floor(Math.random()*9999));
		sid = String.valueOf((int)Math.floor(Math.random()*9999));
		pid = String.valueOf((int)Math.floor(Math.random()*9999));
		mid = String.valueOf((int)Math.floor(Math.random()*9999));
		tid = String.valueOf((int)Math.floor(Math.random()*9999));
		sa = "admin";
		sapd = "admin";
		aupd = String.valueOf((int)Math.floor(Math.random()*9999));
		rupd = String.valueOf((int)Math.floor(Math.random()*9999));
		recordNumber1 = "1001";
		recordNumber2 = "1002";
		recordNumber3 = "1003";
		recordNumber4 = "1004";
		recordNumber5 = "1005";
		pc = "Benbria-xrq";
		pc1 = "Benbria-qsp";
		pc2 = "Benbria-qsp";
		code = "01234567891234";
		email = "vactowb@gmail.com";
		badEmail = "wang.bin^123";
		text = "idreamho";
		extratext = "a";
		importDirectory = "D:\\ImportFiles\\";
		illegalSignal = "!@#$%^&*()+=\\|[]{},<>?";	
		message = "Your broadcast has been successfully scheduled. Click here to continue.";
		browser = "*firefox";
	}
	
	public String getBrowser() {
		return this.browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public String getSa() {
		return this.sa;
	}
	
	public String getUid() {
		return this.uid;
	}
	
	public String getCid() {
		return this.cid;
	}
	
	public String getGid() {
		return this.gid;
	}
	
	public String getBid() {
		return this.bid;
	}
	
	public String getSid() {
		return this.sid;
	}
	
	public String getPid() {
		return this.pid;
	}
	
	public String getMid() {
		return this.mid;
	}
	
	public String getTid() {
		return this.tid;
	}
	
	public String getSapd() {
		return this.sapd;
	}
	
	public String getAupd() {
		return this.aupd;
	}
	
	public String getRupd() {
		return this.rupd;
	}
	
	public String getRecordNumber1() {
		return this.recordNumber1;
	}
	
	public String getRecordNumber2() {
		return this.recordNumber2;
	}
	
	public String getRecordNumber3() {
		return this.recordNumber3;
	}
	
	public String getRecordNumber4() {
		return this.recordNumber4;
	}
	
	public String getRecordNumber5() {
		return this.recordNumber5;
	}
	
	public String getPc() {
		return this.pc;
	}
	
	public String getPc1() {
		return this.pc1;
	}
	
	public String getPc2() {
		return this.pc2;
	}
	
	public String getCode() {
		return this.code;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String getBadEmail() {
		return this.badEmail;
	}
	
	public String getText() {
		return this.text;
	}
	
	public String getExtratext() {
		return this.extratext;
	}
	
	public String getImportDirectory() {
		return this.importDirectory;
	}
	
	public String getIllegalSignal() {
		return this.illegalSignal;
	}
	
	public String getMessage() {
		return this.message;
	}

}
