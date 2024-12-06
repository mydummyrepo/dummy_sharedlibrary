def call(Map config) {
    pipeline{
    agent{
        label "${config.label}"
    }
    tools{
        maven "${config.maven}"
    }
    stages{
        stage('SCM'){
            steps{
                git(
                    'url': "${config.url}",
                    'branch': "${config.branch}"
                )
            }
        }
        stage('BUILD'){
            steps{
                sh "mvn ${config.goal}"
            }
        }
    }
  }
}