def call() {
  stage('Checkout') {
    steps {
      checkout scm
    }
  }

  stage('Test') {
    steps {
      // Agrega aquí los pasos para ejecutar las pruebas
    }
  }
}
