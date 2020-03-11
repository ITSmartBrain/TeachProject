
import javax.imageio.*;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

class Tree{
    int treeVal;
    class Node{
        int nodeVal;
    }
}
public class Main2 {

    public static void main(String[] args) throws IOException {


        double start = 340;
        for (int i = 0; i < 5; i++) {
            start += start * 0.1;
        }
        System.out.println(start);
//        Tree tree = new Tree();
//        Tree.Node node = tree.new Node();


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


//        try (Connection db = DriverManager.getConnection("jdbc:h2:C:/Users/altuk/realEstate", "sa", "")) {
//
//            try (PreparedStatement query =
//                         db.prepareStatement("SELECT * FROM ESTATETYPE")) {
//                ResultSet rs = query.executeQuery();
//                while (rs.next()) {
//                    System.out.println(rs.getString(2));
//                }
//                rs.close();
//            }
//        } catch (SQLException ex) {
//            System.out.println("Database connection failure: "
//                    + ex.getMessage());
//        }


//
//        File file = new File("C:\\Users\\altuk\\Desktop\\trash\\test_photo\\1.png");
//        BufferedImage bi = ImageIO.read(file);
//
        //File file2 = new File("C:\\Users\\altuk\\Desktop\\trash\\test_photo\\3.txt");
//        //ImageIO.write(bi, "png", file2);
//        FileOutputStream fos =  new FileOutputStream(file2);
//        ImageIO.write(bi, "png", fos);
//
//        File file4 = new File("C:\\Users\\altuk\\Desktop\\trash\\test_photo\\4.png");
//        FileInputStream fis = new FileInputStream(file2);
//        BufferedImage bi2 = ImageIO.read(fis);
//        ImageIO.write(bi2, "png", file4);


//        try (Connection db = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/realEstate", "sa", "")) {
//            File[] list = new File("C:\\Users\\altuk\\Desktop\\trash\\test_photo\\flat").listFiles();
//            String[] cities = {"Berlin", "Leipzig"};
//            Random rnd = new Random();
//            for (File file :
//                    list) {
//                FileInputStream fis = new FileInputStream(file);
//                PreparedStatement query =
//                        db.prepareStatement("INSERT INTO ESTATE" +
//                                " (ESTATETYPE_ID, ESTATESTATUS_ID, PRICE, " +
//                                "ROOM_COUNT, SQUARE, FLOOR_COUNT, GARAGE, PHOTO, CITY) VALUES(?,?,?,?,?,?,?,?,?)");
//                query.setInt(1, 3);
//                query.setInt(2, rnd.nextInt(2)+1);
//                query.setDouble(3, rnd.nextInt(2000000)+1000000);
//                query.setInt(4,0);
//                query.setDouble(5, rnd.nextInt(3000)+1000);
//                query.setInt(6,0);
//                query.setInt(7,0);
//                query.setBinaryStream(8, fis);
//                query.setString(9, cities[rnd.nextInt(cities.length)]);
//
//                query.executeUpdate();
//            }
//        } catch (SQLException ex) {
//            System.out.println("Database connection failure: "
//                    + ex.getMessage());
//        }


//        try (Connection db = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/realEstate", "sa", "")) {
//
//            try (PreparedStatement query =
//                         db.prepareStatement("SELECT * FROM ESTATE where ID = 3")) {
//                ResultSet rs = query.executeQuery();
//                while (rs.next()) {
//                    //System.out.println(rs.getString(1));
//                    InputStream is = rs.getBinaryStream(9);
//                    BufferedImage bi2 = ImageIO.read(is);
//                    ImageIO.write(bi2, "jpg", new File("C:\\Users\\altuk\\Desktop\\trash\\test_photo\\4.jpg"));
//                }
//                rs.close();
//            }
//        } catch (SQLException ex) {
//            System.out.println("Database connection failure: "
//                    + ex.getMessage());
//        }






    }




}
class Dish{
    String name;

    public Dish(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        Dish d = (Dish)obj;
        return d.name.equals(name);
    }

    @Override
    public int hashCode() {
        int a = name.charAt(0);
        int b = name.charAt(name.length()-1);
        return a+b;
    }
}
