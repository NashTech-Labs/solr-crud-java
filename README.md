# solr-crud-java
This code will help you interact with the Solr server and perform basic CRUD operations. This requires the installation of a Solr instance on the system, details of which can be found <a href ="https://lucene.apache.org/solr/guide/6_6/installing-solr.html#installing-solr"> here</a>.
Before running this code, make sure the instance of Solr you're trying to connect to is up. Start the server by the command './solr start' or at a specific port using './solr start -p portnumber'.<br/><br/>
Once you're done with the given code, simply run the main function to see the processing. The file can be run using the following commands on the terminal:
- javac src/main/java/com/knoldus/solr/Solr.java
- java src/main/java/com/knoldus/solr/Solr<br/>

All the solr documents can be checked on the localhost :
- Open the webpage of SolrAdmin (http://localhost:8983/solr/ by default).
- Select a core/collection.
- Use the query to search for any document(\*:\* to search all the documents in the collection)
