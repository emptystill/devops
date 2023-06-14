def call(script) {
  // Comando para crear o usar la red existente
  script.bat 'docker network create --driver bridge java_network'

  script.bat 'docker run -d --network java_network --name javacontainer -p 8081:8080 mateopulido99/javaaplication:v1.0'
}
