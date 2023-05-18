def call(script) {
  // Comando para enviar la imagen de Docker con los parámetros especificados a Docker Hub
  script.bat "docker tag javaaplication mateopulido99/javaaplication:v1.0"
  script.bat "docker push mateopulido99/javaaplication:v1.0"
}
