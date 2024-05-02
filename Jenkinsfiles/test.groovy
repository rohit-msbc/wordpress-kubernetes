pipeline {
    agent any
    stages {
        stage('Clone Repository') {
            steps {
                git branch: 'main', url: 'https://github.com/rohit-msbc/wordpress-kubernetes.git'
            }
        }
        stage('Deploy to Volume/Claim') {
            steps {
                script {
                    sh '''kubectl applu -f 
                    '''
                }
            }
        }
        stage('Deploy to secret') {
            steps {
                script {
                    sh 'kubectl version'
                }
            }
        }
        stage('Deploy to mysql') {
            steps {
                script {
                    sh 'kubectl version'
                }
            }
        }
        stage('Deploy to wordpress') {
            steps {
                script {
                    sh 'kubectl version'
                }
            }
        }
    }
}
