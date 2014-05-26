package serialization;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

public class task51 {
    public static void main(String[] args) {
        ObjectOutputStream out = null;
        ObjectInputStream in = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream("out.txt"));
            in = new ObjectInputStream(new FileInputStream("out.txt"));
            Path path = Paths.get("img/logo.jpg");
            byte [] photo = Files.readAllBytes(path);
            Student student = new Student("Pavlov", "Ivan", 112105, photo, null);

            System.out.println("Sending data: " + student + " to Server");
            out.writeObject(student);
            out.flush();
            System.out.println("Send data, waiting for return value");
        } catch (IOException e) {
            e.printStackTrace();
        }



        Student student1 = null;
        try {
            student1 = (Student) in.readObject();
//            Date date = new Date();
//            student1.setModDate(date);
        } catch (Exception ex) {
            ex.printStackTrace();

        }
        System.out.println("Got data: " + student1 + " from Server");
    }
}



