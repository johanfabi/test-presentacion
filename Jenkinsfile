pipeline {
    agent {
        docker {
            image 'maven:3.8.7-eclipse-temurin-8'
            args '-v $HOME/.m2:/root/.m2'
        }
    }
    stages {
        stage('Checkout') {
            steps {
                println('-------------------------------------------------------------------------------------------------------')
                println('Checkout SCM')
                println('-------------------------------------------------------------------------------------------------------')
                checkout([$class: 'GitSCM', branches: [[name: "*/main"]], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [],
                userRemoteConfigs: [[credentialsId: 'github-credentials', url: "https://github.com/johanfabi/test-selenium"]]])
            }
        }
        stage('SonarQube Analysis') {
            steps {
                println('-------------------------------------------------------------------------------------------------------')
                println('SonarQube Analysis')
                println('-------------------------------------------------------------------------------------------------------')
            }
        }
        stage('Build') {
            steps {
                println('-------------------------------------------------------------------------------------------------------')
                println('Build')
                println('-------------------------------------------------------------------------------------------------------')
            }
        }
        stage('Deploy BETA') {
            steps {
               println('-------------------------------------------------------------------------------------------------------')
               println('Deploy BETA')
               println('-------------------------------------------------------------------------------------------------------')
            }
        }
        stage('Test') {
            steps {
                println('-------------------------------------------------------------------------------------------------------')
                println('Running Tes' + $TAGS)
                println('-------------------------------------------------------------------------------------------------------')
                sh 'echo $TAGS'
                sh 'mvn -v'
                sh '''
                    mvn clean test -Dtest="MainRun"  -Dcucumber.filter.tags="$TAGS"
                '''
            }
        }
    }
}