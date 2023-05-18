def call(script) {
  // Comando para construir la imagen de Docker con los parámetros especificados
  script.bat "docker build -t javaaplication . && docker tag javaaplication mateopulido99/javaaplication:v1.0"
}