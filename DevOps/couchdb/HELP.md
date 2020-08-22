# CouchDB containerized

## from within the directory where the Dockerfile is, you can run the following commands:

```
$ sudo docker build --tag couchdb_image .
$ sudo docker run -d --name couchdb_container -e COUCHDB_USER=admin -e COUCHDB_PASSWORD=password -p 5984:5984 couchdb_image
```
