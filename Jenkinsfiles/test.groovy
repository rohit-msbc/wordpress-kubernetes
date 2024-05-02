pipeline {
    agent any
    environment {
        KUBECONFIG = credentials('kubeconfig')
    }
    stages {
        stage('Clone Repository') {
            steps {
                git branch: 'main', url: 'https://github.com/rohit-msbc/wordpress-kubernetes.git'
            }
        }
        stage('pv') {
            steps {
                sh 'kubectl version'
            }
        }
    }
}
