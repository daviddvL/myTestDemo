package com.example.davidliu.demo.di.scope;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by david.liu on 2018/5/3.
 */

@Scope
@Retention(RUNTIME)
public @interface ActivityScope {
}
