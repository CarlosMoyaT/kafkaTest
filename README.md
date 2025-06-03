-PROYECTO con Spring Boot, Kafka, PostgreSQL, Prometheus y Grafana-

El objetivo de este proyecto es principalmente aprender como funciona Kafka y como mostrar métricas sobre datos o eventos, almacenarlos y monitorearlos, también como desarrollar una arquitectura escalable y que facilite realizar cambios sin afectar a todo el código

## TECNOLOGÍAS UTILIZADAS

- Spring Boot 
- Apache Kafka 
- Zookeeper 
- PostgreSQL 
- Prometheus 
- Grafana 
- Docker & Docker Compose 

## Requisitos previos

- Docker
- Docker Compose
- Java 21

-ACTUALIZACIÓN DEL PROYECTO-

De momento he conseguido mostrar métricas en Prometheus por varias expresiones como por ejemplo : rate(kafka_controller_controllereventmanager_count[1m])
que calcula la tasa de cambio por segundo del contador durante el último minuto. Lo cual indica que la gráfica está activa y generando eventos.
![Prometheus graphic](Prometheus graphic.JPG)

Serguiré actualizando ya que mi intención es mostrar una gráfica donde se muestren datos como temperatura.




