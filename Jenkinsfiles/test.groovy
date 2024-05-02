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
                    sh '''kubectl apply -f mysql-pvc.yml
                    kubectl apply -f wordpress-pvc.yml'''
                }
            }
        }
        stage('Deploy to sql') {
            steps {
                script {
                    sh '''kubectl apply -f sql-deploy.yml
                    kubectl apply -f mysql-service'''
                }
            }
        }
        stage('Deploy to wordpress') {
            steps {
                script {
                    sh '''kubectl apply -f wordpress-deploy.yml
                    kubectl apply -f wordpress-service.yml'''
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
