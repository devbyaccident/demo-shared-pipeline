def call (body) {
   def config = [:]
   body.resolveStrategy = Closure.DELEGATE_FIRST
   body.delegate = config
   body()

   pipeline {
      agent any
      stages {
         stage('Hello From Container') {
            agent { docker 'golang:alpine3.12' }
            steps {
               echo "Hello Go"
               sh "go version"
            }
         }
      }
   }
}