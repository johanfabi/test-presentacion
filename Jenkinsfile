pipeline {
    agent {
        docker {
            image 'maven:3.8.7-eclipse-temurin-8'
            args '-v $HOME/.m2:/root/.m2'
        }
    }
    stages {
        stage('Checkout SCM') {
            steps {
                print('========================================================================================================')
                print('Checkout SCM')
                print('========================================================================================================')
                checkout([$class: 'GitSCM', branches: [[name: "*/main"]], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [],
                userRemoteConfigs: [[credentialsId: 'github-credentials', url: "https://github.com/johanfabi/test-presentacion"]]])
            }
        }
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
                print('Run Functional Tests' + 'Test Case: ' + env.TAGS)
                print('========================================================================================================')
                sh 'mvn -v'
                sh '''
                    mvn clean test -Dtest="MainRun"  -Dcucumber.filter.tags="$TAGS"
                '''
            }
        }
    }
}