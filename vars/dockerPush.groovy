def call(script) {
  script.withEnv([
    "DOCKER_USERNAME=mateopulido99",
    "DOCKER_PASSWORD=dckr_pat_96eVTLvulJZ_DLK2EqlbVEJrXV0"
  ]) {
    script.bat 'docker login -u %DOCKER_USERNAME% -p %DOCKER_PASSWORD%'
    script.bat 'docker tag javaaplication %DOCKER_USERNAME%/javaaplication:v1.0'
    script.bat 'docker push %DOCKER_USERNAME%/javaaplication:v1.0'
  }
}
