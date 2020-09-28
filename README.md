# Jenkins-Tomcat-Integration
This contains a sample Java Web Application and I have automated the Integration Process for deploying this app to the tomcat container.

#DevOps Tools Used:
Jenkins,
Maven,
GitHub,
Nexus,
SonarQube,
Docker

#Jenkins Plugins Used:
pipeline plugin,
ssh-agent plugin

#Deployment Automation Workflow:

GitHub -> Jenkins -> Maven -> SonarQube -> Nexus -> DockerHub -> Docker -> End-User Application
