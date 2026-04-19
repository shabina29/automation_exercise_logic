pipeline {
    agent any

    tools {
        maven 'Maven'
    }

    stages {
        stage('Build & Test') {
            steps {
                bat 'mvn clean test'
            }
        }
    }

    post {
        always {
            junit '**/testng-results.xml'

            publishHTML([
                reportDir: 'test-output',
                reportFiles: 'emailable-report.html',
                reportName: 'TestNG Report'
            ])
        }
    }
}