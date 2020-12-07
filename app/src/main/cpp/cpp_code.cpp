//
// Created by Stefanus Khrisna on 12/7/20.
//

#include <jni.h>
#include <string>
#include <iostream>


extern "C"
JNIEXPORT jdouble JNICALL
Java_com_example_lab1_MainActivity_logCalculation(JNIEnv *env, jobject thiz, jdouble number) {
    return log10(number);
}