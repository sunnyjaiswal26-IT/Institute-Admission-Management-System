package com.example.mongodb;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import static java.awt.Color.green;
import static java.awt.Color.pink;

public class home extends JFrame implements ActionListener {
    JLabel school=new JLabel("Unkown Institute of Technology");



    JButton add=new JButton("Add New Addmision");
    JButton all=new JButton("Get All student");
    JButton delete=new JButton("Delete Student");

    ImageIcon img=new ImageIcon("th6.jpg");

    JPanel p=new JPanel();
    JPanel p1=new JPanel();
    JLabel l=new JLabel(img);
    home(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,500);
        this.setLayout(null);

        Color semiTransparentColor = new Color(187, 214, 243, 128);

        school.setFont(new Font("Arial",Font.BOLD,35));
        school.setBounds(165,10,600,40);
        school.setOpaque(true);
        school.setBackground(semiTransparentColor);
        p1.add(school);

        p.setBounds(0,0,600,500);
        p.setOpaque(true);
        p.add(l);

        p1.setLayout(null);
        p1.setBounds(0,0,700,500);
        p1.setOpaque(false);
        l.add(p1);
        this.add(p);

        all.setBounds(200,200,200,40);
        all.addActionListener(this);
        p1.add(all);

        delete.setBounds(450,200,200,40);
        delete.addActionListener(this);
        p1.add(delete);

        add.setBounds(350,300,200,40);
        add.addActionListener(this);
        p1.add(add);

        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
if(e.getSource()==add){
    page1 p=new page1();
} else if (e.getSource()==delete) {
    String a=JOptionPane.showInputDialog("Enter the connect number of student you want to delete");
    String uri = "mongodb://localhost:27017";
    try (MongoClient mongoClient = MongoClients.create(uri)) {
        MongoDatabase database = mongoClient.getDatabase("student");
        MongoCollection<Document> collection = database.getCollection("info");
        for (Document doc : collection.find()) {
            System.out.println(doc.toJson());
        }
        DeleteResult result = collection.deleteOne(Filters.eq("contact",a));
        if (result.getDeletedCount() > 0) {
            JOptionPane.showMessageDialog(null,"successfully deleted");
        } else {
            JOptionPane.showMessageDialog(null,"student with this contact not exist");
        }
    }
} else if (e.getSource()==all) {
    this.setVisible(false);
    String uri = "mongodb://localhost:27017";
    try (MongoClient mongoClient = MongoClients.create(uri)) {
        MongoDatabase database = mongoClient.getDatabase("student");
        MongoCollection<Document> collection = database.getCollection("info");

        JFrame f=new JFrame();
        f.setLayout(null);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        f.setSize(600,500);
        int y=10;
        for (Document doc : collection.find()) {
            String name = doc.getString("name");
            String n2 = doc.getString("DOB");
            String n3 = doc.getString("Address");
            String n4 = doc.getString("addharno");
            String n5 = doc.getString("current age");
            String n6 = doc.getString("Standard");
            String n7 = doc.getString("contact");

            String s = "<html>name: " + name + "<br>DOB: " + n2 + "<br>Address: " + n3 +
                    "<br>Addhar No: " + n4 + "<br>Age: " + n5 + "<br>Standard: " + n6 +
                    "<br>Contact: " + n7 + "</html>";

            JButton up=new JButton("Update");
            JLabel l = new JLabel(s);
            l.setOpaque(true);
            l.setBackground(new Color(255, 192, 203, 128)); // PINK with 50% transparency
            l.setBounds(10, y, 300, 130);
            l.setBorder(BorderFactory.createLineBorder(Color.BLACK));

            up.setBounds(180,40,100,35);
            up.setOpaque(true);
            up.setBackground(new Color(37, 228, 41));
            l.add(up);

            f.add(l);
            y += 140;
        }
        f.setVisible(true);
    }}}
    public static void main(String[] args) {
        home h=new home();
    }}
