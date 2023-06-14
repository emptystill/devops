def call(script) {
  script.bat "docker pull owasp/zap2docker-stable"
  script.bat "docker run -v owaspscanner:/zap/wrk/:rw --network java_network --name owasp-container --user root -t owasp/zap2docker-stable zap-full-scan.py -t http://javacontainer:8080 -r fullscan-results.html -I"

  def containerCheck = script.bat(
    returnStatus: true,
    script: 'docker inspect owasp-container >nul 2>&1'
  )

  if (containerCheck != 0) {
    script.bat 'docker run -v datosowasp1:/zap/wrk/:rw --network java_network --name owasp-container --user root -t owasp/zap2docker-stable zap-baseline.py -t http://javacontainer:8080 -r baseline-results.html -I'
  } else {
    println "El contenedor 'owasp-container' ya existe, continúa con el pipeline."
  }
}
