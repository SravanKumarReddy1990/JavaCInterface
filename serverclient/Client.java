import contacts.Contact;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
public class Client {
    public static void main(String[] args) throws Exception  {
            Socket socket  = new Socket("localhost",1133);
            Scanner scanner  = new Scanner(System.in);
            ObjectInputStream ois  = new ObjectInputStream( socket.getInputStream());
            // take name from keyboard
            System.out.print("Enter person name : ");
            String name = scanner.nextLine();
            
            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
            pw.println(name);
            
            // read Contact object from server and deserialize it
            Contact contact = (Contact) ois.readObject();

            if ( contact.getMobile() == null) // contact not found
                 System.out.printf("Sorry! %s not found\n", name);
            else
            {
                 System.out.println("Mobile   : " + contact.getMobile());
                 System.out.println("Email    : " + contact.getEmail());
try {
        InputStream is = contact.getInputStream();

        File f = new File("/home/ramu/olaKeAse.jpg");

        OutputStream os = new FileOutputStream((f));
        byte[] buf = new byte[1024];
        int len;

        while ((len = is.read(buf)) > 0) {
            os.write(buf, 0, len);
        }

        os.close();
        is.close();

    } catch (IOException e) {
        System.out.println("Error");
    }
            }
    }
}
