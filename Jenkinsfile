pipeline {
    agent any
    tools{
        maven 'Maven'
        git 'git'   
    }
      stages {
        stage('Checkout') {
            steps {
                git branch: 'jenkins', url: 'https://github.com/LhassanTkarkib/Connexia'
            }
        }

        stage('Build') {
            steps {
                script {
                    if (isUnix()) {
                        sh 'mvn clean install'
                    } else {
                        bat 'mvn clean install'
                    }
                }
            }
        }
}
      }
