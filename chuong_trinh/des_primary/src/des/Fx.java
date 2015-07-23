package des;
public class Fx  //  lop nay chinh la ham f
{
   public int a[] = new int[48];
   private int b[] = new int[48];
   private int c[] = new int[32];
   private int d[] = new int[32];
   private Ex e1 = new Ex();
   private Kx k1 = new Kx();
   private Sx s1 = new Sx();
   public void hien_thi(String a,int x[])
    {
       int i=x.length;
       System.out.print(a+":   ");
       for(int j=0;j<i;j++)
           System.out.print(x[j]);
       System.out.print("\n");
        
    }
   public void xor_48bit(int x[],int y[])// xor hai x,y 48 bit voi nhau
   {
      for(int i=0;i<48;i++)
	  {
	    if(x[i]==y[i]) 
		  a[i] =0;
		else
		  a[i] =1;
	  }
   }
   public void xac_dinh_fx_tai_vongi_step_step(int x[],int y[],int k[],int i) // dau vao 32 bit x, dau ra 32 bit y,khoa k ban dau 64 bit, tai vong lap thu int
     {
        e1.tao_48_bit(b,x);// dau vao x 32 bit duoc mo rong thanh 48 bit (b);
		hien_thi("32 bit di qua E tro thanh 48 bit",b);
		k1.khoa(i,k);// 48 bit khoa ki da duoc luu vao K48 cua doi tuong k1.
		hien_thi("khoa con K",k1.K48);
		xor_48bit(b,k1.K48); // ket qua phep xor 48 bit duoc luu vao a;
		hien_thi("khoa con K xor voi E(R)",a);
		s1.bit48_thanh_32bit(a,c); // 48 bit a di qua 8 hop S thanh 32 bit luu trong bien c
		hien_thi("48 bit sau khi di qua 8 hop S-Box thanh 32 bit",c);
		s1.di_qua_hopP(c,d);// 32 bit c di qua hop p tro thanh 32 bit trong d
		hien_thi("32 bit di qua hop P-PX cho ra ket qua ham f",d);
		for(int j=0;j<32;j++)
		{
		   y[j] = d[j];
		}		
     }
	public void xac_dinh_fx_tai_vongi(int x[],int y[],int k[],int i) // dau vao 32 bit x, dau ra 32 bit y,khoa k ban dau 64 bit, tai vong lap thu int
     {
        e1.tao_48_bit(b,x);// dau vao x 32 bit duoc mo rong thanh 48 bit (b);
		k1.khoa(i,k);// 48 bit khoa ki da duoc luu vao K48 cua doi tuong k1.
		xor_48bit(b,k1.K48); // ket qua phep xor 48 bit duoc luu vao a;
		s1.bit48_thanh_32bit(a,c); // 48 bit a di qua 8 hop S thanh 32 bit luu trong bien c
		s1.di_qua_hopP(c,d);// 32 bit c di qua hop p tro thanh 32 bit trong d
		for(int j=0;j<32;j++)
		{
		   y[j] = d[j];
		}		
     }
   public void xac_dinh_fx_tai_vongi_giaima(int x[],int y[],int k[],int i) // dau vao 32 bit x, dau ra 32 bit y,khoa k ban dau 64 bit, tai vong lap thu int
     {
        e1.tao_48_bit(b,x);// dau vao x 32 bit duoc mo rong thanh 48 bit (b);
		k1.khoa_giaima(i,k);// 48 bit khoa ki da duoc luu vao K48 cua doi tuong k1.
		xor_48bit(b,k1.K48); // ket qua phep xor 48 bit duoc luu vao a;
		s1.bit48_thanh_32bit(a,c); // 48 bit a di qua 8 hop S thanh 32 bit luu trong bien c
		s1.di_qua_hopP(c,d);// 32 bit c di qua hop p tro thanh 32 bit trong d
		for(int j=0;j<32;j++)
		{
		   y[j] = d[j];
		}		
     }

}