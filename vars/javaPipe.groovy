// @Library(['build-library', 'sonarqube-library']) _

def call(String scmUrl) {

  pipeline {
    agent any

    stages {
      stage('Clonar y Capturar') {
        steps {
          script {
            clonarycapturar(this)
          }          
        }
      }

      stage('Build') {
        steps {
          script {
            buildPipeline(this, 'clean package')
          }
        }
      }

      stage('CodeAnalysis') {
        steps {
          script {
            codeAnalysis(this)
          }
        }
      }
    }
  }
}