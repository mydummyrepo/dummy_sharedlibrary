def call(Map config) {
    pipeline {
        agent {
            label "${config.label}"
        }
        tools {
            maven "${config.maven}" // Correctly defined Maven tool
        }
        stages {
            stage('SCM') {
                steps {
                    git(
                        url: "${config.url}",
                        branch: "${config.branch}"
                    )
                }
            }
            stage('BUILD') {
                steps {
                    sh "mvn ${config.goal}" // Ensure config.goal is defined correctly
                }
            }
        }
    }
}