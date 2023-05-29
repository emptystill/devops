def call(String repoUrl, String branch) {
  node {
    stage("Clonar y Capturar") {
        git url: repoUrl, branch: branch
    }
  }
}