FROM docker.io/maven:3 as builder
WORKDIR /tmp

# summit-2020-pam-fraudmanagement
RUN git clone https://github.com/RedHat-Consulting-UK/summit-2020-pam-fraudmanagement.git && \
    cd /tmp/summit-2020-pam-fraudmanagement && \
    mvn de.qaware.maven:go-offline-maven-plugin:resolve-dependencies -DdownloadSources -DdownloadJavadoc -B -Dmaven.repo.local=/tmp/bucketrepo && \
    mvn dependency:go-offline -B -Dmaven.repo.local=/tmp/bucketrepo && \
    mvn clean install -DskipTests -B -Dmaven.repo.local=/tmp/bucketrepo && \
    cd /tmp/bucketrepo && \
    find -iname "*.repositories" -exec rm -f {} \;

# summit-2020-kogito-businessautomation
RUN git clone https://github.com/RedHat-Consulting-UK/summit-2020-kogito-businessautomation.git && \
    cd /tmp/summit-2020-kogito-businessautomation && \
    mvn de.qaware.maven:go-offline-maven-plugin:resolve-dependencies -DdownloadSources -DdownloadJavadoc -B -Dmaven.repo.local=/tmp/bucketrepo && \
    mvn dependency:go-offline -B -Dmaven.repo.local=/tmp/bucketrepo && \
    mvn clean install -DskipTests -B -Dmaven.repo.local=/tmp/bucketrepo && \
    cd /tmp/bucketrepo && \
    find -iname "*.repositories" -exec rm -f {} \;

FROM gcr.io/jenkinsxio/bucketrepo:0.1.19
COPY --from=builder /tmp/bucketrepo /tmp/bucketrepo