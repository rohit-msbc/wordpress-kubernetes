pipeline {
    agent any
    stages {
        stage('Clone Repository') {
            steps {
                git branch: 'main', url: 'https://github.com/rohit-msbc/wordpress-kubernetes.git'
            }
        }
        stage('Deploy to mysql') {
            steps {
                script {
                    sh 'kubectl apply -f mysql-deploy-service.yml'
                }
            }
        }
        stage('Deploy to wordpress') {
            steps {
                script {
                    sh 'kubectl apply -f wordpress-deploy-service.yml'
                }
            }
        }
        stage('Deploy to Volume/Claim') {
            steps {
                script {
                    sh '''kubectl apply -f wordpress-mysql-pv.yml
                    kubectl apply -f mysql-pvc.yml
                    kubectl apply -f wordpress-pvc.yml
                    '''
                }
            }
        }
        
        stage('Deploy to secret') {
            steps {
                script {
                    sh 'kubectl apply -f secret.yml'
                }
            }
        }
    }
}
