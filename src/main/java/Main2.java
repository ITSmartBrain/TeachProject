import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) throws IOException {
//        long k = 102;
//        long sequenceLen = k+1;
//        calc(sequenceLen);
        //System.out.println(getOneDigitFromNumber(271, 2));

        //1000000000000l =  9
        //100200300400500600 = 1
        //102030405060708090 =  4

//        FileOutputStream f = new FileOutputStream("test.txt");
//        String str = "привет";
//        f.write(str.getBytes());
//        f.close();

//        FileInputStream fi = new FileInputStream("test.txt");
//
//        byte[] arr = new byte[5];
//        fi.read(arr);
//        String res = new String(arr);
//        System.out.println(res);

//        System.out.printf("h = %d\n", (int)'h');
//        System.out.printf("п = %d\n", (int)'п');
//        String let = "п";
//        byte[] arr = let.getBytes();
//        for(byte val : arr){
//            System.out.println(val);
//        }
//        String res = new String(arr, "utf8");
//        System.out.println(res);




        FileReader fr = new FileReader("test.txt");
        while(fr.ready()){
            System.out.print(fr.read()+" ");
        }
        System.out.println();


        FileInputStream fis = new FileInputStream("test.txt");
        int val = fis.read();
        while(val!=-1){
            System.out.print(val+" ");
            val = fis.read();
        }




    }

    public static void calc(long sequenceLen){
        long mult = 1;
        long rest = sequenceLen;
        long count = 0;
        while(sequenceLen>=count){
            sequenceLen-=count;
            mult*=10;
            count = getNumberCount(mult);

        }
        long restLenOfDigits = String.valueOf(mult-1).length();
        long celaiaPart = sequenceLen/restLenOfDigits;
        long ostatok = sequenceLen - celaiaPart*restLenOfDigits;

        if(ostatok==0) {
            double resultDigit = celaiaPart + (mult / 10 - 1);
            System.out.println((long)resultDigit%10);
        }else{
            long zapas = 0;
            while(ostatok!=0) {
                zapas++;
                long newSequenceLen = sequenceLen - zapas;
                celaiaPart = newSequenceLen/restLenOfDigits;
                long tmp = celaiaPart*restLenOfDigits;
                ostatok = newSequenceLen - tmp;


            }
            celaiaPart++;
            double resultDigit = celaiaPart + (mult/10 - 1);
            System.out.println(getOneDigitFromNumber((long)resultDigit, zapas));
            //System.out.println("Число: "+resultDigit+", Сдвиг: "+zapas);

        }
    }


    public static long getOneDigitFromNumber(long number, long sdvig){
        long multip = (long)Math.pow(10, sdvig);
        while(number/multip>0){
            number /= 10;
        }
        return number%10;
    }

    public static long getNumberCount(long mult){
        if(mult==10)
            return 9;
        else if(mult<10){
            return mult;
        }
        long lessMult = mult / 10;
        long lastDigitGreater = mult-1;
        long lastDigitSmaller = lessMult-1;
        return (lastDigitGreater - lastDigitSmaller)*String.valueOf(lastDigitGreater).length();

    }


}
