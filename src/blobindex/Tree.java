package blobindex;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;

public class Tree {
	String content;
	
	public Tree (ArrayList<String> keyVal) throws FileNotFoundException {
		content="";
		for (String obj: keyVal) {
			content=content+obj+ " : " + "randomName.txt" + "\n";
		}
		content = content.substring(0, content.length()-1);
		String sha1 = encrypt(content);
		PrintWriter writer = new PrintWriter ("test/objects/" + sha1);
		writer.print(content);
		writer.close();
	}

	private String encrypt(String fileContent) {
		String sha1 = null;
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-1");
	        digest.reset();
	        digest.update(fileContent.getBytes("utf8"));
	        sha1 = String.format("%040x", new BigInteger(1, digest.digest()));
		} catch (Exception e){
			e.printStackTrace();
		}
		return sha1;
	}


	public static void main (String [] args) throws IOException {
		Index git = new Index();
		git.init();
		git.add("foo.txt");
		git.add("bar.txt");
		git.add("foobar.txt");
		
		ArrayList<String> treeList = new ArrayList<String>();
		treeList.add("blob : b66399e65f956699e7ece173e73ab2b4021ff1ab");
		treeList.add("blob : 27d7b0b544c4f31c9051db01c1554b0a544a54e6");
		treeList.add("blob : 3f0b692b963a9a3cc402e74f8b4374538b1125f7");
		
		Tree tree1 = new Tree(treeList);
	
	}
}