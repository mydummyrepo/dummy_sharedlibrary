def call() {
    pipeline{
    agent{
        label 'java'
    }
    tools{
        maven 'apache-maven-3.9.9'
    }
    stages{
        stage('SCM'){
            steps{
                git 'url': 'https://github.com/mydummyrepo/spring-petclinic.git',
                    'branch': 'main'
            }
        }
        stage('BUILD'){
            steps{
                sh 'mvn clean package'
            }
        }
    }
  }
}