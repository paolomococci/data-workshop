# h2-restful-security

Sample demo application

## Use:

```
$ curl -v -i http://127.0.0.1:8090/rest/api/samples -u user:qwerty123
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 8090 (#0)
* Server auth using Basic with user 'user'
> GET /rest/api/samples HTTP/1.1
> Host: 127.0.0.1:8090
…
> User-Agent: curl/7.61.1
> Accept: */*
> 
< HTTP/1.1 200 
HTTP/1.1 200
…
```
