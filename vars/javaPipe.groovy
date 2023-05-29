def call(String scmUrl) {

  pipeline {
    agent any

    // stages {
    //   stage('Clonar y Capturar') {
    //     steps {
    //       script {
    //         clonarycapturar('feature')
    //       }          
    //     }
      // }

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
// }