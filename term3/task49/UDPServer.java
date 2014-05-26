import java.io.BufferedReader;
import java.io.FileReader;
import java.net.*;

class UDPServer {
    public static void main(String args[]) throws Exception {
        try {
            DatagramSocket serverSocket = new DatagramSocket(54321);

            byte[] receiveData;
            byte[] sendData;
            String news="";

            //while (true) {
                receiveData = new byte[1024];
                DatagramPacket receivePacket =
                        new DatagramPacket(receiveData, receiveData.length);
                System.out.println("Waiting for datagram packet");
                serverSocket.receive(receivePacket);
                String sentence = new String(receivePacket.getData());
                if (sentence!=""){
                    InetAddress IPAddress = receivePacket.getAddress();
                    int port = receivePacket.getPort();
                    System.out.println("From: " + IPAddress + ":" + port);
                    System.out.println("Message: " + sentence);
                    BufferedReader bf = new BufferedReader(new FileReader("UDPInputFile.txt"));
                    String s1 = bf.readLine();
                    int l=0;
                    while (s1 != null && l<10) {
                        news+=" "+s1;
                        s1 = bf.readLine();
                        l++;
                    }

                    String capitalizedSentence = news.toUpperCase();
                    sendData = capitalizedSentence.getBytes();
                    DatagramPacket sendPacket =
                            new DatagramPacket(sendData, sendData.length, IPAddress, port);
                    serverSocket.send(sendPacket);
               // }
            }
        } catch (SocketException ex) {
            System.out.println("UDP Port 54321 is occupied.");
            System.exit(1);
        }

    }
}  
