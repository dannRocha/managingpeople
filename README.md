# Manganing People

## Ferramentas
 - Gradle 6.8.3
 - Java 11
 - Git 2.30.2

## Execução
Clone o projeto
```
git clone https://github.com/dannRocha/managingpeople.git
```
Entrando da pasta do projeto execute o comando no terminal

```sh
./gradlew bootRun
```
ou

```sh
gradle bootRun
```
### Uso com [Postman, Insomina]

#### POST
```sh
localhost:8080/api/v1/people

```
Body JSON
```json
{
  "firstName": "Daniel",
  "lastName": "Rocha",
  "cpf": "041.085.400-00",
  "birthDay": "1998-08-13",
  "phones": [
    {
      "type": "MOBILE",
      "number": "+5598981111111"
    }
  ]
}
```


#### GET
```sh
localhost:8080/api/v1/people
```
Com ID
```sh
localhost:8080/api/v1/people/{id}
```

#### DELETE
```sh
localhost:8080/api/v1/people/{id}

```

#### PUT
```sh
localhost:8080/api/v1/people/{id}

```
Body JSON
```json
{
  "id": 1,
  "firstName": "Rocha",
  "lastName": "Daniel",
  "cpf": "731.051.070-45",
  "birthDay": "1999-09-13",
  "phones": [
    {
      "id": 1,
      "type": "MOBILE",
      "number": "+5598982222222"
    }
  ]
}
```

### Uso com [CURL]


#### GET
```sh
curl http://localhost:8080/api/v1/people
```

com ID
```sh
curl localhost:8080/api/v1/people/{id}
```

#### POST
```sh
curl -d '{
  "firstName": "Daniel",
  "lastName": "Rocha",
  "cpf": "041.085.400-00",
  "birthDay": "1998-08-13",
  "phones": [
    {
      "type": "MOBILE",
      "number": "+5598981111111"
    }
  ]
}' -H "Content-Type: application/json" -X POST http://localhost:8080/api/v1/mangas/
```

#### DELETE
```sh
curl -X DELETE http://localhost:8080/api/v1/people/{id}

```

#### PUT
```sh
curl -d '{
  "id": 1,
  "firstName": "Rocha",
  "lastName": "Daniel",
  "cpf": "731.051.070-45",
  "birthDay": "1999-09-13",
  "phones": [
    {
      "id": 1,
      "type": "MOBILE",
      "number": "+5598982222222"
    }
  ]
}' -H "Content-Type: application/json" -X PUT http://localhost:8080/api/v1/people/1

```