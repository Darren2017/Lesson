package com.guendouz.textclustering.preprocessing;

import java.util.Arrays;
import java.util.List;

/**
 * @author Mohamed Guendouz
 */
public class TFIDFCalculator {
    /**
     * @param doc  list of strings
     * @param term String represents a term
     * @return term frequency of term in document
     */
    public double tf(List<String> doc, String term) {
        double result = 0;
        for (String word : doc) {
            if (term.equalsIgnoreCase(word))
                result++;
        }
        return result / doc.size();
    }

    /**
     * @param docs list of list of strings represents the dataset
     * @param term String represents a term
     * @return the inverse term frequency of term in documents
     */
    public double idf(List<List<String>> docs, String term) {
        double n = 0;
        for (List<String> doc : docs) {
            for (String word : doc) {
                if (term.equalsIgnoreCase(word)) {
                    n++;
                    break;
                }
            }
        }
        return Math.log(docs.size() / n);
    }

    /**
     * @param doc  a text document
     * @param docs all documents
     * @param term term
     * @return the TF-IDF of term
     */
    public double tfIdf(List<String> doc, List<List<String>> docs, String term) {
        return tf(doc, term) * idf(docs, term);

    }

    public static void main(String[] args) {
    	
    	String doc1 = "Information retrieval is the science of searching in a document";
        String doc2 = "Information can be thought of as the resolution of uncertainty";
        String doc3 = "Image retrieval takes place at the display workstations that are connected to the archive system through the communication network.";
        String doc4 = "The Information has a simple mission: deliver important, deeply reported stories about the technology business you won't find elsewhere.";

        List<String> a = Arrays.asList(doc1.split("\\s+"));
        List<String> b = Arrays.asList(doc2.split("\\s+"));
        List<String> c = Arrays.asList(doc3.split("\\s+"));
        List<String> d = Arrays.asList(doc4.split("\\s+"));
        List<List<String>> documents = Arrays.asList(a, b, c, d);

        TFIDFCalculator calculator = new TFIDFCalculator();
        double tfidf_in = calculator.tfIdf(b, documents, "information");
        double tfidf_re= calculator.tfIdf(b, documents, "retrieval");
        System.out.println("TF-IDF (information) - TF-IDF (retrieval) = " + (tfidf_in - tfidf_re));


    }


}

