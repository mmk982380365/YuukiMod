node {
   def mvnHome
   stage('Preparation') { // for display purposes
      // Get some code from a GitHub repository
    //   git 'https://github.com/mmk982380365/YuukiJs.git'
      // Get the Maven tool.
      // ** NOTE: This 'M3' Maven tool must be configured
      // **       in the global configuration.          
   }
   stage('Build') {
      // Run the maven build
       
      ./gradlew build
      
   }
   stage('Results') {
      echo "success"
      // archive 'target/*.jar'
   }
}