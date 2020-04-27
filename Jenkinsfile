pipeline {
  agent any

  options {
    // Stop the build early in case of compile or test failures
    skipStagesAfterUnstable()
  }
  stages {
  
        stage('Compile') {
          steps {
            // Compile the app and its dependencies
            sh './gradlew compileDebugSources'
           }
        }
		
        stage('Unit test') {
           steps {
             // Compile and run the unit tests for the app and its dependencies
             sh './gradlew testDebugUnitTest testDebugUnitTest'

              // Analyse the test results and update the build result as appropriate
              junit '**/TEST-*.xml'
            }
        }
  
   
		stage('Build APK') {
          steps {
             // Finish building and packaging the APK
              bat './gradlew assembleDebug'

              // Archive the APKs so that they can be downloaded from Jenkins
              archiveArtifacts '**/*.apk'
            }
		 
		  post {
           success {
             // Notify if the upload succeeded
              mail to: 'rakshithraj11@gmail.com', subject: 'New build available!', body: 'Check it out!'
            }
          }
        }         
    }
	
	post {
      failure {
      // Notify developer team of the failure
      mail to: 'nkdiyasys@gmail.com', subject: 'Oops!', body: "Build ${env.BUILD_NUMBER} failed; ${env.BUILD_URL}"
      }
    }
}