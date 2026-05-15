pipeline {
    agent any

    tools {
        maven 'Maven'
        jdk 'JDK21'
    }

    stages {

        stage('Checkout') {
            steps {
                git 'https://github.com/neetha5/oe.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Package') {
            steps {
                sh 'mvn package'
            }
        }
    }

    post {
        success {
            mail to: 'your-email@gmail.com',
                 subject: "Build SUCCESS: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                 body: "Build ${env.BUILD_NUMBER} of ${env.JOB_NAME} completed successfully.  See: ${env.BUILD_URL}"
        }
        failure {
            mail to: 'your-email@gmail.com',
                 subject: "Build FAILED: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                 body: "Build ${env.BUILD_NUMBER} of ${env.JOB_NAME} failed.  See: ${env.BUILD_URL}"
        }
    }
}
