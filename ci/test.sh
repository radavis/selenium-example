#!/bin/sh
set -ex 

export ROOT_FOLDER=$( pwd )
export GRADLE_USER_HOME="${ROOT_FOLDER}/.gradle"

cd selenium-git-repo
./gradlew test