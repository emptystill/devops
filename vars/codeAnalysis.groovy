def call(script) {
    script.bat "mvn clean verify sonar:sonar -Dsonar.projectKey=library-analysis -Dsonar.host.url=http://localhost:9000 -Dsonar.login=sqp_bdf628850b7cc4298af968a089d3ca1f46b594b7"

    // Verificación del quality gate utilizando la API de SonarQube
    def qualityGateResult = script.bat(returnStdout: true, script: """
        curl -s -X GET -u sqp_bdf628850b7cc4298af968a089d3ca1f46b594b7: 'http://localhost:9000/api/qualitygates/project_status?projectKey=library-analysis'
    """)

    // Verificar si el quality gate no se pasa
    if (qualityGateResult.contains('"status":"ERROR"')) {
        script.error "Quality gate failed. Pipeline halted."
        script.error("Exiting with failure")
        script.error("exit 1")
    }
}
