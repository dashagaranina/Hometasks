package serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

public class Student implements Serializable{
    private String lastname;
    private String name;
    private int group;
    private transient byte [] photo;
    private transient Date modDate;

    public Student(String lastname, String name, int group, byte[] photo, Date modDate) {
        this.lastname = lastname;
        this.name = name;
        this.group = group;
        this.photo = photo;
        this.modDate = modDate;
    }

     public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public Date getModDate() {
        return modDate;
    }

    public void setModDate(Date modDate) {
        this.modDate = modDate;
    }

    @Override
    public String toString() {
        return "Student{" +
                "lastname='" + lastname + '\'' + "\n" +
                ", name='" + name + '\'' +  "\n" +
                ", group=" + group +  "\n" +
                ", photo=" + Arrays.toString(photo) +"\n" +
                ", modDate='" + modDate + '\'' +
                '}';
    }


    private void readObject(
            ObjectInputStream aInputStream
    ) throws ClassNotFoundException, IOException {
        //always perform the default de-serialization first
        aInputStream.defaultReadObject();
        Date date = new Date();
        modDate =date;
    }


    private void writeObject(
            ObjectOutputStream aOutputStream
    ) throws IOException {
        //perform the default serialization for all non-transient, non-static fields
        aOutputStream.defaultWriteObject();
    }


}
