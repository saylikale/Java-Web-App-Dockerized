FROM tomcat:8.0.20-jre8
MAINTAINER Sayali Kale
COPY target/*.war /usr/local/tomcat/webapps/jenkins-tomcat-integration
