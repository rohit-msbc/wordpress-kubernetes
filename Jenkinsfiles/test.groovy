pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/rohit-msbc/wordpress-kubernetes.git'
            }
        }
        stage('Run Commands') {
            steps {
                sh 'kubectl run redis --image=redis:alpine'
            }
        }
    }
}