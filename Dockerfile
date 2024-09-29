FROM ubuntu:latest
LABEL authors="otavio"

ENTRYPOINT ["top", "-b"]