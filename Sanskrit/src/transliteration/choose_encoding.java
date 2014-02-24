package transliteration;

public class choose_encoding{

	public choose_encoding()
	{	
		System.out.println("In devanagaari_display()");
	}
	public static String get_raw_to_dvn_view(String alter)
	{	
		String s1 = get_raw_to_scharfe(alter);
		
		return (new devanagari()).transform(s1);
	}
        public static String get_raw_to_scharfe(String alter)
	{
		String s1 = get_raw_to_uniform_itrans(alter);	
		
		return get_uniform_itraans_to_scharfe(s1);
	}
	public static String get_raw_to_uniform_itrans(String alter)
	{
		return (new itrans()).transform(alter);		
	}	
	public static String get_uniform_itraans_to_scharfe(String alter)
	{
		return (new i_to_scharfe()).transform(alter);
	}
	
		
//
//	public static String get_scharfe_to_dvn(String alter)
//	{
//		return (new devanagari()).transform(alter);
//	}
//	
//	public static String get_uniform_itraans_to_dvn_view(String alter)
//	{
//		String s1 = get_uniform_itraans_to_scharfe(alter);
//		
//		return get_scharfe_to_dvn(s1);
//	}
//	
//		
//	
		
}