def call() {
    stage('CodeAnalysis') {
        steps {
            // Ejecuta el análisis estático del código con SonarQube
            withSonarQubeEnv('SonarQube') {
                bat 'mvn sonar:sonar'
            }
        }
    }
}