pipeline {
    agent any
    
    environment {
           SONAR_HOST = 'http://192.168.99.100:9000'
    }

    stages {
	
	    stage('Docker build'){
            steps{
                script {
                    docker.image('app:latest').inside() {
                       sh "docker run -d -p 8080:8080 app"
                    }
                }
            }
        }
        
        
    }
}