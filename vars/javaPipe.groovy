// @Library(['build-library', 'sonarqube-library']) _

def call(String scmUrl) {

  pipeline {
    agent any

    stages {
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