package serialization;

import java.net.*;
import java.io.*;
import java.util.Date;

public class SerialServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(10007);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 10007.");
            System.exit(1);
        }

        Socket clientSocket = null;

        try {
            System.out.println("Waiting for Client");
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }

        ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());


        Student student = null;
        Student student1;

        try {
            student = (Student) in.readObject();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }


        System.out.println("Server recieved data: " + student + " from Client");

        student1 = student;
//        Date date = new Date();
//
//        student1.setModDate(date);
        System.out.println("Server sending point: " + student1 + " to Client");
        out.writeObject(student1);
        out.flush();




        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
} 