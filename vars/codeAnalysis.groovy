def call(script) {
  script.withSonarQubeEnv('SonarQube') {
    bat "mvn clean verify sonar:sonar"
  }
  script.withSonarQubeEnv('SonarQube') {
    timeout(time: 3, unit: 'MINUTES') {
      waitForQualityGate abortPipeline: true
    }
  }
}