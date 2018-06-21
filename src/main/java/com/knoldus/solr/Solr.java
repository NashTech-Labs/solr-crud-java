package com.knoldus.solr;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.request.AbstractUpdateRequest;
import org.apache.solr.client.solrj.request.UpdateRequest;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;

import java.io.IOException;

public class Solr {
    private static String coreName = "newCore";
    private static String solrurl = "http://localhost:8983/solr/"+coreName;
    private static SolrClient solr = new HttpSolrClient.Builder(solrurl).build();

    public static void main(String args[]) throws IOException, SolrServerException {
        SolrInputDocument doc = new SolrInputDocument();

        addField(doc,1,"Ayush",24,"delhi");
        read("name:Ayush");
    }
    private static void addField(SolrInputDocument document,int id,String name,int age,String addr) throws IOException, SolrServerException {
        document.addField("id",id);
        document.addField("name",name);
        document.addField("age",age);
        document.addField("addr",addr);
        solr.add(document);
        solr.commit();
    }

    private static void read(String query) throws IOException, SolrServerException {

        SolrQuery searchQuery = new SolrQuery();
        searchQuery.setQuery(query);
        searchQuery.addField("name");
        searchQuery.addField("age");
        QueryResponse response = solr.query(searchQuery);
        SolrDocumentList docs = response.getResults();
        System.out.println(docs.get(0));

    }
}
