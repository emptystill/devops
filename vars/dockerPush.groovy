def call(script) {
  script.withCredentials([string(credentialsId: 'dockerhub-credentials', variable: 'DOCKER_PASSWORD')]) {
    script.bat 'echo %DOCKER_PASSWORD% > token.txt'
    script.bat 'docker login -u mateopulido99 --password-stdin < token.txt'
    script.bat 'docker tag javaaplication mateopulido99/javaaplication:v1.0'
    script.bat 'docker push mateopulido99/javaaplication:v1.0'
  }
}

