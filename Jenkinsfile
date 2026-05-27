pipeline {
    agent any

    environment {
        DOCKERHUB_USERNAME = 'hemanth6460'
        IMAGE_NAME = 'springboot-app'
        IMAGE_TAG = "${env.BUILD_NUMBER}"
    }

    stages {
        stage('Checkout') {
            steps {
                echo 'Pulling latest code from GitHub...'
                echo "Branch: ${env.GIT_BRANCH}"
                checkout scm
            }
        }

        stage('Build JAR') {
            steps {
                echo 'Building Spring Boot JAR with Maven...'
                bat 'mvn clean package -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                echo 'Building Docker Image...'
                bat "docker build -t hemanth6460/springboot-app:%IMAGE_TAG% ."
            }
        }

        stage('Push to DockerHub') {
            steps {
                echo 'Pushing image to DockerHub...'
                withCredentials([usernamePassword(
                    credentialsId: 'dockerhub-credentials',
                    usernameVariable: 'DOCKER_USER',
                    passwordVariable: 'DOCKER_PASS'
                )]) {
                    bat "docker login -u %DOCKER_USER% -p %DOCKER_PASS%"
                    bat "docker push hemanth6460/springboot-app:%IMAGE_TAG%"
                }
            }
        }

        stage('Run Container') {
            steps {
                echo 'Starting Spring Boot container...'
                bat "docker stop springboot-app || exit 0"
                bat "docker rm springboot-app || exit 0"
                bat "docker run -d -p 8090:8080 --name springboot-app hemanth6460/springboot-app:%IMAGE_TAG%"
            }
        }
    }

    post {
        success {
            echo '✅ Spring Boot app built, dockerized and running!'
            echo '🌐 Access your app at http://localhost:8090'
        }
        failure {
            echo '❌ Pipeline failed! Check the logs above.'
        }
    }
}