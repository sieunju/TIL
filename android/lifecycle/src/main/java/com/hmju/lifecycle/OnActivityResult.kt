package com.hmju.lifecycle

import android.app.Activity

/**
 * Description : onActivityResult 에 대한 값을 ViewModel 에서 받을수 있도록 처리하는
 * Annotation Class
 * ex.)
 * @OnActivityResult(RequestCode, ResultCode)
 * fun 함수명(data : Bundle?) {
 *   // Do Something..
 * }
 * Created by juhongmin on 2022/03/11
 */
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class OnActivityResult(val requestCode: Int, val resCode: Int = Activity.RESULT_CANCELED)
