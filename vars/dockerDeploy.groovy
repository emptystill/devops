def call(script) {
  // Comando para iniciar un nuevo contenedor con la imagen especificada
  script.bat "docker run -d --name javacontainer -p 8081:8080 mateopulido99/javaaplication:v1.0"
}