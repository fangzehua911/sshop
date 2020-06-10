# 基础镜像
FROM openjdk:8-jdk-alpine
# 对应pom.xml文件中的dockerfile-maven-plugin插件JAR_FILE的值
ARG JAR_FILE

# 复制打包完成后的jar文件到/opt目录下
COPY ${JAR_FILE} /opt/ddocker.jar

# /data设为环境变量
ENV DATAPATH /data

# 挂载/data目录到主机
VOLUME $DATAPATH

# 启动容器时执行
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/opt/ddocker.jar"]

EXPOSE 8080