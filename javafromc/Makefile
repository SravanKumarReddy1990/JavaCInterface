all: run

helloWorld.class: helloWorld.java
	/usr/lib/jvm/java-8-openjdk-amd64/bin/javac helloWorld.java

hello_world: hello_world.c
	g++ -o hello_world \
	-L /usr/lib/jvm/java-8-openjdk-amd64/jre/lib/amd64/server/ \
	-I /usr/lib/jvm/java-8-openjdk-amd64/include/ \
	-I /usr/lib/jvm/java-8-openjdk-amd64/include/linux/ \
	hello_world.c \
	-ljvm \

run: helloWorld.class hello_world
	export LD_LIBRARY_PATH="/usr/lib/jvm/java-8-openjdk-amd64/jre/lib/amd64/server/"
	./hello_world

clean:
	rm -f helloWorld.class hello_world
