pipeline {
    agent any
    stages {
        stage('Clone Repository') {
            steps {
                git branch: 'main', url: 'https://github.com/rohit-msbc/wordpress-kubernetes.git'
            }
        }
        stage('pv') {
            steps {
                echo 'kubectl create -f sql-deploy.yml'
            }
        }
    }
}
