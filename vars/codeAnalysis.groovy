def call(script, args) {
      echo "+++++++${script}+++++++"
      echo "+++++++${script.tool 'SonarQube'}+++++++"
      script.bat "${script.tool 'SonarQube'}/bin/mvn.cmd -o ${args}"
}
