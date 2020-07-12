pipeline {
  environment {
    registry = "abc/docker-test"
    registryCredential = abc
  }
  agent any
  stages {
    stage('Building image') {
      steps{
        script {
          docker.build registry + ":$BUILD_NUMBER"
        }
      }
    }
  }
}