def call(script) {
  // Comando para enviar la imagen de Docker con los parámetros especificados a Docker Hub
  script.bat "docker pull owasp/zap2docker-stable"
  script.bat "docker run -v datosowasp1:/zap/wrk/:rw --user root -t owasp/zap2docker-stable zap-full-scan.py -t http://javacontainer:8081 -r datosowasp1.html -a"  
}