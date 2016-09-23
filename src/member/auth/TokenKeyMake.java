package member.auth;

public class TokenKeyMake
{	
	public String make()
	{
		String tokenKey = "";
		
		for(int i=0; i<5; i++)
		{
			tokenKey += (int)(Math.random()*100);
			tokenKey += (char)((int)(Math.random()*26)+65);
		}
		
		return tokenKey;
	}
}
