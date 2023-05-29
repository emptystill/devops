def call(script) {
  script.withSonarQubeEnv('SonarQube') {
    bat "mvn clean verify sonar:sonar"
  }
  script.withSonarQubeEnv('SonarQube') {
    timeout(time: 1, unit: 'HOURS') {
      waitForQualityGate abortPipeline: true
    }
  }
  // script.bat "mvn clean verify sonar:sonar -Dsonar.projectKey=library-analysis -Dsonar.host.url=http://localhost:9000 -Dsonar.login=sqp_bdf628850b7cc4298af968a089d3ca1f46b594b7"

  // Verificación del quality gate utilizando el comando curl y findstr
  //   script.bat 'curl -s -X GET -u sqp_bdf628850b7cc4298af968a089d3ca1f46b594b7: "http://localhost:9000/api/qualitygates/project_status?projectKey=library-analysis"'

}