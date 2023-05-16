def call(script) {
      echo "+++++++${script}+++++++"
      echo "+++++++${script.tool 'SonarQube'}+++++++"
      script.bat "${script.tool 'SonarQube'}/bin/sonar-scanner.bat"
}
