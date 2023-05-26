// @Library(['build-library', 'sonarqube-library']) _

def call(String scmUrl) {

  pipeline {
    agent any

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