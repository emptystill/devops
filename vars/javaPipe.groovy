// @Library(['build-library', 'sonarqube-library']) _

def call(String scmUrl) {

  pipeline {
    agent any

    stages {
      stage('Clonar repositorio') {
        steps {
          checkout([
            $class: 'GitSCM',
            branches: [
              [name: 'featurex']
            ], // Rama específica que deseas capturar
            userRemoteConfigs: [
              [url: scmUrl]
            ], // Utiliza la URL pasada como parámetro
            extensions: [
              [$class: 'CleanBeforeCheckout']
            ] // Opcional: Realiza una limpieza antes de clonar
          ])
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