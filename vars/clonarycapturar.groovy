def call(String scmUrl) {
    stages {
      stage('Clonar y Capturar') {
        steps {
          checkout([
            $class: 'GitSCM',
            branches: [
              [name: 'feature']
            ], // Rama específica que deseas capturar
            userRemoteConfigs: [
              [url: scmUrl]
            ], // Utiliza la URL pasada como parámetro
            extensions: [
              [$class: 'CleanBeforeCheckout']
            ] // Realiza una limpieza antes de clonar
          ])
        }
      }
    }
  }