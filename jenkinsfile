pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                echo 'Code pulled from GitHub!'
                echo "Branch: ${env.GIT_BRANCH}"
            }
        }
        stage('Build') {
            steps {
                echo 'Building the application...'
                echo "Build Number: ${env.BUILD_NUMBER}"
            }
        }
        stage('Test') {
            steps {
                echo 'Running tests...'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying application...'
            }
        }
    }

    post {
        success {
            echo '✅ Build SUCCESS!'
        }
        failure {
            echo '❌ Build FAILED!'
        }
    }
}
