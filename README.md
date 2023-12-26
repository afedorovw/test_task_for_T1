## Тестовое задание

Реализован REST API, вычисляющее частоту встречи символов по заданной строке.

**Версия Java 17, Spring boot 3**

_Использование сервиса по следующему адресу_ `http://localhost:8085/{controller}`

| Controller    | Input      | Result                 |
|---------------|------------|------------------------|
| /list         | -          | test                   | 
| /list/{input} | aaaaabcccc | “a”: 5, “c”: 4, “b”: 1 |


### Локальная сборка и запуск

```
mvn clean install
mvn spring-boot:run
```

### Сборка и запуск docker образа

```
docker build -t <image_name> .
docker run -d -p 8081:8081 <image_name>
```