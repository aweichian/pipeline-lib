package org.devops


def Build(buildType, buildShell) {
	def buildTools = ["mvn":"M2","npm":"NPM"]
	println("当前选择的构建类型为 ${buildType}")
	buildHome= tool buildTools[buildType]
        if ("${buildType}" == "npm") {
		sh """
		    export NODE_HOME=${buildHome}
		    export PATH=\$NODE_HOME/bin:\$PATH
                    ${buildHome}/bin/${buildType} ${buildShell}"""
	} else {
		sh "${buildHome}/bin/${buildType} ${buildShell}"
	}

}
