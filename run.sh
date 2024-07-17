#!/bin/bash

docker build -f Dockerfile -t demo-tracing-service && \

docker run -p 8080:8080 \
-e OTEL_SERVICE_NAME=demo-tracing \
-e OTEL_EXPORTER_OTLP_ENDPOINT=http://localhost:4318 `#OTEL_EXPORTER_OTLP_ENDPOINT and OTEL_EXPORTER_OTLP_PROTOCOL must have coherent values: targeting port 4318 requires PROTOCOL to be http/protobuf (or http/json). Targeting port 4317 requires PROTOCOL to be grpc` \
-e OTEL_EXPORTER_OTLP_PROTOCOL=http/protobuf \
-e OTEL_LOGS_EXPORTER=otlp,console \
-e OTEL_METRICS_EXPORTER=otlp,console \
-e OTEL_TRACES_EXPORTER=otlp,console \
--name=demo-tracing-service \
--replace \
--net=host \
-d demo-tracing-service