def call(String scmUrl) {
  pipeline {
    agent any
    stages {
      stage('Clonar y Capturar') {
        steps {
          script {
            clonarycapturar('https://github.com/emptystill/JavaAplication.git', 'feature')
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
      stage('DockerBuild') {
        steps {
          script {
            dockerBuild(this)
          }
        }
      }
      stage('DockerPush') {
        steps {
          script {
            dockerPush(this)
          }
        }
      }
      stage('DockerDeploy') {
        steps {
          script {
            dockerDeploy(this)
          }
        }
      }
      stage('OwaspAnalysis') {
        steps {
          script {
            owaspAnalysis(this)
          }
        }
      }
    }
  }
}