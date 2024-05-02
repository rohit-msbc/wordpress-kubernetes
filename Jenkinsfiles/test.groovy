pipeline {
    agent any
    stages {
        stage('Clone Repository') {
            steps {
                git branch: 'main', url: 'https://github.com/rohit-msbc/wordpress-kubernetes.git'
            }
        }
        stage('Deploy to pvc') {
            steps {
                script {
                    sh 'kubectl apply -f pvc.yml'
                }
            }
        }
    }
}
