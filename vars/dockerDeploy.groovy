def call(script) {
  // Comando para verificar si la red ya existe
  def networkExists = script.bat 'docker network inspect java_network', returnStatus: true

  if (networkExists != 0) {
    // La red no existe, se crea
    script.bat 'docker network create java_network'
  } else {
    // La red ya existe, se imprime un mensaje
    println "La red 'java_network' ya existe."
  }

  // Resto de tu código aquí
  script.bat 'docker run -d --network java_network --name javacontainer -p 8081:8080 mateopulido99/javaaplication:v1.0'
}
