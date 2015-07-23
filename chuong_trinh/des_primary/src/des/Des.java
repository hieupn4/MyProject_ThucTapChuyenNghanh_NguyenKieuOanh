package des;
import java.util.*;
public class Des
{ 

 public void xor_32bit(int x[],int y[],int z[])// xor hai x,y 32 bit voi nhau
   {
      for(int i=0;i<32;i++)
	  {
	    if(x[i]==y[i]) 
		  z[i] =0;
		else
		  z[i] =1;
	  }
   }
 public void saochep(int x[],int y[])
 {
    for(int i=0;i<32;i++)
	  y[i]=x[i];
 }
  public void hien_thi(String a,int x[])
    {
       int i=x.length;
       System.out.print(a+":   ");
       for(int j=0;j<i;j++)
           System.out.print(x[j]);
       System.out.print("\n");
        
    }
 public void ma_hoa_bit_step_step(int x[],int y[],int k[])//x 64 bit la ban ro,y la 64 bit ban ma,k 64 bit la khoa
 {
    int L1[] = new int[32];
	int L2[] = new int[32];
	int R1[] = new int[32];
	int R2[] = new int[32];
	int x1[] = new int[64];
	int xor1[] = new int[32];
	IP i1 = new IP();
	Kx k1 = new Kx(); // khoa
	Ex e1 = new Ex(); // bien doi 48 bit thanh 32 bit trong ham f
	Fx f1 = new Fx();
	hien_thi("Ban ro 64 bit cua chung ta la",x);
	i1.hoanvi_IP(x); // hoan vi x (IC)
	hien_thi("Ban ro sau khi di qua hoa vi IP se la",x );
	for(int i=0;i<32;i++) // chia 64 bit thanh hai nua 32 bit va 32 bit
	{
	  L1[i]=x[i];
	  R1[i]=x[i+32];
	  
	}
	System.out.print("Tach 64 bit thanh hai nua 32 bit la Lo va Ro \n" );
	hien_thi("Lo ",L1);
	hien_thi("Ro ",R1);
	for(int i=0;i<16;i++)
	{
	   System.out.println("\n\nVong lap thu "+(i+1));
	   // tinh gia tri ham f
	   f1.xac_dinh_fx_tai_vongi_step_step(R1,L2,k,i); // dau vao 32 bit x, dau ra 32 bit y,khoa k ban dau 64 bit, tai vong lap thu int
	   xor_32bit(L2,L1,xor1); //ket qua phep xor 32bit duoc luu o xor1
	  if(i!=15)
	  {
	   saochep(R1,L1);
	   saochep(xor1,R1);  
      }	  	  
	}  // ket qua cuoi cung 32 bit dau nam o xor1, 32 bit sau nam o R1
	for(int i=0;i<32;i++)
	{
	  y[i] = xor1[i];
	  y[i+32]=R1[i];
	}
	// cuoi cung di qua Ip -1 ta thu duoc ban ma 64 bit
	i1.hoanvi_IP_am1(y);
 }
//--------------------------------------------------------
//--------------------------------------------------------
public void ma_hoa_bit(int x[],int y[],int k[])//x 64 bit la ban ro,y la 64 bit ban ma,k 64 bit la khoa
 {
        int L1[] = new int[32];
	int L2[] = new int[32];
	int R1[] = new int[32];
	int R2[] = new int[32];
	int x1[] = new int[64];
	int xor1[] = new int[32];
	IP i1 = new IP();
	Kx k1 = new Kx(); // khoa
	Ex e1 = new Ex(); // bien doi 48 bit thanh 32 bit trong ham f
	Fx f1 = new Fx();
	i1.hoanvi_IP(x); // hoan vi x (IC)
	for(int i=0;i<32;i++) // chia 64 bit thanh hai nua 32 bit va 32 bit
	{
	  L1[i]=x[i];
	  R1[i]=x[i+32];  
	}
	for(int i=0;i<16;i++)
	{
	   // tinh gia tri ham f
	   f1.xac_dinh_fx_tai_vongi(R1,L2,k,i); // dau vao 32 bit x, dau ra 32 bit y,khoa k ban dau 64 bit, tai vong lap thu int
	   xor_32bit(L2,L1,xor1); //ket qua phep xor 32bit duoc luu o xor1
	  if(i!=15)
	  {
	   saochep(R1,L1);
	   saochep(xor1,R1);  
          }	   
	}  // ket qua cuoi cung 32 bit dau nam o xor1, 32 bit sau nam o R1
	for(int i=0;i<32;i++)
	{
	  y[i] = xor1[i];
	  y[i+32]=R1[i];
	}
	// cuoi cung di qua Ip -1 ta thu duoc ban ma 64 bit
	i1.hoanvi_IP_am1(y);
 }
 public void chuyen_xau64_thanh_kytu(int x[],char y[]) // x la dau vao 64 bit, y la mang 16 ky tu
 {
    char a[] = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
	int b[] = new int[4];
	for(int i=0;i<16;i++)
	{
	  for(int k=0;k<4;k++)
	    b[k]=x[4*i+k];
	  int j= 8*b[0] + 4*b[1]+2*b[2]+b[3];
	  y[i] =a[j];
	}
	
 }
 public void chuyen_kytu_thanh_xau64(char y[],int x[])// y la dau vao mang 16 ky tu,dau ra la x 64 bit
 {
    int a=0;
	int b[] = new int[4];
    for(int i=0;i<16;i++)
	{
	   if(y[i] =='0') a=0;
	   if(y[i] =='1') a=1;
	   if(y[i] =='2') a=2;
	   if(y[i] =='3') a=3;
	   if(y[i] =='4') a=4;
	   if(y[i] =='5') a=5;
	   if(y[i] =='6') a=6;
	   if(y[i] =='7') a=7;
	   if(y[i] =='8') a=8;
	   if(y[i] =='9') a=9;
	   if(y[i] =='A') a=10;
	   if(y[i] =='B') a=11;
	   if(y[i] =='C') a=12;
	   if(y[i] =='D') a=13;
	   if(y[i] =='E') a=14;
	   if(y[i] =='F') a=15;
	   for(int j=0;j<4;j++)
	   {
	     b[3-j]=(a%2);
		 a=a/2;
	   }
	   for(int j=0;j<4;j++)
	   {
	     x[4*i+j] =b[j];
	   }
	}
 }
 public String ma_hoa_xau(String a,String b)//a, la ban ro, b la khoa dai 16 ky tu
 {
    int xau_64_bit[] = new int[64];
	int xaukhoa_64_bit[] = new int[64];
	int xauma_64_bit[] = new int[64];
	char xau[] = new char[16];
	for(int i=0;i<16;i++)
	 xau[i] = a.charAt(i);
	char khoa[] = new char[16];
	for(int i=0;i<16;i++)
	 khoa[i] = b.charAt(i);
	chuyen_kytu_thanh_xau64(xau,xau_64_bit);// xau dau vao 16 ky tu duoc chuyen thanh 64 bit
	chuyen_kytu_thanh_xau64(khoa,xaukhoa_64_bit);
	ma_hoa_bit_step_step(xau_64_bit,xauma_64_bit,xaukhoa_64_bit);//x 64 bit la ban ro,y la 64 bit ban ma,k 64 bit la khoa
	chuyen_xau64_thanh_kytu(xauma_64_bit,xau); // x la dau vao 64 bit, y la mang 16 ky tu
	String f= new String(xau);
	return f;	
 }
}