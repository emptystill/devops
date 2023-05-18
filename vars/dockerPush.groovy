def call(script) {
  // Comando para enviar la imagen de Docker con los parámetros especificados a Docker Hub
  script.bat "docker push mateodpl99/javaaplicationv1.0"
}