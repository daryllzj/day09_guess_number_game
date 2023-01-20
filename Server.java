package sdf;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private int guessNumber;

    public Server() {
    }

    public Server(int guessNumber) {
        this.guessNumber = guessNumber;
    }

    public void runServer(int guessNumber) throws IOException {

        System.out.println("the number is " + guessNumber);

        ServerSocket server = new ServerSocket(3000);

        System.out.println("pending connection...");
        Socket socket = server.accept();
        System.out.println("connection made... ");

        try {
            InputStream is = socket.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            DataInputStream dis = new DataInputStream(bis);
            int guess = 0;

            OutputStream os = socket.getOutputStream();
            BufferedOutputStream bos = new BufferedOutputStream(os);
            DataOutputStream dos = new DataOutputStream(bos);

            while (guess != guessNumber) {
                String strGuess = dis.readUTF();
                guess = Integer.parseInt(strGuess);

                System.out.println("guess was " + guess);

                if (guess > guessNumber) {

                    dos.writeUTF("lower");
                    dos.flush();
                    
                } else if (guess < guessNumber){
        
                    dos.writeUTF("higher");
                    dos.flush();
        
                } else {
                    dos.writeUTF("correct");
                    dos.flush();
                    System.out.println("number was guessed correctly");
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            socket.close();
            server.close();

        }

    }

}

