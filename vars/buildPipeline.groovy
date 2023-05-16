def call(script, asrgs) {
      script.sh "${script.tool 'Maven_3.9.0'}/bin/mvn -s ${script.env.HOME}/jenkins.xml -o ${args}"
}
