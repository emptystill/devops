def call() {
  pipeline {
    agent any

    tools {
      // Especifica la versión de Maven
      maven 'Maven_3.9.0'
    }

    stages {
      stage('Checkout') {
        steps {
          checkout scm
        }
      }

      stage('Build') {
        steps {
          // Ejecuta el comando Maven con la versión especificada
          bat 'mvn clean package'
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

return this