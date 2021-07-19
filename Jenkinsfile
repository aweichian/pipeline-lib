#!groovy
@Library('pipeline-lib') _

def tools = new org.devops.tools()

String workspace = "/opt/jenkins/workspace"

pipeline {
    agent {
    node {
        label "build"   // 指定运行节点的标签或名称 
        customWorkspace "${workspace}"   // 指定运行工作目录（可选）
    }
}
options {
    timestamps()    // 日志的时间戳
    skipDefaultCheckout()  // 删除隐式checkout scm语句
    disableConcurrentBuilds()  // 禁止并行
    timeout(time: 1, unit: 'HOURS')  // 流水线超时设置1h
}

parameters {
    string (name: 'PERSON',defaultValue: 'mr jenkins',description: 'who should i say hello to?')
}

stages {
    // 下载代码
    stage("GetCode") { // 阶段名称
        steps { // 步骤
            timeout(time:5, unit:"MINUTES") {  // 步骤超时时间
                script {
                    println("接取代码")
                }
            }
        }
    }
    // 构建
    stage("Build") {
        steps {
            timeout(time:20, unit:"MINUTES") {
                script {
                    println("接取代码")
                }
            }
        }
    }
    // 代码扫描
    stage("CodeScan") {
        steps {
            timeout(time:30, unit:"MINUTES") {
                script {
                    println("代码扫描")
                    tools.PrintMsg("call shared library.................-------------_+++++++++++++++")
                }
            }
        }
    }   
}

post {
    always {
        script {
            println("always")
        }
    }

    success {
        script {
            currentBuild.description += "\n 构建成功"
        }
    }  

    failure {
        script {
            currentBuild.description += "\n 构建失败"
        }
    } 

    aborted {
        script {
            currentBuild.description += "\n 构建取消"
        }
    }  
}




}
