def call(script) {
  script.bat "docker pull owasp/zap2docker-stable"
  script.bat "docker run --rm -v owaspscanner:/zap/wrk/:rw --network java_network --user root -t owasp/zap2docker-stable zap-full-scan.py -t http://javacontainer:8080 -r fullscan-results.html -I"
  script.bat "docker run --rm -v owaspscanner:/zap/wrk/:rw --network java_network --user root -t owasp/zap2docker-stable zap-baseline.py -t http://javacontainer:8080 -r baseline-results.html -I"
}
