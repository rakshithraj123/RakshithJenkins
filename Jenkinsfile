pipeline {
  agent any

   
  stages {
  
          
		 
         stage('Compile') {
            steps {
        // Compile the app and its dependencies
                bat  './gradlew compileDebugSources'
                }
         }
		 
		 stage('Unit test') {
         steps {
          // Compile and run the unit tests for the app and its dependencies
           bat './gradlew testDebugUnitTest testDebugUnitTest'

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
       }
	   
	    stage('Static analysis') {
          steps {
           // Run Lint and analyse the results
           bat './gradlew lintDebug'
           androidLint pattern: '**/lint-results-*.xml'
         }
       }
    }
}