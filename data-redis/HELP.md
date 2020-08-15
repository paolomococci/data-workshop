# data-redis

## it creates an element, but at the same time deletes everything that was there
```
$ curl -v -i -H "Content-Type:application/json" -d '{"code":"15004578","name":"six","description":"some description"}' http://127.0.0.1:8080/api/reactive/items
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 8080 (#0)
> POST /api/reactive/items HTTP/1.1
> Host: 127.0.0.1:8080
> User-Agent: curl/7.58.0
> Accept: */*
> Content-Type:application/json
> Content-Length: 65
> 
* upload completely sent off: 65 out of 65 bytes
< HTTP/1.1 201 
HTTP/1.1 201 
< Content-Length: 0
Content-Length: 0
< Date: Sat, 15 Aug 2020 21:08:51 GMT
Date: Sat, 15 Aug 2020 21:08:51 GMT

< 
* Connection #0 to host 127.0.0.1 left intact
```

## in fact, when I now try to retrieve all the records I only get the one just created
```
$ curl -v -i http://127.0.0.1:8080/api/reactive/items
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 8080 (#0)
> GET /api/reactive/items HTTP/1.1
> Host: 127.0.0.1:8080
> User-Agent: curl/7.58.0
> Accept: */*
> 
< HTTP/1.1 200 
HTTP/1.1 200 
< Content-Type: application/hal+json
Content-Type: application/hal+json
< Transfer-Encoding: chunked
Transfer-Encoding: chunked
< Date: Sat, 15 Aug 2020 21:09:07 GMT
Date: Sat, 15 Aug 2020 21:09:07 GMT

< 
{
  "_embedded" : {
    "items" : [ {
      "id" : "ed37656b-3fd5-4e57-bb42-40b161ab43b5",
      "code" : "15004578",
      "name" : "six",
      "description" : "some description",
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:8080/api/reactive/items/ed37656b-3fd5-4e57-bb42-40b161ab43b5"
        },
        "items" : {
          "href" : "http://127.0.0.1:8080/api/reactive/items"
        }
      }
    } ]
  }
* Connection #0 to host 127.0.0.1 left intact
}
```
