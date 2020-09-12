# mongodb-reactive-rest-provider

## to start interacting with the service:
```
$ curl -v -i http://127.0.0.1:8081
* Rebuilt URL to: http://127.0.0.1:8081/
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 8081 (#0)
> GET / HTTP/1.1
> Host: 127.0.0.1:8081
> User-Agent: curl/7.58.0
> Accept: */*
> 
< HTTP/1.1 200 
HTTP/1.1 200 
< Vary: Origin
Vary: Origin
< Vary: Access-Control-Request-Method
Vary: Access-Control-Request-Method
< Vary: Access-Control-Request-Headers
Vary: Access-Control-Request-Headers
< Content-Type: application/hal+json
Content-Type: application/hal+json
< Transfer-Encoding: chunked
Transfer-Encoding: chunked
< Date: Sat, 12 Sep 2020 14:31:42 GMT
Date: Sat, 12 Sep 2020 14:31:42 GMT

< 
{
  "_links" : {
    "accounts" : {
      "href" : "http://127.0.0.1:8081/accounts"
    },
    "profile" : {
      "href" : "http://127.0.0.1:8081/profile"
    }
  }
* Connection #0 to host 127.0.0.1 left intact
}
```

## to list all records, (there still isn't one):
```
$ curl -v -i http://127.0.0.1:8081/accounts
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 8081 (#0)
> GET /accounts HTTP/1.1
> Host: 127.0.0.1:8081
> User-Agent: curl/7.58.0
> Accept: */*
> 
< HTTP/1.1 200 
HTTP/1.1 200 
< Content-Type: application/json
Content-Type: application/json
< Transfer-Encoding: chunked
Transfer-Encoding: chunked
< Date: Sat, 12 Sep 2020 14:42:42 GMT
Date: Sat, 12 Sep 2020 14:42:42 GMT

< 
* Connection #0 to host 127.0.0.1 left intact
[]
```

## I start create a couple:
```
$ curl -v -i -H "Content-Type:application/json" -d '{"name":"James","password":"123password"}' http://127.0.0.1:8081/accounts
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 8081 (#0)
> POST /accounts HTTP/1.1
> Host: 127.0.0.1:8081
> User-Agent: curl/7.58.0
> Accept: */*
> Content-Type:application/json
> Content-Length: 41
> 
* upload completely sent off: 41 out of 41 bytes
< HTTP/1.1 200 
HTTP/1.1 200 
< Content-Type: application/json
Content-Type: application/json
< Transfer-Encoding: chunked
Transfer-Encoding: chunked
< Date: Sat, 12 Sep 2020 14:51:40 GMT
Date: Sat, 12 Sep 2020 14:51:40 GMT

< 
* Connection #0 to host 127.0.0.1 left intact
{"id":"5f5ce07c5bdca12f5895308b","name":"James","password":"123password"}
$ curl -v -i -H "Content-Type:application/json" -d '{"name":"Luise","password":"456password"}' http://127.0.0.1:8081/accounts
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 8081 (#0)
> POST /accounts HTTP/1.1
> Host: 127.0.0.1:8081
> User-Agent: curl/7.58.0
> Accept: */*
> Content-Type:application/json
> Content-Length: 41
> 
* upload completely sent off: 41 out of 41 bytes
< HTTP/1.1 200 
HTTP/1.1 200 
< Content-Type: application/json
Content-Type: application/json
< Transfer-Encoding: chunked
Transfer-Encoding: chunked
< Date: Sat, 12 Sep 2020 14:53:09 GMT
Date: Sat, 12 Sep 2020 14:53:09 GMT

< 
* Connection #0 to host 127.0.0.1 left intact
{"id":"5f5ce0d55bdca12f5895308c","name":"Luise","password":"456password"}
```

## I go back to listing all the records:
```
$ curl -v -i http://127.0.0.1:8081/accounts
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 8081 (#0)
> GET /accounts HTTP/1.1
> Host: 127.0.0.1:8081
> User-Agent: curl/7.58.0
> Accept: */*
> 
< HTTP/1.1 200 
HTTP/1.1 200 
< Content-Type: application/json
Content-Type: application/json
< Transfer-Encoding: chunked
Transfer-Encoding: chunked
< Date: Sat, 12 Sep 2020 14:53:44 GMT
Date: Sat, 12 Sep 2020 14:53:44 GMT

< 
* Connection #0 to host 127.0.0.1 left intact
[{"id":"5f5ce07c5bdca12f5895308b","name":"James","password":"123password"},{"id":"5f5ce0d55bdca12f5895308c","name":"Luise","password":"456password"}]
```

## now I try to use an identifier:
```
$ curl -v -i http://127.0.0.1:8081/accounts/5f5ce07c5bdca12f5895308b
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 8081 (#0)
> GET /accounts/5f5ce07c5bdca12f5895308b HTTP/1.1
> Host: 127.0.0.1:8081
> User-Agent: curl/7.58.0
> Accept: */*
> 
< HTTP/1.1 200 
HTTP/1.1 200 
< Content-Type: application/json
Content-Type: application/json
< Transfer-Encoding: chunked
Transfer-Encoding: chunked
< Date: Sat, 12 Sep 2020 14:57:50 GMT
Date: Sat, 12 Sep 2020 14:57:50 GMT

< 
* Connection #0 to host 127.0.0.1 left intact
{"id":"5f5ce07c5bdca12f5895308b","name":"James","password":"123password"}
```

## I try to use an identifier to update a field:
```
$ curl -v -i -H "Content-Type:application/json" -X PATCH  -d '{"password":"789password"}' http://127.0.0.1:8081/accounts/5f5ce07c5bdca12f5895308b
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 8081 (#0)
> PATCH /accounts/5f5ce07c5bdca12f5895308b HTTP/1.1
> Host: 127.0.0.1:8081
> User-Agent: curl/7.58.0
> Accept: */*
> Content-Type:application/json
> Content-Length: 26
> 
* upload completely sent off: 26 out of 26 bytes
< HTTP/1.1 200 
HTTP/1.1 200 
< Content-Type: application/json
Content-Type: application/json
< Transfer-Encoding: chunked
Transfer-Encoding: chunked
< Date: Sat, 12 Sep 2020 15:21:14 GMT
Date: Sat, 12 Sep 2020 15:21:14 GMT

< 
* Connection #0 to host 127.0.0.1 left intact
{"id":"5f5ce07c5bdca12f5895308b","name":"James","password":"789password"}
```

## I try to delete a record using its identifier string:
```
$ curl -v -i -X DELETE http://127.0.0.1:8081/accounts/5f5ce07c5bdca12f5895308b
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 8081 (#0)
> DELETE /accounts/5f5ce07c5bdca12f5895308b HTTP/1.1
> Host: 127.0.0.1:8081
> User-Agent: curl/7.58.0
> Accept: */*
> 
< HTTP/1.1 200 
HTTP/1.1 200 
< Content-Length: 0
Content-Length: 0
< Date: Sat, 12 Sep 2020 15:26:29 GMT
Date: Sat, 12 Sep 2020 15:26:29 GMT

< 
* Connection #0 to host 127.0.0.1 left intact
```

## I go back to reading the list of accounts, now 5f5ce07c5bdca12f5895308b is missing:
```
$ curl -v -i http://127.0.0.1:8081/accounts
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 8081 (#0)
> GET /accounts HTTP/1.1
> Host: 127.0.0.1:8081
> User-Agent: curl/7.58.0
> Accept: */*
> 
< HTTP/1.1 200 
HTTP/1.1 200 
< Content-Type: application/json
Content-Type: application/json
< Transfer-Encoding: chunked
Transfer-Encoding: chunked
< Date: Sat, 12 Sep 2020 15:26:54 GMT
Date: Sat, 12 Sep 2020 15:26:54 GMT

< 
* Connection #0 to host 127.0.0.1 left intact
[{"id":"5f5ce0d55bdca12f5895308c","name":"Luise","password":"456password"}]
```
