def call(String scmUrl) {

  pipeline {
    agent any

    stages {
      stage('Clonar y Capturar') {
        steps {
          script {
            clonarycapturar('https://github.com/emptystill/JavaAplication.git', 'main')
          }          
        }
      }

      stage('Build') {
        steps {
          script {
            buildPipeline(this)
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