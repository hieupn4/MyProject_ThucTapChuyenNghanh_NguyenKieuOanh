package des;
public class Ex
{
  private int E[] = {32,1,2,3,4,5,4,5,6,7,8,9,8,9,10,11,12,13,12,13,14,15,16,17,16,17,18,19,20,21,20,21,22,23,24,25,24,25,26,27,28,29,28,29,30,31,32,1};
  public void tao_48_bit(int x[],int y[])// dau vao se la mot mang 48 bit ,va mang 32 bit
  {
	for(int i=0;i<48;i++)
	{
	  int z = E[i]-1;
	  x[i] = y[z];
	}
  }

}