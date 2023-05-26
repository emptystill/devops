def call(script) {
  script.bat """
  GitSCM git = new GitSCM()
  git.userRemoteConfigs([
    [url: scmUrl]
  ])
  git.branches([
    [name: 'feature']
  ])
  git.extensions([
    [\$class: 'CleanBeforeCheckout']
  ])
  """
}
