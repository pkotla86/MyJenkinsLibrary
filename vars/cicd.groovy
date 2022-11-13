def GitDownload(repo)
{
	git "https://github.com/pkotla86/${repo}.git"
}

def MavenBuild()
{
	sh 'mvn package'
}

def DeployArtifact(jobname,ipaddress,context)
{
	sh 'scp /home/ubuntu/.jenkins/workspace/${jobname}/webapp/target/webapp.war ubuntu@${ipaddress}:/var/lib/tomcat9/webapps/${context}.war'         	

}

def RunSelenium(jobname)
{
	sh 'java -jar /home/ubuntu/.jenkins/workspace/${jobname}/testing.jar'
}

def SendMail(body,subject,emailId)
{
	mail bcc: '', body: "${body}", cc: '', from: '', replyTo: '', subject: "${subject}", to: "${emailId}"
}
