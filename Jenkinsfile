pipeline {
  agent any

   
  stages {
  
          
		 
         stage('Compile') {
            steps {
        // Compile the app and its dependencies
                bat  './gradlew compileDebugSources'
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
    }
}