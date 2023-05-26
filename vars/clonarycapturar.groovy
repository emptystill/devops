def call(script) {
  script.bat """
  def scm = new hudson.plugins.git.GitSCM()
  scm.userRemoteConfigs([[
    url: scmUrl
  ]])
  scm.branches([[
    name: 'feature'
  ]])
  scm.extensions([[
    \$class: 'hudson.plugins.git.extensions.impl.CleanBeforeCheckout'
  ]])

  return scm
  """
}
