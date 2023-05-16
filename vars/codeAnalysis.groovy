def call(script, args) {
      echo "+++++++${script}+++++++"
      echo "+++++++${script.tool 'SonarQube'}+++++++"
      script.bat "${script.tool 'SonarQube'}/bin/sonar-scanner.bat -o ${args}"
}
