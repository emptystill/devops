def call(script, args) {
  print script.env.GIT_BRANCH
  script.withMaven(maven: 'Maven_3.9.0') {
    script.bat "mvn clean package"
  }
}