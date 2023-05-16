def call(script, args) {
      script.sh "${script.tool 'Maven_3.9.0'}/bin/mvn -o ${args}"
}
