pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/rohit-msbc/wordpress-kubernetes.git']]])
            }
        }
        stage('Run Commands') {
            steps {
                sh 'minikube kubectl run redis --image=redis:alpine'
            }
        }
    }
}
