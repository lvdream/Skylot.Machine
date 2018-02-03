FROM tomcat:8
ENV TZ=Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
COPY ./jdk/ /usr/local/jdk/
ENV JAVA_HOME /usr/local/jdk
COPY ./target/SkylotMachine-1.0-SNAPSHOT/ /usr/local/tomcat/webapps/SkylotMachine/