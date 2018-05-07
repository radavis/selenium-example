FROM openjdk:8-jdk

ENV GRADLE_HOME /opt/gradle
ENV GRADLE_VERSION 4.7

ARG GRADLE_DOWNLOAD_SHA256=fca5087dc8b50c64655c000989635664a73b11b9bd3703c7d6cabd31b7dcdb04
RUN set -o errexit -o nounset \
	&& echo "Downloading Gradle" \
	&& wget --no-verbose --output-document=gradle.zip "https://services.gradle.org/distributions/gradle-${GRADLE_VERSION}-bin.zip" \
	\
	&& echo "Checking download hash" \
	&& echo "${GRADLE_DOWNLOAD_SHA256} *gradle.zip" | sha256sum --check - \
	\
	&& echo "Installing Gradle" \
	&& unzip gradle.zip \
	&& rm gradle.zip \
	&& mv "gradle-${GRADLE_VERSION}" "${GRADLE_HOME}/" \
	&& ln --symbolic "${GRADLE_HOME}/bin/gradle" /usr/bin/gradle \
	\
	&& echo "Adding gradle user and group" \
	&& groupadd --system --gid 1000 gradle \
	&& useradd --system --gid gradle --uid 1000 --shell /bin/bash --create-home gradle \
	&& mkdir /home/gradle/.gradle \
	&& chown --recursive gradle:gradle /home/gradle \
	\
	&& echo "Symlinking root Gradle cache to gradle Gradle cache" \
	&& ln -s /home/gradle/.gradle /root/.gradle

# Allow https sources
RUN apt-get update && apt-get install -y apt-transport-https

# Install Chrome
RUN apt-get update \
&& apt-get install -y libxss1 libappindicator3-1 libindicator7 fonts-liberation lsb-release xdg-utils \
&& wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb \
&& dpkg -i google-chrome*.deb \
&& apt-get install -f \
&& rm "google-chrome-stable_current_amd64.deb"

# Install xvfb to run headless
RUN apt-get install -y xvfb

# Install Chromedriver 
RUN wget -N http://chromedriver.storage.googleapis.com/2.38/chromedriver_linux64.zip \
&& unzip chromedriver_linux64.zip \
&& chmod +x chromedriver \
&& mv -f chromedriver /usr/local/share/chromedriver \
&& ln -s /usr/local/share/chromedriver /usr/local/bin/chromedriver \
&& ln -s /usr/local/share/chromedriver /usr/bin/chromedriver \
&& rm "chromedriver_linux64.zip"
