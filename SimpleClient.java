package edu.fee;

import java.io.*;
import java.net.Socket;

public class SimpleClient {
    public static void main(String[] args) throws IOException {
        System.out.println("Client started");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Socket socket = new Socket("localhost",5050);


        InputStream inputStream = socket.getInputStream();
        DataInputStream socketDIS = new DataInputStream(inputStream);
		
		
		
        String serverMsg = socketDIS.readUTF();
        System.out.println(serverMsg);


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        OutputStream outputStream = socket.getOutputStream();
        DataOutputStream socketDOS = new DataOutputStream(outputStream);
        String clientMsg = "Client: Hi Server, How are you!!";
        socketDOS.writeUTF(clientMsg);
        System.out.println(clientMsg);
		
		BufferedReader userInput = new BufferedReader( new InputStreamReader (System.in));

        System.out.println ("Enter a massage ");
        String str = userInput.readLine();
		
		socketDOS.writeUTF(str);
        System.out.println(str);
		
		
        String serverMsg = socketDIS.readUTF();
        System.out.println(serverMsg);
		
		

        socketDOS.close();
        socketDIS.close();
        socketOutputStream.close();
        socketInputStream.close();
        socket.close();
    }
}
