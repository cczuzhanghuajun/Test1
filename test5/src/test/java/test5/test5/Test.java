package test5.test5;

import java.io.FileNotFoundException;
import java.io.PrintStream;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class Test {

	public static void main(String[] args) throws FileNotFoundException {
		PrintStream out = new PrintStream("out.txt");
		MongoClient cli = new MongoClient("localhost");
		MongoDatabase db = cli.getDatabase("goodsdb");
		MongoCollection<Document> col = db.getCollection("goods");
		long begin = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			Document doc = new Document();
			doc.put("name", "zhang" + i);
			col.insertOne(doc);
		}
		FindIterable<Document> result = col.find();
		MongoCursor<Document> i = result.iterator();
		while (i.hasNext()) {
			Document doc = i.next();
			out.println(doc);
		}
		long end = System.currentTimeMillis();
		System.out.println(end-begin);
		out.close();
		cli.close();
	}

}
