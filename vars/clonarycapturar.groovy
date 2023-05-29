def call(String repoUrl, String branch) {
  node {
      git url: repoUrl, branch: branch
    }
  }
