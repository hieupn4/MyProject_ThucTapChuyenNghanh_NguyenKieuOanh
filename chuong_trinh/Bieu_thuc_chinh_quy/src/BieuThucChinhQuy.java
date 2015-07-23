import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class BieuThucChinhQuy {
	public boolean kiemtra(String y) // kiem tra y co thuoc bieu thuc chinh quy hay khong
	{
		if(kiemTraKhaiBaoBienKieu1(y)==true||kiemTraKhaiBaoBienKieu2(y)==true||kiemTraKhaiBaoBienKieu3(y)==true||kiemTraKhaiBaoBienKieu4(y)==true||kiemTraKhaiBaoBienKieu5(y)==true||kiemTraKhaiBaoBienKieu6(y)==true||kiemTraKhaiBaoBienKieu7(y)==true)
			return true;
		else
			return false;
	}
	public  boolean kiemTraKhaiBaoBienKieu1(String x)
	{
		
	    boolean match = x.matches("(\\s*(int|float|double|char|)\\s*(_|[a-zA-Z])[a-zA-Z0-9_]*;\\s*)+");
		return match;
	}
	public  boolean kiemTraKhaiBaoBienKieu2(String x)//kieu nay hoan thien hon kieu 1
	{
		
	    boolean match = x.matches("(\\s*(int|float|double|char|)\\s*(_|[a-zA-Z])[a-zA-Z0-9_]*(;|(\\s*=\\s*[a-zA-Z0-9_]*);)\\s*)+");
		return match;
	}
	public  boolean kiemTraKhaiBaoBienKieu3(String x)//kieu nay la kieu khac
	{
		
	    boolean match = x.matches("(\\s*(int|float|double|char|))\\s*((_|[a-zA-Z])[a-zA-Z0-9_]*,)*((_|[a-zA-Z])[a-zA-Z0-9_]*);$");
		return match;
	}
	public boolean kiemTraKhaiBaoBienKieu4(String x)//kiem tra khai bao mang
	{
		
	    boolean match = x.matches("(\\s*(int|float|double|char|))\\s*(_|[a-zA-Z])[a-zA-Z0-9_]*(\\[[1-9][0-9]*])+;");
		return match;
	}
	public  boolean kiemTraKhaiBaoBienKieu5(String x)//kiem tra khai bao mang , hoan thien hon kieu 4
	{
		
	    boolean match = x.matches("(\\s*(int|float|double|char|))\\s*((_|[a-zA-Z])[a-zA-Z0-9_]*(\\[[1-9][0-9]*])+,)*(_|[a-zA-Z])[a-zA-Z0-9_]*(\\[[1-9][0-9]*])+;");
		return match;
	}
	public  boolean kiemTraKhaiBaoBienKieu6(String x)// kiem tra khai bao con tro
	{
		 boolean match = x.matches("(\\s*(int|float|double|char|))\\s*(\\**(_|[a-zA-Z])[a-zA-Z0-9_]*(\\[[1-9][0-9]*])+,)*\\**(_|[a-zA-Z])[a-zA-Z0-9_]*(\\[[1-9][0-9]*])+;");
		 return match;
	}
	public  boolean kiemTraKhaiBaoBienKieu7(String x)// kiem tra khai bao con tro
	{
		 boolean match = x.matches("(\\s*(int|float|double|char|))\\s*(\\**(_|[a-zA-Z])[a-zA-Z0-9_]*,)*(\\**(_|[a-zA-Z])[a-zA-Z0-9_]*);$");
		 return match;
	}

}
