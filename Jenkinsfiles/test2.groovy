pipeline {
    agent any
    stages {
        stage('Clone Repository') {
            steps {
                git branch: 'main', url: ''
            }
        }
        stage('Deploy to Minikube') {
            steps {
                script {
                    sh 'kubectl apply -f deployment.yml'
                }
            }
        }
    }
}
