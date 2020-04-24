pipeline {
  agent any

  stages {
    stage('Compile') {
      steps {
        // Compile the app and its dependencies
        sh './gradlew compileDebugSources'
      }
    }
  post {
    failure {
      // Notify developer team of the failure
      mail to: 'rakshithraj11@gmail.com', subject: 'Oops!', body: "Build ${env.BUILD_NUMBER} failed; ${env.BUILD_URL}"
    }
  }
}