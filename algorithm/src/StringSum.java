
import java.util.*;
import java.io.*;
import java.util.Scanner;

public class StringSum {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        int plus=0;
        for(int i=0;i<=a.length-b.length;i++) {
            char[] temp=new char[b.length];
            int s=0;
			/*for(int k=i;k<=i+b.length-1;k++) {
                temp[s]=a[k];
                System.out.println("这是第"+i+"个数组"+"第"+s+"个"+temp[s]);
                s++;
			}
			*/
            System.arraycopy(a, i, temp, 0, b.length);

            System.out.println(Arrays.toString(temp));

            for(int j=0;j<=b.length-1;j++) {
                if(b[j]!=temp[j]) {
                    plus++;
                }
            }
        }
        
        System.out.println(plus);
    
    }
}