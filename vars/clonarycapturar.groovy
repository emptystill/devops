def call(String repoUrl, String branch) {
  node {
    stage("Cloning repository") {
      dir('.') {
        git url: repoUrl, branch: branch
      }
    }
  }
}