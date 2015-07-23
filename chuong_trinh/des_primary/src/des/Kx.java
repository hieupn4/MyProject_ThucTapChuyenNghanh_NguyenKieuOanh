package des;
public class Kx
{
  private int PC1[] ={57,49,41,33,25,17,9,1,58,50,42,34,26,18,10,2,59,51,43,35,27,19,11,3,60,52,44,36,63,55,47,39,31,23,15,7,62,54,46,38,30,22,14,6,61,53,45,37,29,21,13,5,28,20,12,4};
  private int PC2[] ={14,17,11,24,1,5,3,28,15,6,21,10,23,19,12,4,26,8,16,7,27,20,13,2,41,52,31,37,47,55,30,40,51,45,33,48,44,49,39,56,34,53,46,42,50,36,29,32}; 
  private int LS[][] ={{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16},{1,1,2,2,2,2,2,2,1,2,2,2,2,2,2,1}};// cai nay khong can lam
  private int C[] = new int[28]; // hai nua 28 bit sau khi tach bo vao day
  private int D[] = new int[28]; // hai nua 28 bit sau khi tach bo vao day
  private int PC56[] = new int[56];
  private int PC48[] = new int[48];
  public int K48[] = new int[48];
  public void chuyenthanh56bit(int x[],int y[]) // x la 64 bit,y la 56 bit
  {
     for(int i=0;i<56;i++)
	 {
	    int z = PC1[i]-1; 
	    y[i] = x[z];
	 }
  }
  public void tach_2_nua_28bit(int x[])// x o day 56 bit
  {
    for(int i=0;i<28;i++)
	{
	  C[i] = x[i];
	}
	for(int i=28;i<56;i++)
	{
	  D[i-28] = x[i];
	}
  }
  public void quay(int x[],int y[],int j) // x, y la 28 bit, j la chi so vong lap
  {
    int p,q;
	if((j==0)||(j==1)||(j==8)||(j==15)) // dịch 1 bit
	{	  
	  q = x[0];
	  for(int i=0;i<27;i++)
	  {
	    x[i]=x[i+1];
	  }
	  x[27] = q;
	  q = y[0];
	  for(int i=0;i<27;i++)
	  {
	    y[i]=y[i+1];
	  }
	  y[27] = q;	  
	}	
	else // dich 2 bit
	{
	  p = x[0];
	  q = x[1];	  
	  for(int i=0;i<26;i++)
	  {
	    x[i]=x[i+2];
	  }
	  x[26]=p;
	  x[27]=q;
	  p = y[0];
	  q = y[1];	  
	  for(int i=0;i<26;i++)
	  {
	    y[i]=y[i+2];
	  }
	  y[26]=p;
	  y[27]=q;	
	}	 
  }
  public void xac_dinh_khoa_k(int x[],int y[])//x,y la dau vao 28 bit
  {
     int z[] = new int[56];
	 for(int i=0;i<28;i++)
	  {
	     z[i] =x[i];
		 z[i+28]=y[i];
	  }
	 for(int i=0;i<48;i++)
	 {
	    int t = PC2[i]-1; 
	    K48[i] = z[t];
	 }
	 
  }
  public void khoa(int i,int y[]) // i chi so vong lap. ,y la khoa ban dau 64 bit
  {
    chuyenthanh56bit(y,PC56); // 56 bit da nam trong PC56 
	tach_2_nua_28bit(PC56);// hai nua 28 bit da nam trong C va D
	for(int j=0;j<=i;j++)
	{
	   quay(C,D,j); // x, y la 28 bit, i la chi so vong lap
	}
	xac_dinh_khoa_k(C,D);//khoa 48 bit da duoc luu vao K48
    
  }
  
  public void khoa_giaima(int i,int y[]) // i chi so vong lap. ,y la khoa ban dau 64 bit
  {
    khoa(15-i,y); 
  }
}