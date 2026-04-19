pipeline {
    agent any

    tools {
        maven 'Maven'
    }

    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'main', url: 'https://github.com/shabina29/automation_exercise_logic.git'
            }
        }

        stage('Build & Test') {
            steps {
                bat 'mvn clean test'
            }
        }
    }

    post {
        always {
            // ✅ TestNG XML result Jenkins me show karega
            junit '**/testng-results.xml'

            // ✅ HTML report publish karega (emailable-report.html)
            publishHTML([
                reportDir: 'test-output',
                reportFiles: 'emailable-report.html',
                reportName: 'TestNG Report'
            ])
        }
    }
}