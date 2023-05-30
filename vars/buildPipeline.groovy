def call(script, args) {
  script.withMaven(maven: 'Maven_3.9.0') {
    script.bat "mvn package"
  }
}