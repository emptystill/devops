def call() {
  agent any

  stages {
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