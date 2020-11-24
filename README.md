# rest-api for technical test

Este repo es para subir el test técnico para evaluación

## Pre-requisitos: 

1. openJdk 11
2. [Apache Maven](https://maven.apache.org/)
2. [Mysql](https://dev.mysql.com/downloads/mysql/)    

## Pasos para ejecutar la aplicación
- Clonar el proyecto:
```
git clone https://github.com/jlandero/rest-entrevista.git
```
- Compilar el proyecto:
```
mvn clean package
```
- Ejecutar el proyecto localmente:
```
mvn spring-boot:run
```

```
- Por defecto la aplicación carga en el puerto 8080, para ver el swagger debe acceder a la siguiente url
```
```
[Swagger](http://localhost:8080/swagger-ui.html)
```
### Api docs:
```
http://localhost:8080/v2/api-docs
```

### Endpoints: 
no se añadió contexto para la aplicación, los endpoints estan descritos en el swagger

- get [listUser](http://localhost:8080/v1/user/listUsers)
- get [findByEmail](http://localhost:8080/v1/user/findByEmail/{email})
- post [save](http://localhost:8080/v1/user/save)
- get [Api Externa](http://localhost:8080/v1/search/call/{rut})
