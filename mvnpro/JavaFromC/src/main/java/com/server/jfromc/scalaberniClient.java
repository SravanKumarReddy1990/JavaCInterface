package com.server.jfromc;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.*;
import java.net.Socket;
import java.util.*;
import java.util.Base64;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class scalaberniClient  {

    public static String encodeImage(byte[] imageByteArray) {
        return Base64.getEncoder().encodeToString(imageByteArray);
    }

     public static void main(String[] args) {

         //the file to convert is in the same folder as the source code
        File file = new File("/home/ramu/Downloads/PS7-12.png");

        try {            

            //Image conversion to byte array
            FileInputStream imageInFile = new FileInputStream(file);
            byte imageData[] = new byte[(int) file.length()];
            imageInFile.read(imageData);

            //Image conversion byte array in Base64 String
            String imageDataString = encodeImage(imageData);
            imageInFile.close();
            System.out.println("Image Successfully Manipulated!");

            //the object that will be send to Server
            JSONObject obj = new JSONObject();

            //name of the image
            obj.put("filename","newImage.png");
            //string obteined by the conversion of the image
            obj.put("image",imageDataString );

            //connection to erver
            Socket clientSocket= new Socket ("localhost", 7777);
            DataOutputStream outToServer=new DataOutputStream(clientSocket.getOutputStream());
            
            //send data
            outToServer.writeBytes(obj.toJSONString());
            System.out.println("File Sent!");
            
		while(true){
 		BufferedReader inFromClient = new BufferedReader (new InputStreamReader(clientSocket.getInputStream()));
                String message = org.apache.commons.io.IOUtils.toString(inFromClient);
                JSONObject obj1 = (JSONObject) JSONValue.parse(message);
                //convert received data
                System.out.println("result Received!");
		clientSocket.close();
		break;
		}
            //closing connection
            

        } catch (FileNotFoundException e) {
            System.out.println("Image not found" + e);
        } catch (IOException ioe) {
            System.out.println("Exception while reading the Image " + ioe);
        }  

    }

}
