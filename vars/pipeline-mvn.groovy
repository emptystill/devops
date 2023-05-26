@Library(['build-library', 'sonarqube-library']) _


pipeline {
  agent any
//falta un stage// -  Captura de la rama
  stages {
    stage('Build') {
      steps {
        buildPipeline(this, 'clean package')
      }
    }
    stage('CodeAnalysis') {
      steps {
        codeAnalysis(this)
      }
    }
  }
}