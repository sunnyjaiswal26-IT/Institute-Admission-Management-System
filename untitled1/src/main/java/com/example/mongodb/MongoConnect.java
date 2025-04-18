package com.example.mongodb;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class MongoConnect {
    public static void main(String[] args) {
        // MongoDB URI (local)
        String uri = "mongodb://localhost:27017";

        // Create a MongoDB client
        try (MongoClient mongoClient = MongoClients.create(uri)) {

            // Connect to 'student' database
            MongoDatabase database = mongoClient.getDatabase("student");

            // Get 'info' collection
            MongoCollection<Document> collection = database.getCollection("info");

            // Insert sample student data
            Document student = new Document("name", "Sunny Jaiswal")
                    .append("roll", 101)
                    .append("branch", "IT")
                    .append("year", "Second");

            collection.insertOne(student);
            System.out.println("✅ Document inserted successfully!");

            // Read all documents from 'info' collection
            System.out.println("📋 All Students in 'info' Collection:");
            for (Document doc : collection.find()) {
                System.out.println(doc.toJson());
            }

        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }
}


