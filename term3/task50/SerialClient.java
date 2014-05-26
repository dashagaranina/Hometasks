package serialization;

import java.io.*;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SerialClient {
    public static void main(String[] args) throws IOException {

        Socket echoSocket = null;
        ObjectOutputStream out = null;
        ObjectInputStream in = null;

        try {
            echoSocket = new Socket("127.0.0.1", 10007);

            out = new ObjectOutputStream(echoSocket.getOutputStream());
            in = new ObjectInputStream(echoSocket.getInputStream());

        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: taranis.");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for "
                    + "the connection to: taranis.");
            System.exit(1);
        }

        Path path = Paths.get("img/logo.jpg");
        byte [] photo = Files.readAllBytes(path);
        Student student = new Student("Pavlov", "Ivan", 112105, photo, null);
        Student student1 = null;
        System.out.println("Sending data: " + student + " to Server");
        out.writeObject(student);
        out.flush();
        System.out.println("Send data, waiting for return value");

        try {
            student1 = (Student) in.readObject();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("Got data: " + student1 + " from Server");



        out.close();
        in.close();
        echoSocket.close();
    }
}
