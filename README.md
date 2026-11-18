# Архив курса валют — Docker

Простое Spring Boot API для контрольной точки «контейнер».

## Тема проекта

Сервис хранения и просмотра истории курсов валют.

## Эндпоинты

- `GET /health` — проверка работы сервиса
- `GET /currencies` — список валют в архиве
- `GET /rates/{currency}` — пример истории курса (например `/rates/USD`)

## Требования

- Docker Desktop или Docker Engine

## Сборка образа

```bash
docker build -t currency-archive .
```

## Запуск контейнера

```bash
docker run -d -p 8080:8080 --name currency-archive currency-archive
```

## Проверка

### Список контейнеров
```bash
docker ps
```

### Запрос к API
```bash
curl http://localhost:8080/health
curl http://localhost:8080/currencies
curl http://localhost:8080/rates/USD
```

Или открой в браузере:
- http://localhost:8080/health
- http://localhost:8080/currencies
- http://localhost:8080/rates/USD

### Логи контейнера
```bash
docker logs currency-archive
```

## Остановка и удаление

```bash
docker stop currency-archive
docker rm currency-archive
```

## Структура проекта

```
currency-archive/
├── src/main/java/com/currencyarchive/
│   ├── CurrencyArchiveApplication.java
│   └── controller/CurrencyController.java
├── src/main/resources/application.properties
├── pom.xml
├── Dockerfile
└── README.md
```
