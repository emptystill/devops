def call(script) {
  def imageName = 'JavaAplication'
  def imageTag = 'mateodpl99/JavaAplicationv1.0'

  // Comando para construir la imagen de Docker con los parámetros especificados
  script.bat "docker build -t JavaAplication -t mateodpl99/JavaAplicationv1.0 ."
}