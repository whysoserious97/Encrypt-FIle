import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class AESMain
{
    public static void main(String[] args)
    {
    String content ="";
        try
        {
//constructor of the File class having file as an argument
            FileReader fr=new FileReader("src//it.jpg");
           // System.out.println("file content: ");
            int r=0;
            while((r=fr.read())!=-1)
            {
                content+=(char)r;
                //System.out.print((char)r);  //prints the content of the file
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }




        final String secretKey = "ssshhhhhhhhhhh!!!!";

        String originalString = content;
        String encryptedString = AES.encrypt(originalString, secretKey) ;
        String decryptedString = AES.decrypt(encryptedString, secretKey) ;

        System.out.println(originalString.equals(decryptedString));
        System.out.println(originalString);
        System.out.println(encryptedString);
        System.out.println(decryptedString);



        try (FileOutputStream fos = new FileOutputStream("output.jpg")) {
            if (decryptedString != null) {
                fos.write(decryptedString.getBytes());
            }
            //fos.close(); There is no more need for this line since you had created the instance of "fos" inside the try. And this will automatically close the OutputStream
        }

        catch (Exception e) {
            e.getStackTrace();
        }
    }
}