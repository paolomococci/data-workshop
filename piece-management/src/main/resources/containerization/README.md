# How to use:

```
$ mkdir -p $HOME/postgres/test/data
$ podman build --tag postgres_image .
$ podman images 
$ podman run --rm -t -i --name postgres_container -e POSTGRES_PASSWORD=password -v $HOME/postgres/test/data -p 5432:5432 postgres_image postgres
```
## At this time, it is necessary to create the database and the tables that will host the data.
In the project dependency cache there should be the jar file needed to connect your favorite IDE to the containerized database server.

Use this driver to create a connection between your IDE and the database server.

Finally, create the database and tables before starting to test the application.
