def call() {
  def mvnHome = tool 'Maven_3.9.0'
  sh "${mvnHome}/bin/mvn clean package"
}
