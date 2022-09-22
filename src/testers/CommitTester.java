package testers;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import blobindex.Blob;
import blobindex.Commit;
import blobindex.Index;

class CommitTester {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		File objFolder = new File("objects");
		objFolder.mkdirs();
		PrintWriter writer = new PrintWriter("testFile.txt");
		writer.println("test 1");
		writer.close();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		File f = new File("testFile.txt");
		f.delete();
		File objFolder = new File("objects");
		objFolder.delete();

	}

	@Test
	void testCommit() throws IOException {
		Index index = new Index();
		index.init();
	

		Blob newBlob = new Blob("testFile.txt");
	
		Commit a = new Commit("test/objects/" + newBlob.getSha1(), "", "JB", null);

	
	}
}
