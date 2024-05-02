pipeline {
    agent any
    
    stages {
        stage('Clone Repository') {
            steps {
                git ''
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
