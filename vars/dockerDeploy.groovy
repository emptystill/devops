def call(script) {
  def containerName = 'my-container'
  def imageName = 'JavaAplication'
  def imageTag = 'mateodpl99/JavaAplicationv1.0'

  // Detener y eliminar el contenedor si ya existe
  script.bat "docker stop ${containerName} || true"
  script.bat "docker rm ${containerName} || true"

  // Comando para iniciar un nuevo contenedor con la imagen especificada
  script.bat "docker run -d --name ${containerName} -p 8080:8080 ${imageName}:${imageTag}"
}