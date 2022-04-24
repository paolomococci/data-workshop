# sample of iso-3166 with H2 relational database management system server and Spring Boot

## to load a record can be used the following command:
```
curl -v -i -H "Content-Type:application/json" -d '{"name":"Afghanistan","alphaTwo":"AF","alphaThree":"AFG","countryId":"004"}' http://127.0.0.1:9090/api/countries
```

## to load the data, go to the directory resources/data and use the following shell command:
```
./iso-3166-load-data.sh
```

## for verification:
```
curl -v -i http://127.0.0.1:9090/api/countries
```

# To make the application work inside a container

## commands to create the image and administer it:

```
$ podman build --tag image_iso3166 .

$ podman run --detach --name app_iso3166 --publish 9090:9090 image_iso3166

$ podman images

$ podman ps --all

$ podman stop app_iso3166

$ podman ps --all

$ podman rmi --force image_iso3166
```

## an example of interaction with the containerized application:

```
$ curl -v -i http://127.0.0.1:9090/
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 9090 (#0)
> GET / HTTP/1.1
> Host: 127.0.0.1:9090
> User-Agent: curl/7.61.1
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
< Date: Thu, 12 Mar 2020 17:33:59 GMT
Date: Thu, 12 Mar 2020 17:33:59 GMT

< 
{
  "_links" : {
    "countries" : {
      "href" : "http://127.0.0.1:9090/countries{?page,size,sort}",
      "templated" : true
    },
    "profile" : {
      "href" : "http://127.0.0.1:9090/profile"
    }
  }
* Connection #0 to host 127.0.0.1 left intact
}

$ curl -v -i -H "Content-Type:application/json" -d '{"name":"Afghanistan","alphaTwo":"AF","alphaThree":"AFG","countryId":"004"}' http://127.0.0.1:9090/api/countries
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 9090 (#0)
> POST /api/countries HTTP/1.1
> Host: 127.0.0.1:9090
> User-Agent: curl/7.61.1
> Accept: */*
> Content-Type:application/json
> Content-Length: 75
> 
* upload completely sent off: 75 out of 75 bytes
< HTTP/1.1 201 
HTTP/1.1 201 
< Content-Type: application/hal+json
Content-Type: application/hal+json
< Transfer-Encoding: chunked
Transfer-Encoding: chunked
< Date: Thu, 12 Mar 2020 17:37:09 GMT
Date: Thu, 12 Mar 2020 17:37:09 GMT

< 
{
  "name" : "Afghanistan",
  "alphaTwo" : "AF",
  "alphaThree" : "AFG",
  "countryId" : 4,
  "_links" : {
    "self" : {
      "href" : "http://127.0.0.1:9090/api/countries/1"
    },
    "countries" : {
      "href" : "http://127.0.0.1:9090/api/countries"
    }
  }
* Connection #0 to host 127.0.0.1 left intact
}

$ curl -v -i http://127.0.0.1:9090/api/countries
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 9090 (#0)
> GET /api/countries HTTP/1.1
> Host: 127.0.0.1:9090
> User-Agent: curl/7.61.1
> Accept: */*
> 
< HTTP/1.1 200 
HTTP/1.1 200 
< Content-Type: application/hal+json
Content-Type: application/hal+json
< Transfer-Encoding: chunked
Transfer-Encoding: chunked
< Date: Thu, 12 Mar 2020 17:38:31 GMT
Date: Thu, 12 Mar 2020 17:38:31 GMT

< 
{
  "_embedded" : {
    "countries" : [ {
      "name" : "Afghanistan",
      "alphaTwo" : "AF",
      "alphaThree" : "AFG",
      "countryId" : 4,
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:9090/api/countries/1"
        },
        "countries" : {
          "href" : "http://127.0.0.1:9090/api/countries"
        }
      }
    } ]
  }
* Connection #0 to host 127.0.0.1 left intact
}
```
