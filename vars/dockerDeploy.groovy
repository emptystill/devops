def call(script) {
  // Comando para iniciar un nuevo contenedor con la imagen especificada
  script.bat "docker network create java_network"
  script.bat "docker run -d --network java_network --name javacontainer -p 8081:8080 mateopulido99/javaaplication:v1.0"
}