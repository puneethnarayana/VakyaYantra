package transliteration;

public class itrans
{
String transformed;

public itrans()
	{
		transformed = "";
	}

public String transform(String s1)
	{
		
	transformed = s1;

	transformed = transformed.replaceAll("aa","A");		
	transformed = transformed.replaceAll("ii","I");												//RRI-kaar ikaar but will end up reading RRI-kaar
	transformed = transformed.replaceAll("uu","U");
	transformed = transformed.replaceAll("R\\^i","RRi");
	transformed = transformed.replaceAll("R\\^I","RRI");
	transformed = transformed.replaceAll("L\\^i","LLi");
	transformed = transformed.replaceAll("L\\^I","LLI"); 
	transformed = transformed.replaceAll("JN","~n");
	transformed = transformed.replaceAll("w","v");
	transformed = transformed.replaceAll("Sh","Z");
	transformed = transformed.replaceAll("\\.n","M");
	transformed = transformed.replaceAll("\\.m","M");
	transformed = transformed.replaceAll("x","kZ");
	transformed = transformed.replaceAll("GY","j~n"); 
        return transformed;
	}
}
