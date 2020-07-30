FROM tronprotocol/centos7-jdk8

ENV TMP_DIR="/tron-build"
ENV BASE_DIR="/java-tron"


RUN set -o errexit -o nounset \
    && yum -y install git wget \
    && wget -P /usr/local https://github.com/frekele/oracle-java/releases/download/8u202-b08/$JDK_TAR \
    && echo "$JDK_MD5 /usr/local/$JDK_TAR" | md5sum -c \
    && tar -zxf /usr/local/$JDK_TAR -C /usr/local\
    && rm /usr/local/$JDK_TAR \
    && export JAVA_HOME=/usr/local/$JDK_DIR \
    && export CLASSPATH=$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar \
    && export PATH=$PATH:$JAVA_HOME/bin \
    && echo "git clone" \
    && mkdir -p $TMP_DIR \
    && cd $TMP_DIR \
#    && git clone https://github.com/tronprotocol/java-tron.git \
    && git clone -b docker_tron https://github.com/guoquanwu/java-tron.git \
    && cd java-tron \
    && git checkout docker \
    && ./gradlew build -x test \
    && cd build/distributions \
    && unzip -o java-tron-1.0.0.zip \
    && mv java-tron-1.0.0 $BASE_DIR \
    && rm -rf $TMP_DIR \
    && rm -rf ~/.gradle \
    && mv $JAVA_HOME/jre /usr/local \
    && rm -rf $JAVA_HOME

ENV JAVA_HOME="/usr/local/jre"
ENV PATH=$PATH:$JAVA_HOME/bin

COPY docker-entrypoint.sh $BASE_DIR/bin

WORKDIR $BASE_DIR

ENTRYPOINT ["./bin/docker-entrypoint.sh"]