pipeline {
  agent any

   
  stages {
  
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
}