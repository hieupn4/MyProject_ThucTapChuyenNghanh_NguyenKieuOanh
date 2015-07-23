/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package all_key;

/**
 *
 * lop này có nhiệm vụ xử lý dữ liệu đầu vào là một chuỗi.
 * chuỗi được đưa vào biểu thị một lược đồ quan hệ trên đó bao gồm một tập thuộc tính và các quan hệ
 * của chúng.
 * đầu vào ví dụ gồm các thuộc tính {A,B,C,D} và một tập các phụ thuộc hàm F{A->B,A->C}
 * lúc này chuỗi đưa vào sẽ có định dạng như sau : A.B,A.C/D
 */
public class hieu_processString 
{
  
   public static String U_thuoctinh(String a)
   {
       // trả về chuỗi bao gồm các thuộc tính của quan hệ , loại trừ những thuộc tính lặp
       //đã thử thành công
       int Slength = a.length(); // độ dài của xâu
       String US = "";
       for(int i=0;i<Slength;i++)
       {
           int dem =0;
           for(int j=0;j<US.length();j++) //kiểm tra ký tự đã có trong chuỗi hay chưa
           {
              if(a.charAt(i)==US.charAt(j))
              dem =dem +1;
           }
           if(dem!=0) continue;
           if(a.charAt(i)!='.'&&a.charAt(i)!=','&&a.charAt(i)!='/') // những ký tự đặc biệt thì không đưa vào
              US = US + a.charAt(i);
           
       }
       return US;
       
   }
   public static String TG_thuoctinh(String a)
   {
       /* chuỗi này bao gồm các thuộc tính không thuộc vế trái cũng như không thuộc vế 
       phải của các lược đồ quan hệ
       */
       int Slength = a.length(); // độ dài của xâu
       String US = "";
       for(int i=Slength-1;i>=0;i--)
       {    
           if(a.charAt(i)=='/') break;
           else
               US = US + a.charAt(i);
       }
       return US;
   }
   public static String split_double_String(String b)
   {
       /* loại bỏ những ký tự trùng lặp trong chuỗi */
       /* ví dụ chuỗi aabccd thì kết quả là abcd */
       StringBuffer a =new StringBuffer(b);
       for(int i=0;i<a.length();i++)
           for(int j=i+1;j<a.length();j++)
               if(a.charAt(i)==a.charAt(j))
                    a.deleteCharAt(j);
       return a.toString();
   }
   public static String L_thuoctinh(String a)
   {
       /* chuỗi này bao gồm các thuộc tính thuộc vế trái của các quan hệ */
       /* chú ý ở đây là thuộc vế trái chứ không phải là chỉ thuộc vế trái */
       int Slength =0; // độ dài của xâu
       String US = "";
       do
       {
           if(a.charAt(Slength)=='.')
              do
                 Slength = Slength+1; 
              while(a.charAt(Slength)!=','&&a.charAt(Slength)!='/');
           else
           {
               US = US + a.charAt(Slength);
           }
           if(a.charAt(Slength)!='/')
           Slength = Slength+1;
       }    
       while(a.charAt(Slength)!='/');
       return split_double_String(US);
   }
    public static String R_thuoctinh(String a)
   {
       /* chuỗi này bao gồm các thuộc tính thuộc vế phải của các quan hệ */
       /* chú ý ở đây là thuộc vế phải chứ không phải là chỉ thuộc vế phải */
       int Slength =0; // độ dài của xâu
       String US = "";
       do
       {
              while(a.charAt(Slength)!='.')
                  Slength = Slength+1; 
              do
              {
                 US = US + a.charAt(Slength+1);  
                 Slength = Slength +1;
              }
              while(a.charAt(Slength+1)!=','&&a.charAt(Slength+1)!='/');
       }
       while(a.charAt(Slength+1)!='/');
               
       return split_double_String(US);
   }
    public static String L_R_thuoctinh(String a)
    {
        /* trả về chuỗi bao gồm các thuộc tính thuộc cả vế trái và phải của quan hệ a */
        String trunggian ="";
        String x = L_thuoctinh(a);
        String y = R_thuoctinh(a);
        // tim thằng nào thuộc cả hai chuỗi x và y là được
        for(int i=0;i<x.length();i++)
            for(int j=0;j<y.length();j++)
                if(x.charAt(i)==y.charAt(j))
                    trunggian = trunggian + x.charAt(i);
        return split_double_String(trunggian);
    }
    public static String tru_hai_chuoi(String a,String b)
   {
       /* trừ hai chuỗi */
       /* tim nhung phần tử nằm trong chuỗi a nhưng không nằm trong chuỗi b */
       String US = "";
       for(int i=0;i<a.length();i++)
       {
           int dem=0;
           for(int j=0;j<b.length();j++)
              if(a.charAt(i)==b.charAt(j)) 
                  dem =dem +1;
           if(dem==0)
               US =US + a.charAt(i);
       }
               
       return split_double_String(US);
   }
    public static String core(String a)
    {
        /* tìm chuỗi core */
        String US = "";
        US = tru_hai_chuoi(U_thuoctinh(a),R_thuoctinh(a));
        return split_double_String(US);
    }
    public static void kt(String a,String b)
    {
        /* hàm này phục vụ để xây dựng hàm bao đóng */
        /* b ở đây là một quan hệ ví dụ ae.c */
        /* a ở đây là chuỗi thuộc tính cần tìm bao đóng,ví dụ aed */
        
    }
    public static String kiemtra_thuoc(String x,String y)
    {
      /* x la chuỗi bao đóng ví dụ x=ab, còn y là một quan hệ ,ví dụ a.c */
      /* kết quả là chuỗi x trở thành x = abc */
      /* giải thuật chúng ta kiểm tra xem các ký tự trước dấu chấm của y có nằm trong chuỗi
         x hay không .nếu không thì thôi ,còn có thì đưa chuỗi sau dấu . vào x
        */
      /* hàm này được dùng để xây dựng nên phương thức String bao_dong */
      String s_before=""; // lưu những ký tự trướ dấu chấm
      String s_behind=""; // lưu những ký tự sau dấu chấm
      int i=0;
      do
      {
        s_before = s_before + y.charAt(i);
        i= i+1;
      }while(y.charAt(i)!='.');
      i = y.length()-1;
      do
      {
        s_behind = s_behind + y.charAt(i);
        i= i-1;
      }while(y.charAt(i)!='.');
      i=0;
      for(int j=0;j<s_before.length();j++)
      {
          for(int k=0;k<x.length();k++)
          {
              if(s_before.charAt(j)==x.charAt(k))
                  i=i+1;
          }
      }
      if(i==s_before.length())
      {
         x = x+s_behind;
         x = split_double_String(x);
         return x;
      }
      else
          return x;
    } 
    public static String bao_dong(String a,String b)
    {
        /* tìm bao đóng của tập b dựa vào bảng quan hệ được chơ bởi chuỗi a */
        /* kết quả trả về là một chuỗi */
        /* xác định xem trong chuỗi a có bao nhiêu quan hệ,chú ý số quan hệ bằng số dấu . */
        int i =0;
        for(int j=0;j<a.length();j++)
            if(a.charAt(j)=='.')
               i++;
        /* vậy ta có tất cả là i quan hệ */
        String relation[]  = new String[i]; 
        for(int z =0;z<i;z++)
            relation[z] ="";
        // công việc tiêp theo là đưa từng quan hệ vào mảng relation--chú ý là có tất cả i quan hệ
        int m=0;
        for(int j=0;j<i;j++)
        {
            do
            {
              relation[j]=relation[j]+a.charAt(m);
              m=m+1;
            }while(a.charAt(m)!=','&&a.charAt(m)!='/');
            m=m+1;
        }
        //tìm bao đóng
        // giải thuật mình lập trình ở đây chưa phải tối ưu, nhưng do thời gian có hạn nên phải làm thế này
        // có i quan hệ nghĩa là chúng ta sẽ thực hiện i lần lặp, mỗi lần lặp sẽ khảo sát trên i quan hệ
        // mặc dù không tối ưu nhưng rõ ràng i*i lần tính toán cũng không phải là lớn lắm và hoàn toàn có thể thực hiện được
        for(int j=0;j<i;j++)
           for(int z=0;z<i;z++)
           {
              b=kiemtra_thuoc(b,relation[z]); 
           }  // xong vòng lặp này b là một bao đóng
        return b;
    }
    public static int S_compare(String a,String b)
    {
        //so sánh hai chuỗi a b với nhau
        // sánh sánh ở đây là không có trật tự
        // nghĩa là những phần tử thuộc a thì cũng thuộc b và ngược lại là được
        //nếu bằng nhau thì trả về 1, còn không thi trả về 0
        int dem1 =0;
        int dem2 =0;
        for(int i=0;i<a.length();i++)
            for(int j=0;j<b.length();j++)
                if(a.charAt(i)==b.charAt(j))
                {
                    dem1 = dem1 +1;
                    break;
                }
        for(int i=0;i<b.length();i++)
            for(int j=0;j<a.length();j++)
                if(b.charAt(i)==a.charAt(j))
                {
                    dem2 = dem2 +1;
                    break;
                }
        if((dem1==a.length())&&(dem2==b.length()))
            return 1;
        else
            return 0;
    }
    public static String[] chirldren_P(String POSS)
    {
        // hàm trả về một mảng chuỗi bao gồm các chuỗi con của chuỗi POSS
        // children_POSS là mảng chuỗi , mỗi chuỗi là con của chuỗi POSS
        // chuỗi POSS có n ký tự khác nhau thì sẽ có 2^n -1 chuỗi con của POSS
        // ví dụ POSS ={a,b,c} thì các chuỗi con của POSS là {a},{b},{c},{ab},{ac},{bc},{abc}
        String chirldren_POSS[];
        int S_long = POSS.length();
        double count1 = Math.pow(2, S_long)-1;
        int count = (int)count1;
        chirldren_POSS = new String[count];
        for(int i=0;i<count;i++)
        {
            chirldren_POSS[i] = "";
            i = i+1;
            int k[] = new int[S_long];
            for(int j=0;j<S_long;j++)
                k[j] = 0;
            int tg = i;
            int j2=0;
            do
            {
              int du = tg%2;
              tg = tg /2;
              k[j2] = du;
              j2 = j2+1;
            }while(tg!=0);
            for(int j=0;j<S_long;j++)
            {
              if(k[j]==1)
              chirldren_POSS[i-1] = chirldren_POSS[i-1]+POSS.charAt(j);  
            }
            i=i-1;
            
        }
        return chirldren_POSS;
    }
    public static int parent(String a,String b)
    {
        // kiểm tra xem a có phải là chuỗi cha của b hay không 
        // ví dụ a= ABC , b=BC -> a là chuỗi cha của b
        // nếu phải trả về 1 , còn không trả về 0
        int dem=0;
        int dem2=0;
        if(b.length()>= a.length()) 
            return 0;
        else
        {
            for(int i=0;i<b.length();i++)
            {
                dem=0;
                for(int j=0;j<a.length();j++)
                    if(b.charAt(i)==a.charAt(j))
                        dem=dem +1;
                if(dem!=0)
                    dem2=dem2+1;
            }
            if(dem2 == b.length())
                return 1;
            else
                return 0;
        }
    }
    public static String[] all_key(String x)
    {
        //đây là phương thức dung để giải quyết toan bộ bài toán
        // những phương thức còn lại được để xây dựng nên phương thức này
        // đầu vào là chuỗi a ,bao gồm các quan hệ,ví dụ x=ab.c,c.d,ad.e/g
        // đầu ra là một tập các khóa ví dụ :abg,bc....
        //giải thuật để giải quyết bài toán này đã có đầy rẫy trên mạng
        
        
        //bước 1 : Tìm nhân của mọi khóa CORE
        String core1 = core(x);
        //bước 2 : Tìm bao đóng của core
        String luutru[] = new String[100];
        String luutru1[] = new String[100];
        for(int i=0;i<100;i++)
        {
            luutru[i]=".";
            luutru1[i]=".";
        }
        String bao_dong_core1 = bao_dong(x,core1);
        String S="";
        if(S_compare(bao_dong_core1,U_thuoctinh(x))==1)
        {
           luutru1[0] = core1;
           return luutru1; 
        }
        else
        {
           String Poss =L_R_thuoctinh(x); 
           String chirld[]=chirldren_P(Poss);
           int j=0;
           for(int i=0;i<chirld.length;i++)
           {
               String tg = chirld[i];
               tg = tg + core1;
               String baodong_tg =bao_dong(x,tg);
               if(S_compare(baodong_tg,U_thuoctinh(x))==1)
               {
                  luutru[j] =tg;
                  j=j+1;
               }
           }
           // xong vòng for này ta được mảng luutru đang luu trữ những siêu khóa của quan hệ
           //bước cuối cùng từ tập siêu khóa này ta loại bỏ để thu được kết quả cuối cùng là tập các khóa
           for(int i=0;i<luutru.length;i++)
           {
               for(int j1=0;j1<luutru.length;j1++)
               {
                  if(parent(luutru[i],luutru[j1])==1) 
                     luutru[i]="."; 
               }
           }
           int z=0;
           for(int i=0;i<luutru.length;i++)
           {
               if(luutru[i]==".") continue;
               else
               {
                 luutru1[z]=luutru[i];
                 z=z+1;
               }
           } // bây giờ luutru1 chính là mảng chứa các khóa của quan hệ
           
           return luutru1;
        }
          
    }
    
    public static void main(String[] args) 
    {
     String x[]=all_key("a.b,b.c,c.a/") ;//A->B, B->C, C->A
     String a = "";
     for(int i=0;i<x.length;i++)
     {
         if(x[i]==".")
             continue;
         else
           a =a + x[i]+",";
     }
     System.out.println(" các khóa có thể có là :"+a);  
    } 
        
}
