package com.hmju.presentation.simple_like_recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.core.view.doOnAttach
import androidx.core.view.doOnDetach
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.*
import androidx.recyclerview.widget.RecyclerView
import com.hmju.domain.usecase.AddLikeUseCase
import com.hmju.domain.usecase.RemoveLikeUseCase
import com.hmju.likemanager.LikeManager
import com.hmju.presentation.JLogger
import com.til.model.RxBus
import com.til.model.RxBusEvent
import com.til.model.body.LikeRequestBody
import com.til.model.goods.GoodsEntity
import dagger.hilt.EntryPoints
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.Disposable

/**
 * Description : Base Like ViewHolder Class
 *
 * Created by juhongmin on 2022/01/15
 */
abstract class BaseSimpleLikeViewHolder<T : ViewDataBinding>(
    parent: ViewGroup,
    @LayoutRes layoutId: Int
) : RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(layoutId, parent, false)),
    LifecycleObserver {

    val binding: T by lazy { DataBindingUtil.bind(itemView)!! }
    private val simpleLikeEntryPoint: SimpleLikeEntryPoint by lazy {
        EntryPoints.get(itemView.context.applicationContext, SimpleLikeEntryPoint::class.java)
    }

    private var likeChangeDisposable: Disposable? = null
    private var likeRequestDisposable: Disposable? = null
    private var lifecycleOwner: LifecycleOwner? = null

    abstract fun onRefreshLike()
    abstract fun onBindView(item: Any)

    init {
        itemView.doOnAttach {
            JLogger.d("${this.javaClass.simpleName} onAttach")
            lifecycleOwner = it.findViewTreeLifecycleOwner()?.let { owner ->
                owner.lifecycle.addObserver(this)
                return@let owner
            }
        }


        itemView.doOnDetach {
            lifecycleOwner?.lifecycle?.removeObserver(this)
            lifecycleOwner = null
        }
    }

    private fun initLikeChange() {
        if (likeChangeDisposable != null) {
            closeLikeChangeDisposable()
        }
        likeChangeDisposable = RxBus.listen(RxBusEvent.SimpleLikeEvent::class.java)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                JLogger.d("LikeChange $it")
                onRefreshLike()
            }, {
                JLogger.e("LikeChange Error $it")
            })
    }

    protected fun simpleLikeClick(view: View, item: GoodsEntity?) {
        if (item == null) return

        view.isSelected = !view.isSelected
        requestLike(view.isSelected, item)
    }

    protected fun simpleLikeChange(view: View, item: GoodsEntity?) {
        if (item == null) return

        if (LikeManager.isLike(item.id)) {
            if (!view.isSelected) {
                binding.invalidateAll()
            }
        } else if (view.isSelected) {
            binding.invalidateAll()
        }
    }

    /**
     * 좋아요 추가 / 해제 요청
     * @param isAdd 추가 / 해제
     * @param item 좋아요 하는 상품 데이터
     */
    private fun requestLike(isAdd: Boolean, item: GoodsEntity) {
        if (likeRequestDisposable != null) {
            closeRequestDisposable()
        }
        val reqApi =
            if (isAdd) simpleLikeEntryPoint.goodsRepository().postLike(LikeRequestBody(item.id))
            else simpleLikeEntryPoint.goodsRepository().deleteLike(LikeRequestBody(item.id))

        likeRequestDisposable = reqApi
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                if (isAdd) {
                    Toast.makeText(itemView.context, "좋아요", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(itemView.context, "싫어요", Toast.LENGTH_SHORT).show()
                }
            }, {
                JLogger.e("Error $it")
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

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private fun onResume() {
        JLogger.d("${this.javaClass.simpleName} onResume $bindingAdapterPosition ${itemView.isAttachedToWindow}")

        if (itemView.isAttachedToWindow) {
            onRefreshLike()
        }

        initLikeChange()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    private fun onStop() {
        JLogger.e("${this.javaClass.simpleName} onStop $bindingAdapterPosition")
        closeLikeChangeDisposable()
        closeRequestDisposable()
    }
}