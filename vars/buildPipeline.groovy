def call() {
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
  }
}