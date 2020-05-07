pipeline {
  agent any

 //def ANDROID_HOME='D:/android_tool/adt-bundle-windows-x86_64-20140702/sdk'
  stages {


        
		stage('UI test') {
           steps {
                 parallel (
                    launchEmulator: {
                           bat 'D:/android_tool/adt-bundle-windows-x86_64-20140702/sdk/emulator/emulator -avd pixel_api_29'
                    },
                    runAndroidTests: {
                       bash '''#!/bin/bash
                            WAIT_CMD="D:/android_tool/adt-bundle-windows-x86_64-20140702/sdk/platform-tools/adb wait-for-device shell getprop init.svc.bootanim"
                            until $WAIT_CMD | grep -m 1 stopped; do
                              echo "Waiting..."
                              sleep 1
                            done
                           '''
                           bat './gradlew connectedAndroidTest -i'
                     }

                    }
                 )
               }
        }
		


        stage('Compile') {
          steps {
            // Compile the app and its dependencies
            bat './gradlew compileDebugSources'
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
		 
		  //post {
          // success {
             // Notify if the upload succeeded
             // mail to: 'rakshithraj11@gmail.com', subject: 'New build available!', body: 'Check it out!'
            //}
          //}
        }         
    }
	
	//post {
     // failure {
         // Notify developer team of the failure
         //mail to: 'nkdiyasys@gmail.com', subject: 'Oops!', body: "Build ${env.BUILD_NUMBER} failed; ${env.BUILD_URL}"
     // }
    //}
}