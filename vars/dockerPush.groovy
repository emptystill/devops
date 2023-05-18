def call(script) {
  def imageName = 'JavaAplication'
  def imageTag = 'mateodpl99/JavaAplicationv1.0'

  // Comando para enviar la imagen de Docker con los parámetros especificados a Docker Hub
  script.bat "docker push JavaAplication:mateodpl99/JavaAplicationv1.0"
}