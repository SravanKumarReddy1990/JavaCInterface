package com.server.jfromc;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import com.server.jfromc.postgres.Login;


public class scalaberniServer {

    public static byte[] decodeImage(String imageDataString) {
        return Base64.getDecoder().decode(imageDataString);
    }

    public static void main(String[] args) {

        while (true){

            try{  
 
                //socket connection (PORT 7777)
                ServerSocket welcomeSocket=new ServerSocket(7777);
                Socket connectionSocket=welcomeSocket.accept();
                BufferedReader inFromClient = new BufferedReader (new InputStreamReader(connectionSocket.getInputStream()));
                
                //convert received data
                System.out.println("File Received!");
                String message = org.apache.commons.io.IOUtils.toString(inFromClient);
                JSONObject obj1 = (JSONObject) JSONValue.parse(message);
		String opp=obj1.get("opp").toString();
		if(opp.equals("login")){
			Login login=new Login();
			JSONObject res=login.login(obj1);
		
	

		}else{
                String name = obj1.get("filename").toString();
                String image = obj1.get("image").toString();      

                //convert from base64 to byte array
                byte[] imageByteArray = decodeImage(image);

                //convert byte array to a file image
                FileOutputStream imageOutFile = new FileOutputStream(name);
                imageOutFile.write(imageByteArray);
                imageOutFile.close();
                System.out.println("Image Successfully Manipulated!");
		}
            } 
            catch (FileNotFoundException e) {
            } 
            catch (IOException e) {
            } 
        }
    }
}

