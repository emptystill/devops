def call(String repoUrl, String branch) {
  node {
    stage("Cloning repository") {
      dir('repo') {
        git url: repoUrl, branch: branch
      }
    }
  }
}