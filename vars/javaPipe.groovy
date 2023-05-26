// @Library(['build-library', 'sonarqube-library']) _

def call(String scmUrl) {

  pipeline {
    agent any

    stage('Clone Repository') {
      steps {
        script {
          def repositoryUrl = scmUrl
          def repositoryName = repositoryUrl.substring(repositoryUrl.lastIndexOf("/") + 1, repositoryUrl.lastIndexOf(".git"))

          dir(repositoryName) {
            checkout scm
          }
        }
      }
    }

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