@Library(['build-library', 'sonarqube-library' ,'dockerbuild-library', 'dockerpush-library', 'dockerdeploy-library', 'owaspanalysis-library']) _


pipeline {
  agent any
//falta un stage// -  Captura de la rama
  stages {
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
    // stage('DockerBuild') {
    //   steps {
    //     dockerBuild(this)
    //   }  
    // }
    // stage('DockerPush') {
    //   steps {
    //     dockerPush(this)
    //   }  
    // }
    // stage('DockerDeploy') {
    //   steps {
    //     dockerDeploy(this)
    //   }  
    // }
    // stage('OwaspAnalysis') {
    //   steps {
    //     owaspAnalysis(this)
    //   }  
    // }
  }
}