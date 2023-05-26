@Library(['build-library', 'sonarqube-library']) _

def call(String scmUrl) {

  pipeline {
    agent any

    stages {
      stage('Capture Branch') {
        steps {
          script {
            def branchName = ""
            if (env.BRANCH_NAME.startsWith("refs/pull/")) {
              branchName = sh(returnStdout: true, script: 'echo ${env.CHANGE_ID}').trim()
            } else if (env.BRANCH_NAME.startsWith("feature/")) {
              branchName = env.BRANCH_NAME
            } else {
              error("Unsupported branch: ${env.BRANCH_NAME}")
            }
            echo "Captured branch name: ${branchName}"
          }
        }
      }

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
}