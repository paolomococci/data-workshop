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
