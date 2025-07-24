def call(String imageName , String tag){
  withCredentials([usernamePassword("credentialsId": "dockerHubCred" , usernameVariable : "dockerHubUser" , passwordVariable: "dockerHubPass")]){
    sh "docker login -u ${dockerHubUser} -p ${dockerHubPass}"
    sh "docker image tag ${imageName} ${dockerHubUser}/${imageName}:${tag}"
    sh "docker push ${dockerHubUser}/${imageName}"
  }
}
