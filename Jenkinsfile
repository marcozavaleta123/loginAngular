pipeline {
    agent {
        docker { image 'maven:3.6-jdk-8-alpine' }
    }

    stages {
        
        stage('build') {
            steps {
                sh 'mvn clean package'
            }
        }

    }
}