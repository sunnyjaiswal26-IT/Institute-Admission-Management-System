package com.example.mongodb;
import com.example.mongodb.home;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class page1 extends JFrame implements ActionListener {
    JLabel name=new JLabel("Name: ");
    JLabel Dob=new JLabel("DOB: ");
    JLabel addharno=new JLabel("Adhar card:");
    JLabel address=new JLabel("Address:");
    JLabel age=new JLabel("Age:");
    JLabel std=new JLabel("Standard:");
    JLabel contect=new JLabel("Conntect No:");

    JTextField name1=new JTextField();
    JTextField Dob1=new JTextField();
    JTextField addharno1=new JTextField();
    JTextField address1=new JTextField();
    JTextField std1=new JTextField();
    JTextField contect1=new JTextField();

    JButton submit=new JButton("Submit");
    JButton back=new JButton("Back");

    ImageIcon img=new ImageIcon("th4.jpg");

    JPanel p=new JPanel();
    JPanel p1=new JPanel();
    JLabel l=new JLabel(img);

    JTextField age1=new JTextField();
    page1(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(900,700);

        Color semiTransparentColor = new Color(187, 214, 243, 128);

        p.setBounds(0,0,900,700);

        p.setOpaque(true);
        p.add(l);

        p1.setLayout(null);
        p1.setBounds(0,0,900,700);
        p1.setOpaque(false);
        p1.setBackground(Color.white);
        l.add(p1);
        this.add(p);

        p1.setForeground(new Color(6, 135, 8));
        JLabel jLabel=new JLabel("New Addmission");
        jLabel.setForeground(new Color(12, 34, 80));
        jLabel.setBounds(100,50,350,50);
        jLabel.setBackground(Color.yellow);
        jLabel.setFont(new Font("Arial",Font.BOLD,40));
        p1.add(jLabel);

        name.setBounds(150,150,180,40);
        name.setOpaque(true);
        name.setBackground(semiTransparentColor);
        name.setForeground(new Color(12, 34, 80));
        name.setFont(new Font("Arial",Font.BOLD,30));
        p1.add(name);

        Dob.setBounds(150,200,180,40);
        Dob.setOpaque(true);
        Dob.setBackground(semiTransparentColor);
        Dob.setForeground(new Color(12, 34, 80));
        Dob.setFont(new Font("Arial",Font.BOLD,30));
        p1.add(Dob);

        address.setBounds(150,250,180,40);
        address.setForeground(new Color(12, 34, 80));
        address.setOpaque(true);
        address.setBackground(semiTransparentColor);

        address.setFont(new Font("Arial",Font.BOLD,30));
        p1.add(address);

        addharno.setBounds(150,300,180,40);
        addharno.setOpaque(true);
        addharno.setBackground(semiTransparentColor);
        addharno.setForeground(new Color(12, 34, 80));
        addharno.setFont(new Font("Arial",Font.BOLD,30));
        p1.add(addharno);

        age.setBounds(150,350,180,40);
        age.setForeground(new Color(12, 34, 80));
        age.setOpaque(true);
        age.setBackground(semiTransparentColor);
        age.setFont(new Font("Arial",Font.BOLD,30));
        p1.add(age);

        std.setBounds(150,400,180,40);
        std.setForeground(new Color(12, 34, 80));
        std.setOpaque(true);
        std.setBackground(semiTransparentColor);
        std.setFont(new Font("Arial",Font.BOLD,30));
        p1.add(std);

        contect.setBounds(150,450,190,40);
        contect.setForeground(new Color(12, 34, 80));
        contect.setOpaque(true);
        contect.setBackground(semiTransparentColor);
        contect.setFont(new Font("Arial",Font.BOLD,30));
        p1.add(contect);

        name1.setBounds(340,150,350,40);
        name1.setFont(new Font("Arial",Font.BOLD,20));
        p1.add(name1);

        Dob1.setBounds(340,200,350,40);
        Dob1.setFont(new Font("Arial",Font.BOLD,20));
        p1.add(Dob1);

        address1.setBounds(340,250,350,40);
        address1.setFont(new Font("Arial",Font.BOLD,20));
        p1.add(address1);

        addharno1.setBounds(340,300,350,40);
        addharno1.setFont(new Font("Arial",Font.BOLD,20));
        p1.add(addharno1);

        age1.setBounds(340,350,350,40);
        age1.setFont(new Font("Arial",Font.BOLD,20));
        p1.add(age1);

        std1.setBounds(340,400,350,40);
        std1.setFont(new Font("Arial",Font.BOLD,20));
        p1.add(std1);

        contect1.setBounds(340,450,350,40);
        contect1.setFont(new Font("Arial",Font.BOLD,20));
        p1.add(contect1);

        submit.setBounds(530,520,100,35);
        submit.addActionListener(this);
        submit.setFont(new Font("Arial",Font.BOLD,20));
        p1.add(submit);

        back.setBounds(390,520,100,35);
        back.addActionListener(this);
        back.setFont(new Font("Arial",Font.BOLD,20));
        p1.add(back);

        this.setVisible(true);

    }

    public static void main(String[] args) {
        page1 p=new page1();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submit){
            String uri = "mongodb://localhost:27017";
            // Create a MongoDB client
            try (MongoClient mongoClient = MongoClients.create(uri)) {
                // Connect to 'student' database
                MongoDatabase database = mongoClient.getDatabase("student");
                // Get 'info' collection
                MongoCollection<Document> collection = database.getCollection("info");
            Document student = new Document("name", name1.getText())
                    .append("DOB", Dob1.getText())
                    .append("Address", address1.getText())
                    .append("addharno",addharno1.getText())
                    .append("current age",age1.getText())
                    .append("Standrd",std1.getText())
                    .append("contact",contect1.getText());

            collection.insertOne(student);
                System.out.println("✅ Document inserted successfully!");

                // Read all documents from 'info' collection
                System.out.println("📋 All Students in 'info' Collection:");
                for (Document doc : collection.find()) {
                    System.out.println(doc.toJson());
                }
            } catch (Exception er) {
                System.out.println("❌ Error: " + er.getMessage());
            }
           JOptionPane.showMessageDialog(null,"New one Added");}
        if(e.getSource()==back){
            this.setVisible(false);
            home h=new home();
        }}}
