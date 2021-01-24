package com.model;


import javax.persistence.*;

@Entity
@Table(name = "student_table_1")
public class Student {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "branch")
    private String branch;

    @Column(name = "age")
    private String age;

    @Column(name = "address")

    private String address;

    private String docName;
    private String docType;

    @Lob
    private byte[] data;


    public Student()
    {

    }

    public Student(String docName, String docType, byte[] data) {
        this.docName = docName;
        this.docType = docType;
        this.data = data;
    }

    public Student(long id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getBranch() { return branch; }
    public void setBranch(String branch) { this.branch = branch; }
    public String getAge() { return age; }
    public void setAge(String age) { this.age = age; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}