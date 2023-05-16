def call(script, args) {
      echo "+++++++${script}+++++++"
      echo "+++++++${script.tool 'Maven_3.9.0'}+++++++"
      script.sh "${script.tool 'Maven_3.9.0'}/bin/mvn -o ${args}"
}
