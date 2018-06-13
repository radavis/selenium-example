# selenium-example

This repository was created as a resource for setting up selenium on future projects.

## Running Tests

- Clone this repository
	```
    git clone https://github.com/pivotal-kahin-ng/selenium-example.git
    ```
### Via IDE
1. On your favorite IDE, import the project with Gradle as the external model
2. Use testng.xml to run the test

### Via Command Line
- In the repository, run the gradle task
	```
    ./gradlew test
    ```

### Via CI

As part of this example project, CI (Concourse) is set up to run the tests when the repository has been updated. 

To get started, install concourse and fly cli.

- Navigate to project directory and set the pipeline
	```
    fly set-pipeline -c ci/pipeline.yml -p PIPELINE_NAME -t TARGET_NAME
    ```
## Resource

Here is a list of resources that are used and/or necessary for this project

- [Chrome Driver](http://chromedriver.chromium.org/)
- [FireFox Driver](https://github.com/mozilla/geckodriver/releases)
- [Concourse](https://concourse-ci.org/)
- [Docker](https://docs.docker.com/install/)
	- [java + chromedriver image](https://github.com/pivotal-kahin-ng/docker-java-chromedriver)
