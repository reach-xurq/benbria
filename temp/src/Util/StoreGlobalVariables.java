package Util;

public class StoreGlobalVariables {

	public static String sa;
	public static String uid;
	public static String cid;
	public static String gid;
	public static String bid;
	public static String sid;
	public static String pid;
	public static String mid;
	public static String tid;
	public static String sapd;
	public static String aupd;
	public static String rupd;
	public static String recordNumber1;
	public static String recordNumber2;
	public static String recordNumber3;
	public static String recordNumber4;
	public static String recordNumber5;
	public static String pc;
	public static String pc1;
	public static String pc2;
	public static String code;
	public static String email;
	public static String badEmail;
	public static String text;
	public static String extratext;
	public static String importDirectory;
	public static String illegalSignal;
	public static String message;
	public static String browser;
	public static int homeFlag = 0;
	
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

}
