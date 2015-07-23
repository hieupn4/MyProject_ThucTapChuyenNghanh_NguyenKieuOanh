package javaapplication9;
import des.*;
/**
 *
 * @author ACER
 */
public class JavaApplication9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int x[]={0,1,0,0,0,0,0,1,0,1,0,0,1,1,1,0,0,1,0,1,0,1,0,0,0,1,0,0,1,1,1,1,0,1,0,0,0,0,0,1,0,1,0,0,1,1,1,0,0,1,0,1,0,1,0,0,0,1,0,1,0,1,0,0};
	int k[]={0,0,0,1,0,0,0,1,0,1,0,1,0,0,0,1,0,0,0,0,0,1,0,0,0,1,1,1,0,0,0,0,1,0,0,1,0,1,0,1,1,0,1,0,1,0,1,1,1,1,0,0,1,1,0,1,1,1,1,0,1,1,1,1};
	//int ban_ma[] ={1,0,0,0,0,1,0,1,1,1,1,0,1,0,0,0,0,0,0,1,0,0,1,1,0,1,0,1,0,1,0,0,0,0,0,0,1,1,1,1,0,0,0,0,1,0,1,0,1,0,1,1,0,1,0,0,0,0,0,0,0,1,0,1};
	int y[] = new int[64];//ANTOANTT
	Des de1 = new Des();
	de1.ma_hoa_bit_step_step(x,y,k);//x 64 bit la ban ro,y la 64 bit ban ma,k 64 bit la khoa
	System.out.println("\n\n Ket Qua Ma Hoa la \n");
	for(int i=0;i<64;i++)
	System.out.print(y[i]);
        //1151047095ABCDEF
        //

        
        
    }
    
}
