package com.hmju.presentation.base

import androidx.databinding.ViewDataBinding
import androidx.databinding.ViewDataBindingKtx
import java.lang.annotation.Inherited

/**
 * Description : Activity or Fragment Class 에 선언해서
 * 자동으로 바인딩 처리해주는 Annotation Class
 *
 * Created by juhongmin on 2022/03/19
 */
@Inherited
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class AutoBinding
