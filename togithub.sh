cd c:/Users/User/Cleanworkspace/LoizArtifactExeptions && git init && echo -e "target/\n.classpath\n.gitignore\n.project\n.settings/"  >> .gitignore && git add --all && git commit -m "Java 8 exceptions" && git remote add origin git@github.com:userInterview/javaexceptions.git && git branch java8exceptions && git checkout java8exceptions && eval "$(ssh-agent -s)" && ssh-add ~/.ssh/winkeyloizv2 && git push --set-upstream origin java8exceptions