package com.example.davidliu.demo.di.qualifier;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by david.liu on 2018/5/3.
 */

@Qualifier
@Documented
@Retention(RUNTIME)
public @interface ZhihuUrl {

}
