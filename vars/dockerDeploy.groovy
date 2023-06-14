def call(script) {
  def networkCheck = script.bat(
    returnStdout: true,
    script: 'docker network inspect java_network'
  ).trim()

  println "Salida del comando 'docker network inspect':"
  println networkCheck

  if (networkCheck.contains('[]"')) {
    // La red no existe, se crea
    script.bat 'docker network create java_network'
  } else {
    // La red ya existe, se imprime un mensaje
    println "La red 'java_network' ya existe."
  }

  // Resto de tu código aquí
  script.bat 'docker run -d --network java_network --name javacontainer -p 8081:8080 mateopulido99/javaaplication:v1.0'
}
