pipeline {
    agent any
    stages {
        stage('Clone Repository') {
            steps {
                git branch: 'main', url: 'https://github.com/rohit-msbc/wordpress-kubernetes.git'
            }
        }
        stage('Deploy to Minikube') {
            steps {
                script {
                    sh 'kubectl version'
                }
            }
        }
    }
}
