pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/rohit-msbc/wordpress-kubernetes.git']]])
            }
        }

        stage('Deploy to Minikube') {
            steps {
                script {
                    def kubeConfig = readFile("${env.HOME}/.kube/config")
                    sh "kubectl --kubeconfig=${kubeConfig} apply -f deployment.yml"
                }
            }
        }
    }
}
