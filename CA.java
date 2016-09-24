package CRYPTOGRAPHY;
public class CA 
{
    public static final int MAX = 41;
    public static final int ITR = 30;
    public static final char[] b = new char[MAX];
    public static final char[] a = {'0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','1','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0'};
    public static final char[] c = { '0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','1','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0'};
    public static void display()
    {
        for(int i=0;i<MAX;i++)
        {
            if(a[i]=='1')System.out.print((char)0x2589);
            else System.out.print((char)0x2591);
        }
        System.out.println();
    }
    public static void main(String args[])
    {
        for(int ruleno = 0; ruleno<= 255; ruleno++)
        {
            for(int i = 0; i< MAX; i++)
                a[i]=c[i];
            String rule = ("00000000"+Integer.toBinaryString(ruleno)).substring(Integer.toBinaryString(ruleno).length());
            System.out.println("\nRule No: "+ ruleno);
            display();
            for(int i = 1; i<= ITR; i++)
            {
                for(int j = 0; j< MAX-2; j++)
                {
                    for(int k = 0; k<=7; k++)
                    {
                        String x = ("000"+Integer.toBinaryString(k)).substring(Integer.toBinaryString(k).length());
                        if((a[j]==x.charAt(0)) && (a[j+1]==x.charAt(1)) && (a[j+2]==x.charAt(2))) 
                        {
                            b[j+1]=rule.charAt(7-k);
                            break;
                        }
                    }
                }
                b[0]=a[0];
                b[MAX-1]=a[MAX-1];
                for(int k = 0; k<MAX; k++)
                    a[k]=b[k];
                display(); 
            }
        }
    }
}