#include <jni.h>
#include <android/log.h>

#define LOG_TAG    "native-lib"
#define LOGI(...) __android_log_print(ANDROID_LOG_INFO, LOG_TAG, __VA_ARGS__)
#define LOGD(...) __android_log_print(ANDROID_LOG_DEBUG, LOG_TAG, __VA_ARGS__)

JNIEXPORT void JNICALL
Java_com_juwan_jzalgorithms_ui_MainActivity_main(JNIEnv *env, jobject instance) {

    LOGI("main start...");

}