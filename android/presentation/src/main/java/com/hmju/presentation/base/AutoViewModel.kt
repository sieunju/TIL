package com.hmju.presentation.base

import java.lang.annotation.Inherited
import kotlin.reflect.KClass

/**
 * Description :
 *
 * Created by juhongmin on 2022/03/19
 */
@Inherited
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class AutoViewModel(
    val viewModel: KClass<out BaseViewModel>
)
