def call(script) {
  // Comando para enviar la imagen de Docker con los parámetros especificados a Docker Hub
  script.bat "docker pull owasp/zap2docker-stable"
  // script.bat "docker run -v datosowasp1:/zap/wrk/:rw --network java_network --name owasp-container --user root -t owasp/zap2docker-stable zap-full-scan.py -t http://javacontainer:8080 -r datosowasp1.html 2> /dev/null" 
  def exitCode = bat(script: 'docker run -v datosowasp1:/zap/wrk/:rw --network java_network --name owasp-container --user root -t owasp/zap2docker-stable zap-full-scan.py -t http://javacontainer:8080 -r datosowasp1.html', returnStatus: true)
  if (exitCode == 2) {
    echo 'El comando retornó el código de salida 2, pero lo estamos ignorando.'
    // Realiza acciones adicionales si es necesario
  } else {
    // Realiza acciones en caso de que el código de salida no sea 2
  }
}