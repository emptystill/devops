def call(script) {
  // Comando para verificar si la red ya existe
  def networkCheck = script.returnStatus(
    script: "docker network inspect java_network > /dev/null 2>&1 || echo 1",
    returnStdout: true
  )

  if (networkCheck.trim() == "1") {
    // La red no existe, se crea
    script.bat "docker network create java_network"
  } else {
    // La red ya existe, se imprime un mensaje
    println "La red 'java_network' ya existe."
  }

  // Resto de tu código aquí
  script.bat "docker run -d --network java_network --name javacontainer -p 8081:8080 mateopulido99/javaaplication:v1.0"
}
