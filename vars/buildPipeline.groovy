def call() {
      withMaven(maven: 'Maven_3.9.0') {
        sh 'mvn clean package'
    }
}
