# kotlin-spring-vaadin-template

## unfortunately, I am presented with the following error:
```
Failed to determine project directory for dev mode. 
Directory 'kotlin-consumer-template' does not look like a Maven or Gradle project. 
Ensure that you have run the prepare-frontend Maven goal, which generates 'flow-build-info.json', prior to deploying your application
```
## Resolved!
The aforementioned error message is completely misleading, actually the problem is with npm. Just add the following line to file build.gradle.kts, to the list of plugins:
```
	id("com.vaadin") version "0.17.0.1"
```
