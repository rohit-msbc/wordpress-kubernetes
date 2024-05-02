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
        stage('Deploy to sql') {
            steps {
                script {
                    sh 'kubectl apply -f sql-deploy.yml'
                }
            }
        }
        stage('Deploy to wordpress') {
            steps {
                script {
                    sh 'kubectl apply -f wordpress-deploy.yml'
                }
            }
        }
        
        stage('Deploy to expose') {
            steps {
                script {
                    sh 'kubectl apply -f expose.yml'
                }
            }
        }
    }
}
