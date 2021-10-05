import java.util.*;
import java.math.BigInteger;


public class Main {
    public static void main(String[] argv){

        Scanner sc= new Scanner(System.in);
        System.out.print("Enter the number n: ");
        int n= sc.nextInt();

        if(n<15){
            int numerator1=1;
            int numerator2=1;
            int numeratorRes=0;
            int denominator1=2;
            int denominator2=3;
            int denominatorRes=0;

            for(int i=0;i<n-1;i++) {
                denominatorRes = gcd(denominator1,denominator2);
                denominatorRes = (denominator1*denominator2) / denominatorRes;
                numeratorRes = (numerator1)*(denominatorRes/denominator1) + (numerator2)*(denominatorRes/denominator2);
                int gcd=gcd(denominatorRes,numeratorRes);
                denominatorRes/=gcd;
                numeratorRes/=gcd;
                denominator1=denominatorRes;
                numerator1=numeratorRes;
                denominator2++;
            }
            System.out.print("Suma: "+ numeratorRes+"/"+denominatorRes);
        }
        else{
            BigInteger numerator1=new BigInteger("1");;
            BigInteger numerator2=new BigInteger("1");;
            BigInteger numeratorRes=new BigInteger("0");;
            BigInteger denominator1=new BigInteger("2");;
            BigInteger denominator2=new BigInteger("3");;
            BigInteger denominatorRes=new BigInteger("0");;

            for(int i=0;i<n-1;i++) {
                denominatorRes = denominator1.gcd(denominator2);
                denominatorRes = (denominator1.multiply(denominator2)).divide(denominatorRes) ;
                numeratorRes = (numerator1).multiply(denominatorRes.divide(denominator1)).add((numerator2).multiply((denominatorRes.divide(denominator2))));
                BigInteger gcd=denominatorRes.gcd(numeratorRes);
                denominatorRes= denominatorRes.divide(gcd);
                numeratorRes= numeratorRes.divide(gcd);
                denominator1=denominatorRes;
                numerator1=numeratorRes;
                denominator2=denominator2.add(new BigInteger("1"));
            }
            System.out.print("Suma: "+ numeratorRes+"/"+denominatorRes);
        };

    }

    static int gcd(int a, int b)
    {
        if (b == 0) {
            return a;
        }
        return gcd(b, a%b);
    }
}