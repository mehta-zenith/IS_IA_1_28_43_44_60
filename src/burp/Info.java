package burp;


public class Info {
	public static String ExtensionName = "reCAPTCHA";
	public static String Version = bsh.This.class.getPackage().getImplementationVersion();
	public static String Author = "zenith";	
	public static String github = "https://github.com/mehta-zenith";

	//name+version+author
	public static String getFullExtensionName(){
		return ExtensionName+" "+Version+" "+Author;
	}
}