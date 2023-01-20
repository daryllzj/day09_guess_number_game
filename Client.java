package sdf;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Console;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    public static void main(String[] args) throws UnknownHostException, IOException {
        
        Socket socket = new Socket("localhost", 3000);
        System.out.println("connection with server has been made... ");

        try {
            OutputStream os = socket.getOutputStream();
            BufferedOutputStream bos = new BufferedOutputStream(os);
            DataOutputStream dos = new DataOutputStream(bos);

            Console cons = System.console();
            String readInput = "", receivedMessaged = "";

            InputStream is = socket.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            DataInputStream dis = new DataInputStream(bis);

            while (readInput != "close") {
                readInput = cons.readLine("guess a number> ");

                dos.writeUTF(readInput);
                dos.flush();

                receivedMessaged = dis.readUTF();
                if (receivedMessaged.equals("correct")) {
                    System.out.println(receivedMessaged);
                    break;
                }
                System.out.println(receivedMessaged);
                
            }

            dis.close();
            bis.close();
            is.close();
            dos.close();
            bos.close();
            os.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        socket.close();

        
    }
    
}
