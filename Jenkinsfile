pipeline {
  
  agent any
  stages {
    stage('Building image') {
      steps{
        script {
          app = docker.build("xyz")
        }
      }
    }
	
	stage('run image') {
      steps{
        script {
          app.inside() {
                        sh "docker run -d -p 8080:8080 xyz"
          }
        }
      }
    }
  }
}