import java.io.*;

import org.apache.lucene.analysis.standard.*;
import org.apache.lucene.document.*;
import org.apache.lucene.index.*;
import org.apache.lucene.store.*;
import org.apache.lucene.util.*;
import org.apache.lucene.search.*;

public class LuceneTester {

    public static void main(String[] args) {
        Analyzer analyzer = new StandardAnalyzer();

        Path indexPath = Files.createTempDirectory("tempIndex");
        Directory directory = FSDirectory.open(indexPath);
        IndexWriterConfig config = new IndexWriterConfig(analyzer);
        IndexWriter iwriter = new IndexWriter(directory, config);
        Document doc = new Document();
        String text = "This is the text to be indexed.";
        doc.add(new Field("fieldname", text, TextField.TYPE_STORED));
        iwriter.addDocument(doc);
        iwriter.close();

        // Now search the index:
        DirectoryReader ireader = DirectoryReader.open(directory);
        IndexSearcher isearcher = new IndexSearcher(ireader);
        // Parse a simple query that searches for "text":
        QueryParser parser = new QueryParser("fieldname", analyzer);
        Query query = parser.parse("text");
        ScoreDoc[] hits = isearcher.search(query, 10).scoreDocs;
        assertEquals(1, hits.length);
        // Iterate through the results:
        for (int i = 0; i < hits.length; i++) {
            Document hitDoc = isearcher.doc(hits[i].doc);
            assertEquals("This is the text to be indexed.", hitDoc.get("fieldname"));
        }
        ireader.close();
        directory.close();
        IOUtils.rm(indexPath);
    }

}