def call() {
  stage('Checkout') {
    steps {
      checkout scm
    }
  }

  stage('Build') {
    steps {
      withMaven(maven: 'Maven_3.9.0') {
        bat 'mvn clean package'
      }
    }
  }
}
