pipeline {

    agent any

    tools {
        maven "Maven"
    }

    stages {
        stage('test') {
            steps {
                git branch: '$BRANCH', url: 'https://github.com/VladBerezovksiy/FinalSurge-UI.git'

                sh "mvn clean test"
            }

            post {
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                }
            }
        }

        stage('reports') {
            steps {
                script {
                    allure([
                            includeProperties: false,
                            jdk: '',
                            properties: [],
                            reportBuildPolicy: 'ALWAYS',
                            results: [[path: 'target/allure-results']]
                    ])
                }
            }
        }
    }
}