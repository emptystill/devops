def call(String repoUrl, String branch) {
  node {
    stage("Cloning repository") {
        git url: repoUrl, branch: branch
    }
  }
}