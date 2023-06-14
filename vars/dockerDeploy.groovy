def call(script) {
  // Comando para verificar si la red ya está creada
  def networkExists = script.returnStatus("docker network inspect java_network")

  if (networkExists != 0) {
    // La red no existe, se crea
    script.bat "docker network create java_network"
  } else {
    // La red ya existe, se ignora la acción de crearla
    println "La red 'java_network' ya está creada."
  }

  script.bat "docker run -d --network java_network --name javacontainer -p 8081:8080 mateopulido99/javaaplication:v1.0"
}
