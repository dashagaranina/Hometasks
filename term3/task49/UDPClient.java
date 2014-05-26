import java.io.*;
import java.net.*;
import java.util.*;

class UDPClient {
    private InetAddress IPAddress;
    boolean done;
    boolean keepGoing;

    public UDPClient(String sHostName) {
        String s1;
        Scanner br;

        try {
            IPAddress = InetAddress.getByName(sHostName);
            System.out.println("Attemping to connect to " + IPAddress + ") via UDP port 54321");
        } catch (UnknownHostException ex) {
            System.err.println(ex);
            System.exit(1);
        }


        // set up the buffered reader to read from the keyboard
        try {
            br = new Scanner(System.in);
            s1 = br.next();

            done = false;

            DatagramSocket clientSocket = new DatagramSocket();
            //for (int i = 0; i < size; i++) {

                byte[] sendData;
                sendData = s1.getBytes();

                DatagramPacket sendPacket =
                        new DatagramPacket(sendData, sendData.length, IPAddress, 54321);

                clientSocket.send(sendPacket);
            //}
            done = true;

            byte[] receiveData = new byte[1024];

            keepGoing = true;

            DatagramPacket receivePacket =
                    new DatagramPacket(receiveData, receiveData.length);

            System.out.println("Waiting for return packet");
            clientSocket.setSoTimeout(10000);

            while (keepGoing) {
                try {
                    clientSocket.receive(receivePacket);
                    String modifiedSentence =
                            new String(receivePacket.getData());
                    System.out.println("Message: " + modifiedSentence);

                } catch (SocketTimeoutException ste) {
                    System.out.println("Timeout Occurred: Packet assumed lost");
                    if (done)
                        keepGoing = false;
                }

            }
            clientSocket.close();
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }


    public static void main(String args[]) throws Exception {
        String serverHostname = "127.0.0.1";

        if (args.length > 0)
            serverHostname = args[0];

        new UDPClient(serverHostname);

    }
} 
