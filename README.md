# Jenkins-Tomcat-Integration
This contains a sample web application and I have automated the Integration Process for deploying this app to tomcat server.

#DevOps Tools Used:
Jenkins
Maven
GitHub
Nexus
SonarQube
Docker

#Jenkins Plugins Used:
pipeline plugin
ssh-agent plugin

#Deployment Automation Workflow:

             Nexus
              ^
              |
GitHub ---> Jenkins ---> SonarQube
             ^    ^
            /      \
        Maven     Docker ---> My Java Application
        
    
