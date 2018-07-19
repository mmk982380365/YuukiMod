node {
   stage('get clone') { // for display purposes
      // Get some code from a GitHub repository
    //   git 'https://github.com/mmk982380365/YuukiJs.git'
      // Get the Maven tool.
      // ** NOTE: This 'M3' Maven tool must be configured
      // **       in the global configuration.     
      git credentialsId: 'd7b9e44a-65ac-47e3-a2a6-06897aa94a6e', url: 'https://github.com/mmk982380365/YuukiMod.git'
      echo "git check"
   }
   stage('Build') {
      // Run the maven build
      echo "build"
      sh "./gradlew build"
      
      
   }
   stage('archive') {
      
      // archive 'target/*.jar'
      archiveArtifacts 'build/libs/*.jar'
      
      echo "success"
   }
}