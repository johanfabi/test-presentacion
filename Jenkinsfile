pipeline {
    agent {
        docker {
            image 'maven:3.8.7-eclipse-temurin-8'
            args '-v $HOME/.m2:/root/.m2'
        }
    }
    stages {
        stage('SonarQube Analysis') {
            steps {
                print('========================================================================================================')
                print('SonarQube Analysis')
                print('========================================================================================================')
            }
        }
        stage('Build Component') {
            steps {
                print('========================================================================================================')
                print('Build Component')
                print('========================================================================================================')
            }
        }
        stage('Deploy BETA Environment') {
            steps {
               print('========================================================================================================')
               print('Deploy BETA Environment')
               print('========================================================================================================')
            }
        }
        stage('Run Functional Tests') {
            steps {
                print('========================================================================================================')
                print('Tests: Checkout SCM')
                print('========================================================================================================')
                checkout([$class: 'GitSCM', branches: [[name: "*/main"]], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [],
                userRemoteConfigs: [[credentialsId: 'github-credentials', url: "https://github.com/johanfabi/bedevops-functional-testing.git"]]])
                print('========================================================================================================')
                print('Run Functional Tests - ' + 'Case: ' + env.TAGS)
                print('========================================================================================================')
                sh 'mvn -v'
                sh '''
                    mvn clean test -Dtest="MainRun"  -Dcucumber.filter.tags="$TAGS"
                '''
            }
        }
    }
}