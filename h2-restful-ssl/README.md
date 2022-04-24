# h2-restful-ssl

Sample demo application

## Use:

```
$ echo quit | openssl s_client -showcerts -servername 127.0.0.1 -connect 127.0.0.1:8443 > self-signed.pem

$ curl -v -i --cacert self-signed.pem --location --silent https://127.0.0.1:8443/rest/api/samples -u user:qwerty123
```

## otherwise you can use:

```
$ curl --insicure -v -i https://127.0.0.1:8443/rest/api/samples -u user:qwerty123
```
