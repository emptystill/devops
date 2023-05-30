def call(String scmUrl) {
  pipeline {
    agent any
    stages {
      stage('Clone and Checkout') {
        steps {
          script {
            clonarycapturar('https://github.com/emptystill/JavaAplication.git', 'feature')
          }          
        }
      }
      stage('Build Artifact') {
        steps {
          script {
            buildPipeline(this, 'clean package')
          }
        }
      }
      stage('SonarAnalysis y QualityGate') {
        steps {
          script {
            codeAnalysis(this)
          }
        }
      }

    ///variables de entorno///
      stage('Phase 2 Deploy') {
        when {
          script {
            beforeAgent true
            expression {return env.GIT_BRANCH == 'origin/develop' || env.GIT_BRANCH == 'origin/master'}
          }
        }
      }  
      
      stage('Docker Build') {
        steps {
          script {
            dockerBuild(this)
          }
        }
      }
      stage('Docker Push') {
        steps {
          script {
            dockerPush(this)
          }
        }
      }
      stage('Docker Deploy') {
        steps {
          script {
            dockerDeploy(this)
          }
        }
      }
      stage('Owasp Analysis') {
        steps {
          script {
            owaspAnalysis(this)
          }
        }
      }
    }
  }
}
