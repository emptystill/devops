def call(script, args) {
      // echo "+++++++${script}+++++++"
      // echo "+++++++${script.tool 'Maven_3.9.0'}+++++++" //Para conocer la ruta de las herramientas
      script.bat "mvn clean package"
}
