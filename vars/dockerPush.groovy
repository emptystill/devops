def call(script) {
  script.withCredentials([string(credentialsId: 'dockerhub-credentials', variable: 'DOCKER_PASSWORD')]) {
    script.bat 'docker login -u mateopulido99 -p %DOCKER_PASSWORD%'
    script.bat 'docker tag javaaplication mateopulido99/javaaplication:v1.0'
    script.bat 'docker push mateopulido99/javaaplication:v1.0'
  }
}
