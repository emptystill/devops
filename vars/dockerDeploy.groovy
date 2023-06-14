def call(script) {
  def networkCheck = script.bat(
    returnStatus: true,
    script: 'docker network inspect java_network >nul 2>&1'
  )

  if (networkCheck != 0) {
    script.bat 'docker network create java_network'
  } else {
    println "La red 'java_network' ya existe."
  }

  def containerCheck = script.bat(
    returnStatus: true,
    script: 'docker inspect javacontainer >nul 2>&1'
  )

  if (containerCheck != 0) {
    script.bat 'docker run -d --network java_network --name javacontainer -p 8081:8080 mateopulido99/javaaplication:v1.0'
  } else {
    println "El contenedor 'javacontainer' ya existe, continúa con el pipeline."
  }
}
