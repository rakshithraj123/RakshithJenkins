pipeline {
  agent any

   try { checkout scm } catch(caughtError) { deleteDir(); checkout scm }
  stages {
         stage('Compile') {
      steps {
        // Compile the app and its dependencies
        sh './gradlew compileDebugSources'
      }
    }
    }
}