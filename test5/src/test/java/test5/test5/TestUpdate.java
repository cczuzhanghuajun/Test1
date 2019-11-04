package test5.test5;

import java.io.FileNotFoundException;
import java.io.PrintStream;


import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class TestUpdate {

	public static void main(String[] args) throws FileNotFoundException {
		PrintStream out = new PrintStream("out.txt");
		MongoClient cli = new MongoClient("localhost");
		MongoDatabase db = cli.getDatabase("goodsdb");
		MongoCollection<Document> col = db.getCollection("goods");
		long begin = System.currentTimeMillis();
		Document doc = new Document();
		doc.put("name", "zhang");
		col.insertOne(doc);
		for (int i = 0; i < 10000; i++) {
			Document newdoc = new Document();
			newdoc.put("name", "zhang" + i);
			Document update = new Document();
			update.put("$set", newdoc);
			col.updateOne(doc, update);
			doc = newdoc;
		}
		FindIterable<Document> result = col.find();
		MongoCursor<Document> i = result.iterator();
		while (i.hasNext()) {
			doc = i.next();
			out.println(doc);
		}
		long end = System.currentTimeMillis();
		System.out.println(end-begin);
		out.close();
		cli.close();

	}

}
