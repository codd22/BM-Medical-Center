package codd.major.logic;

import java.util.Random;

import codd.major.model.ForgetModel;

public class logic1 
{
	public static String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 6) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }
	
	public static boolean send(ForgetModel obj,String pass)
	{
		try
        {
        String[] to ={obj.getEmailid()};
       if(EmailSender.sendmail("softyexpo2016@gmail.com","gmail@Sagar2210","Reset password","Your new Passoword for BM Medical Centre is"+pass,to))
       {
          return true;
       }
    }
	catch(Exception e)
    {
    	return false;
    }
		return false;
	}
}
