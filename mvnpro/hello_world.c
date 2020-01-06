
#include <stdio.h>
#include <jni.h>

JNIEnv* create_vm(JavaVM **jvm)
{
    JNIEnv* env;
    JavaVMInitArgs args;
    JavaVMOption options;
    args.version = JNI_VERSION_1_8;
    args.nOptions = 1;
    options.optionString = "-Djava.class.path=/home/ramu/javasamples/javacpro/mvnpro/JavaFromC/dependancy/:/home/ramu/javasamples/javacpro/mvnpro/JavaFromC/dependancy/commons-cli-1.0.jar:/home/ramu/javasamples/javacpro/mvnpro/JavaFromC/dependancy/commons-io-1.3.2.jar:/home/ramu/javasamples/javacpro/mvnpro/JavaFromC/dependancy/commons-lang-1.0.jar:/home/ramu/javasamples/javacpro/mvnpro/JavaFromC/dependancy/commons-logging-1.0.jar:/home/ramu/javasamples/javacpro/mvnpro/JavaFromC/dependancy/hamcrest-core-1.3.jar:/home/ramu/javasamples/javacpro/mvnpro/JavaFromC/dependancy/JavaFromC-1.0-SNAPSHOT.jar:/home/ramu/javasamples/javacpro/mvnpro/JavaFromC/dependancy/json-simple-1.1.1.jar:/home/ramu/javasamples/javacpro/mvnpro/JavaFromC/dependancy/junit-4.11.jar";
    args.options = &options;
    args.ignoreUnrecognized = 0;
    int rv;
    rv =JNI_CreateJavaVM(jvm, (void**)&env, &args);
    if (rv < 0 || !env)
        printf("Unable to Launch JVM %d\n",rv);
    else
        printf("Launched JVM! :)\n");
    return env;
}

void invoke_class(JNIEnv* env)
{
    jclass hello_world_class;
    jmethodID main_method;
    hello_world_class = env->FindClass("com/server/jfromc/scalaberniClient");
    main_method = env->GetStaticMethodID( hello_world_class, "main", "([Ljava/lang/String;)V");
    env->CallStaticVoidMethod( hello_world_class, main_method, NULL);

}

int main(int argc, char **argv)
{
    JavaVM *jvm;
    JNIEnv *env;
    env = create_vm(&jvm);
    if(env == NULL)
        return 1;
    invoke_class(env);
    return 0;
}
