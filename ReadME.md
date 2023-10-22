# SDK для работы с API Tinkoff

Находится в разработке. Основная причина создания данной репозитории - то что сам Тинькофф предоставляет некоторый SDK только для мобильных приложений, что не совсем удобно для использования в рамках Web приложений.

## Системные требования

Проект написан с использованием:

* Gradle 8.3
* Java 17

## Подключение

Для подключения используется maven репозитория

**maven:**

```xml
<dependency>
    <groupId>io.github.semperetante</groupId>
    <artifactId>tinkoffsdk</artifactId>
    <version>1.0</version>
</dependency>
```

**gradle:**

```groovy
implementation 'io.github.semperetante:tinkoffsdk:1.0'
```

## Использование

В SDK реализованы методы для работы с [API терминалов](https://github.com/SemperEtAnte/TinkoffSDK/wiki/%D0%A0%D0%B0%D0%B1%D0%BE%D1%82%D0%B0-%D1%81-%D0%BE%D0%BD%D0%BB%D0%B0%D0%B9%D0%BD-%D0%BE%D0%BF%D0%BB%D0%B0%D1%82%D0%BE%D0%B9) и методы для работы с [API для бизнеса](https://github.com/SemperEtAnte/TinkoffSDK/wiki/%D0%A0%D0%B0%D0%B1%D0%BE%D1%82%D0%B0-%D1%81-API-%D0%B4%D0%BB%D1%8F-%D0%B1%D0%B8%D0%B7%D0%BD%D0%B5%D1%81%D0%B0)