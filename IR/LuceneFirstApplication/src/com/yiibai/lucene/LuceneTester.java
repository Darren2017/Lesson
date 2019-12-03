package com.yiibai.lucene;

import java.nio.file.Files;
import java.nio.file.Path;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

public class LuceneTester {



    public static void main(String args[]) throws Exception {
        Analyzer analyzer = new StandardAnalyzer();

        Path indexPath = Files.createTempDirectory("tempIndex");
        Directory directory = FSDirectory.open(indexPath);
        IndexWriterConfig config = new IndexWriterConfig(analyzer);
        IndexWriter iwriter = new IndexWriter(directory, config);

        Document doc = new Document();
        String text = " Learn how to build deep learning applications with Pytorch";
        doc.add(new Field("title", text, TextField.TYPE_STORED));
        iwriter.addDocument(doc);

        doc = new Document();
        text = "Learn how to build deep learning applications with TensorFlow";
        doc.add(new Field("title", text, TextField.TYPE_STORED));
        iwriter.addDocument(doc);


        iwriter.close();

        // Now search the index:
        DirectoryReader ireader = DirectoryReader.open(directory);
        IndexSearcher isearcher = new IndexSearcher(ireader);
        // Parse a simple query that searches for "text":
        QueryParser parser = new QueryParser("title", analyzer);
        Query query = parser.parse("deep learning AND (TensorFlow OR Pytorch)");
        ScoreDoc[] hits = isearcher.search(query, 10).scoreDocs;

        System.out.println("hits.length:" + hits.length);

        for (int i = 0; i < hits.length; i++) {
            Document hitDoc = isearcher.doc(hits[i].doc);
            System.out.println("title:" + hitDoc.get("title"));

        }
        ireader.close();
        directory.close();
        //IOUtils.rm(indexPath);

    }
}
