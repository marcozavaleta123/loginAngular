pipeline {
    agent any

    stages {
        
        stage('Build Backend'){
            steps{
                script {
                    docker.image('maven').inside() {
                        sh "mvn -f ${env.WORKSPACE}/pom.xml -Dmaven.repo.local=/home/.m2/repository --batch-mode package -Dmaven.test.skip=true"
                    }
                }
            }
        }

    }
}