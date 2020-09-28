node('master')
{
    def mvnHome=tool name: 'maven', type: 'maven'
    
    stage('Git CheckOut')
    {
        checkout([$class: 'GitSCM', branches: [[name: '*/master']], userRemoteConfigs: [[url: 'https://github.com/saylikale/Jenkins-Tomcat-Integration.git']]])
    }
    
    stage('Execute SonarQube Report')
    {
        sh "${mvnHome}/bin/mvn clean sonar:sonar"
    }
   
    stage('Deploy Artefact to Nexus')
    {
        sh "${mvnHome}/bin/mvn deploy"
    }
     
    stage('Build Docker Image')
    {
        sh 'docker build -t saylikale40/jenkins-tomcat-integration:${BUILD_NUMBER} .'
    }
    
    stage('Push Docker Image to Hub')
    {
        withCredentials([string(credentialsId: 'docker_hub_pwd', variable: 'DockerHubPwd')]) {
            sh 'docker login -u saylikale40 -p ${DockerHubPwd}'
        }
        
        sh 'docker push saylikale40/jenkins-tomcat-integration:${BUILD_NUMBER}'
    }
    
    stage('Run Docker Container')
    {
        sshagent(['SSHToDocker']) {
            sh "ssh -o StrictHostKeyChecking=no ubuntu@15.207.72.232 docker rm -f jenkinstomcat || true"
            sh "ssh -o StrictHostKeyChecking=no ubuntu@15.207.72.232 docker run -d -p 8080:8080 --name jenkinstomcat saylikale40/jenkins-tomcat-integration:${BUILD_NUMBER}"
        }
    }
    
    /*stage('Deploy App to Tomcat Dev Server')
    {
        deploy adapters: [tomcat9(credentialsId: 'tomcat-creds', path: '', url: 'http://35.154.92.159:8443/')], contextPath: 'jenkins-tomcat-app', onFailure: false, war: '*.war'
    }*/
}
