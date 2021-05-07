package com.piedaholic.examples;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import com.piedaholic.io.ObjectWriter;

class A implements Serializable {
    private B b = new B();
}

class B implements Serializable {
    private C c = new C();

}

class C {

}

class D implements Serializable {
    private E e = new E();
    private int id = 1;
}

class E implements Serializable {
    private transient F f = new F(); // making class F as Serializable will also make D serializable
    private int id = 2;
}

class F  {
    private int id = 3;
}

class G implements Serializable{
    private H h;
}

class H {
    private int id;
}

public class SerializationExamples {

    public static void main(String... args) {
        A a = new A();
        try {
            ObjectWriter.writeObject(a, new File("E:\\Harsh.txt"));
            System.out.println("Object Written Successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
        D d = new D();
        try {
            ObjectWriter.writeObject(d, new File("E:\\Harsh.txt"));
            System.out.println("Object Written Successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
        G g = new G();
        try {
            ObjectWriter.writeObject(g, new File("E:\\Harsh.txt"));
            System.out.println("Object Written Successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
