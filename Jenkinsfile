pipeline {
    agent any
    
    environment {
           SONAR_HOST = 'http://192.168.99.100:9000'
    }

    stages {
	
	    
        
        stage('Build Backend'){
            steps{
                script {
                    docker.image('maven:3.6-jdk-8-alpine').inside() {
                        sh "mvn clean package"
                    }
                }
            }
        }
		
		stage('Deploy Backend'){
            steps{
                script {
                    docker.image('maven:3.6-jdk-8-alpine').inside() {
                        sh "java -jar target/BackEndAngular-1.3.5.RELEASE.jar --port=8083"
                    }
                }
            }
        }
        
    }
}