pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/rohit-msbc/wordpress-kubernetes.git']]])
            }
        }
        stage('Run Commands') {
            steps {
                sh 'kubectl run redis --image=redis:alpine'
            }
        }
    }
}
