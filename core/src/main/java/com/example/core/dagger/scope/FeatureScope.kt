package com.example.core.dagger.scope

import java.lang.annotation.Documented
import javax.inject.Scope
import kotlin.annotation.AnnotationRetention.RUNTIME

@Documented
@Scope
@Retention(RUNTIME)
annotation class FeatureScope