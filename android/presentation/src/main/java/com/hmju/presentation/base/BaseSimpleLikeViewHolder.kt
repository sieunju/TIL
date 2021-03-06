package com.hmju.presentation.base

import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.core.view.doOnAttach
import androidx.core.view.doOnDetach
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.findViewTreeLifecycleOwner
import com.hmju.likemanager.LikeManager
import com.hmju.presentation.simple_like_recyclerview.SimpleLikeEntryPoint
import com.til.model.RxBus
import com.til.model.RxBusEvent
import com.til.model.body.LikeRequestBody
import com.til.model.goods.GoodsEntity
import dagger.hilt.EntryPoints
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.Disposable
import timber.log.Timber

/**
 * Description : Base Like ViewHolder Class
 *
 * Created by juhongmin on 2022/01/15
 */
abstract class BaseSimpleLikeViewHolder<T : ViewDataBinding>(
    parent: ViewGroup,
    @LayoutRes layoutId: Int
) : BaseViewHolder<T>(parent, layoutId),
    LifecycleEventObserver {

    private val simpleLikeEntryPoint: SimpleLikeEntryPoint by lazy {
        EntryPoints.get(itemView.context.applicationContext, SimpleLikeEntryPoint::class.java)
    }

    private var likeChangeDisposable: Disposable? = null
    private var likeRequestDisposable: Disposable? = null
    private var lifecycleOwner: LifecycleOwner? = null

    abstract fun onRefreshLike()

    init {
        itemView.doOnAttach {
            // JLogger.d("${this.javaClass.simpleName} onAttach")
            lifecycleOwner = it.findViewTreeLifecycleOwner()?.let { owner ->
                owner.lifecycle.addObserver(this)
                return@let owner
            }
        }


        itemView.doOnDetach {
            lifecycleOwner?.lifecycle?.removeObserver(this)
            lifecycleOwner = null
            closeLikeChangeDisposable()
            closeRequestDisposable()
        }
    }

    private fun initLikeChange() {
        if (likeChangeDisposable != null) {
            closeLikeChangeDisposable()
        }
        likeChangeDisposable = RxBus.listen(RxBusEvent.SimpleLikeEvent::class.java)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                onRefreshLike()
            }, {
                Timber.e("LikeChange Error $it")
            })
    }

    protected fun simpleLikeClick(view: View, item: GoodsEntity?) {
        if (item == null) return

        view.isSelected = !view.isSelected
        requestLike(view.isSelected, item)
    }

    protected fun simpleLikeChange(view: View, item: GoodsEntity?) {
        if (item == null) return

        // ????????? ????????? ?????? ?????? ?????????
        if (LikeManager.isLike(item.id)) {
            if (!view.isSelected) {
                binding.invalidateAll()
            }
        } else if (view.isSelected) {
            // ????????? ????????? ?????? ????????? ???????????? ????????? ???????????? -> ??????.
            binding.invalidateAll()
        }
    }

    /**
     * ????????? ?????? / ?????? ??????
     * @param isAdd ?????? / ??????
     * @param item ????????? ?????? ?????? ?????????
     */
    private fun requestLike(isAdd: Boolean, item: GoodsEntity) {
        if (likeRequestDisposable != null) {
            closeRequestDisposable()
        }
        val reqApi =
            if (isAdd) simpleLikeEntryPoint.goodsRepository().postLike(LikeRequestBody(item.id))
            else simpleLikeEntryPoint.goodsRepository().deleteLike(item.id)

        likeRequestDisposable = reqApi
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                if (isAdd) {
                    Toast.makeText(itemView.context, "?????????", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(itemView.context, "?????????", Toast.LENGTH_SHORT).show()
                }
            }, {
                Timber.e("Error $it")
            })
    }

    /**
     * Close Disposable
     */
    private fun closeLikeChangeDisposable() {
        likeChangeDisposable?.dispose()
        likeChangeDisposable = null
    }

    /**
     * Close Disposable
     */
    private fun closeRequestDisposable() {
        likeRequestDisposable?.dispose()
        likeRequestDisposable = null
    }

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        if (event == Lifecycle.Event.ON_RESUME) {
            if (itemView.isAttachedToWindow) {
                onRefreshLike()
            }

            initLikeChange()
        } else if (event == Lifecycle.Event.ON_STOP) {
            closeLikeChangeDisposable()
            closeRequestDisposable()
        }
    }

//    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
//    private fun onResume() {
//        if (itemView.isAttachedToWindow) {
//            onRefreshLike()
//        }
//
//        initLikeChange()
//    }
//
//    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
//    private fun onStop() {
//        closeLikeChangeDisposable()
//        closeRequestDisposable()
//    }
}
