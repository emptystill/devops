def call() {
  pipeline {
    agent any

    stages {
      stage('Checkout') {
        steps {
          checkout scm
        }
      }

      stage('Static Code Analysis') {
        steps {
          // Ejecuta el análisis estático del código con SonarQube
          withSonarQubeEnv('SonarQube') {
            bat 'mvn sonar:sonar'
          }
        }
      }
    }
  }
}
