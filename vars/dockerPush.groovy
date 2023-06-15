def call(script) {
  script.withCredentials([string(credentialsId: 'dockerhub-credentials', variable: 'DOCKER_PASSWORD')]) {
    script.bat 'echo %DOCKER_PASSWORD% | docker login -u mateopulido99 --password-stdin'
    script.bat 'docker tag javaaplication mateopulido99/javaaplication:v1.0'
    script.bat 'docker push mateopulido99/javaaplication:v1.0'
  }
}
