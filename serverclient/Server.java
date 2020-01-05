import contacts.Contact;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
public class Server {
    public static void main(String[] args) throws Exception {
ObjectInputStream is = new ObjectInputStream(new BufferedInputStream(
            new FileInputStream("/home/ramu/Downloads/PS7-12.png")));
        ArrayList<Contact>  contacts = new ArrayList<>();
        contacts.add(new Contact("Steve","9090909090","steve@gmail.com",is));
        contacts.add(new Contact("Bill","9988776655","bill@hotmail.com",is));
        contacts.add(new Contact("Jack","9876543210","jack@yaho.com",is));
        contacts.add(new Contact("Larry","8877996655","larry@gmail.com",is));

        ServerSocket serversocket  = new ServerSocket(1133,10);
        System.out.println("Contacts server is ready ....");

        while(true) {
            Socket client = serversocket.accept();
            // take input and output streams
            Scanner scanner  = new Scanner(client.getInputStream());
            ObjectOutputStream oos  = new ObjectOutputStream( client.getOutputStream());
            // find contact with the given name
            String name = scanner.nextLine();
            boolean found = false;
            for(Contact c : contacts) {
                if ( c.getName().equals(name))
                {
                    found = true;
                    oos.writeObject(c);  // serialize object and send to client 
                }
            }
            if (!found) {
                // write Contact object only with name when name is not found
                oos.writeObject(new Contact(name,null,null,null)); 
            }
            client.close();
        } // while 
    } // main()
} // class
