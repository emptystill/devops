def call() {
  def mvnHome = tool 'Maven'
  sh "${mvnHome}/bin/mvn clean package"
}
