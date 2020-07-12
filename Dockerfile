#De la imagen que partimos
FROM openjdk:8-jre-alpine

RUN apk add --no-cache tzdata
ENV TZ='America/Lima'
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

RUN apk --update add fontconfig ttf-dejavu

#Directorio de trabajo
WORKDIR /

RUN mkdir app && chmod 777 app
COPY target/BackEndAngular-1.3.5.RELEASE.jar /app
WORKDIR /app

#Exponemos el puerto 8085
EXPOSE 8080

#Comando que se ejecutarÃ¡ una vez ejecutemos el contendor
CMD ["java","-jar","BackEndAngular-1.3.5.RELEASE.jar"]