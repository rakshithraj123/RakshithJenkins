pipeline {
  agent any


  stages {
  
        stage('Compile') {
          steps {
            // Compile the app and its dependencies
            bat './gradlew compileDebugSources'
           }
        }
		
        
        
		stage('UI test') {
           steps {
             // Compile and run the unit tests for the app and its dependencies
             bat  '''#!/bin/bash
			    

                #Start the emulator
                $ANDROID_SDK/tools/emulator -avd android_emulator_pie -wipe-data &
                EMULATOR_PID=$!

                # Wait for Android to finish booting
                WAIT_CMD="$ANDROID_SDK/platform-tools/adb wait-for-device shell getprop init.svc.bootanim"
                until $WAIT_CMD | grep -m 1 stopped; do
                echo "Waiting..."
                sleep 1
                done

                # Unlock the Lock Screen
                $ANDROID_SDK/platform-tools/adb shell input keyevent 82

                # Clear and capture logcat
                $ANDROID_SDK/platform-tools/adb logcat -c
                $ANDROID_SDK/platform-tools/adb logcat > build/logcat.log &
                LOGCAT_PID=$!

                # Run the tests
                ./gradlew connectedAndroidTest -i

                # Stop the background processes
                kill $LOGCAT_PID
                kill $EMULATOR_PID					   
			 '''
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