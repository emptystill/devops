def call(script) {
  // Comando para enviar la imagen de Docker con los parámetros especificados a Docker Hub
  script.bat "docker push mateopulido99/javaaplicationv1.0"
}