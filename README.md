### Endpoints
Nessa api é possível, listar,adicionar, editar, excluir, listar Produtos, Categorias, Marcas "Mysql" e Operações de Cart em MongoDb

##### Register Customer: POST http://localhost:8080/ecommerce/customer/register

```sh
{
      "firstname": "Arthur",
      "lastname": "Carvalho",
      "email": "arthur@test.com",
      "address": "Av Test",
      "addressnum": "99",
      "city": "São Paulo",
      "country": "Brasil",
      "postalcode": "09842120",
      "phone": "5511948118888",
      "bdaydate": "04-03-2018",
      "statususer": "A"
}
```
###### RESPONSE: HTTP.STATUS 201 CREATED

===================================================

##### Retrieve all customers: **GET http://localhost:8080/ecommerce/customer/all
**Response:**
```sh
[
    {
        "id": 1,
        "address": "Av Test",
        "addressnum": "99",
        "bdaydate": "04-03-2018",
        "city": "São Paulo",
        "country": "Brasil",
        "email": "arthur@test.com",
        "firstname": "Arthur",
        "lastname": "Carvalho",
        "phone": "5511948118888",
        "postalcode": "09842120",
        "statususer": "A",
        "orders": []
    }, ...
	]
```
===================================================
##### Get Customer by ID: **GET http://localhost:8080/ecommerce/customer/1**
**Response:**
```sh
    {
        "id": 1,
        "address": "Av Test",
        "addressnum": "99",
        "bdaydate": "04-03-2018",
        "city": "São Paulo",
        "country": "Brasil",
        "email": "arthur@test.com",
        "firstname": "Arthur",
        "lastname": "Carvalho",
        "phone": "5511948118888",
        "postalcode": "09842120",
        "statususer": "A",
        "orders": []
    }
```
##### Delete Customer: **DELETE http://localhost:8080/ecommerce/customer/{id}**
**Response:**
```sh
HTTP.STATUS: 200 OK 
```
===================================================

##### Edit customer:** **PUT http://localhost:8080/ecommerce/customer/{id}**
 
```sh
{
      "firstname": "Arthur",
      "lastname": "Carvalho",
      "email": "arthur@test.com",
      "address": "Av Interativa",
      "addressnum": "888",
      "city": "São Paulo",
      "country": "Brasil",
      "postalcode": "02820020",
      "phone": "5511948118888",
      "bdaydate": "04-03-2018",
      "statususer": "A"
}
```
**Response:**
```sh
HTTP.STATUS: 200 OK 
```
===================================================

##Cart

Cart database in MongoDb

##### First item on cart:** **PUT http://localhost:8080/ecommerce/cart/add**

```sh
{
    "idCart": "0",
    "iduser": 1,
    "prodId": 2,
    "quantity":4
}
```
**Response:**
```sh
{
    "_id": {
        "timestamp": 1594191703,
        "date": "2020-07-08T07:01:43.000+00:00"
    },
    "iduser": 1,
    "prodInfo": [
        {
            "id": 2,
            "name": "TV Smart 4k 42 polegadas",
             "pic1": "https://ecommerce/img/thumnail.png",
            "category": "TV",
            "price": 1999.99,
            "brand": "SONY",
            "quantity": 4
        },
    ],
    "totalCart": 7999.96
}
```

##### Add more items on cart:** **PUT http://localhost:8080/ecommerce/cart/add**

```sh
{
    "idCart": "5f056f5789e19f3202f4589c", <- Dynamic mongoDb id generated
    "iduser": 1,
    "prodId": 3,
    "quantity":1
}
```

**Response:**
```sh
{
    "_id": {
        "timestamp": 1594191703,
        "date": "2020-07-08T07:01:43.000+00:00"
    },
    "iduser": 1,
    "prodInfo": [
        {
            "id": 2,
            "name": "TV Smart 4k 42 polegadas",
            "pic1": "https://ecommerce/img/thumnail.png",
            "category": "TV",
            "price": 1999.99,
            "brand": "SONY",
            "quantity": 4
        },
        {
            "id": 3,
            "name": "Samsung A50 128gb OctaCore 8gb RAM",
            "pic1": "https://ecommerce/img/thumnail.png",
            "category": "Telefonia",
            "price": 1200.0,
            "brand": "Samsung",
            "quantity": 1
        }
    ],
    "totalCart": 4399.99
}
```