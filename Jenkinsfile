pipeline {
  agent any

   
  stages {
  
                 stage('build') {
             steps {
                try { checkout scm } catch(caughtError) { deleteDir(); checkout scm }
            }
			   
         }
		 
		 
         stage('Compile') {
            steps {
        // Compile the app and its dependencies
                sh './gradlew compileDebugSources'
                }
         }
    }
}