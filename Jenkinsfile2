pipeline {
  
  agent any
  stages {
    stage('Building image') {
      steps{
        script {
          app = docker.build("xyz")
		  docker.image('xyz').withRun("-p 8000:8080") {c ->
           sh "docker logs ${c.id}"
          }
        }
      }
    }
  }
}