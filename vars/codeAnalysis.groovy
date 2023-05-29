def call(script) {
  script.bat "mvn clean verify sonar:sonar -Dsonar.projectKey=library-analysis -Dsonar.host.url=http://localhost:9000 -Dsonar.login=sqp_bdf628850b7cc4298af968a089d3ca1f46b594b7"

  script.waitForQualityGate() // Esperar al Quality Gate
}