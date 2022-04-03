package com.til.tracking

import android.annotation.SuppressLint
import android.net.Uri
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.til.tracking.models.*
import com.til.tracking.ui.viewholder.*
import kotlinx.serialization.json.Json
import java.net.URLDecoder
import java.text.SimpleDateFormat

/**
 * Description :
 *
 * Created by juhongmin on 2022/03/31
 */
@SuppressLint("SimpleDateFormat")
internal object Extensions {

    private val minDate = SimpleDateFormat("HH:mm:ss")

    private val jsonFormat: Json by lazy {
        Json {
            prettyPrint = true
            isLenient = true // Json 큰따옴표 느슨하게 체크.
            ignoreUnknownKeys = true // Field 값이 없는 경우 무시
            coerceInputValues = true // "null" 이 들어간경우 default Argument 값으로 대체
        }
    }

    fun Long.toDate(): String {
        return minDate.format(this)
    }

    class TrackingDetailDiffUtil<out T : BaseTrackingUiModel>(
        private val oldList: List<T>,
        private val newList: List<T>
    ) : DiffUtil.Callback() {

        /**
         * newItem 에 데이터 클래스를 oldItem 의 데이터 형을 비교하여 둘다 같은 데이터 형인경우
         * 같은 형태로 형변환 하여 비교 처리하는 함수
         * @return true 같은 데이터 형이고 같은 데이터, false 다른 데이터
         */
        private inline fun <reified R> compareInstance(
            old: R,
            new: T,
            function: (R, R) -> Boolean
        ): Boolean {
            return if (new is R) {
                function(old, new)
            } else {
                false
            }
        }

        override fun getOldListSize(): Int {
            return oldList.size
        }

        override fun getNewListSize(): Int {
            return newList.size
        }

        override fun areItemsTheSame(oldPosition: Int, newPosition: Int): Boolean {
            return when (val oldItem = oldList[oldPosition]) {
                is TrackingHeaderUiModel ->
                    compareInstance<TrackingHeaderUiModel>(
                        oldItem,
                        newList[newPosition]
                    ) { old, new -> old.key == new.key }
                is TrackingPathUiModel ->
                    compareInstance<TrackingPathUiModel>(
                        oldItem,
                        newList[newPosition]
                    ) { old, new -> old.path == new.path }
                is TrackingQueryUiModel ->
                    compareInstance<TrackingQueryUiModel>(
                        oldItem,
                        newList[newPosition]
                    ) { old, new -> old.key == new.key }
                is TrackingBodyUiModel ->
                    compareInstance<TrackingBodyUiModel>(
                        oldItem,
                        newList[newPosition]
                    ) { old, new -> old.body == new.body }
                else -> false
            }
        }

        override fun areContentsTheSame(oldPosition: Int, newPosition: Int): Boolean {
            return when (val oldItem = oldList[oldPosition]) {
                is TrackingHeaderUiModel ->
                    compareInstance<TrackingHeaderUiModel>(
                        oldItem,
                        newList[newPosition]
                    ) { old, new -> old.key == new.key && old.value == new.value }
                is TrackingPathUiModel ->
                    compareInstance<TrackingPathUiModel>(
                        oldItem,
                        newList[newPosition]
                    ) { old, new -> old.path == new.path }
                is TrackingQueryUiModel ->
                    compareInstance<TrackingQueryUiModel>(
                        oldItem,
                        newList[newPosition]
                    ) { old, new -> old.key == new.key && old.value == new.value }
                is TrackingBodyUiModel ->
                    compareInstance<TrackingBodyUiModel>(
                        oldItem,
                        newList[newPosition]
                    ) { old, new -> old.body == new.body }
                else -> false
            }
        }
    }

    /**
     * Header UiModel 변환 처리함수
     */
    fun parseHeaderUiModel(map: Map<String, String>): List<BaseTrackingUiModel> {
        val uiList = mutableListOf<BaseTrackingUiModel>()
        map.forEach { entry ->
            uiList.add(
                TrackingHeaderUiModel(
                    key = entry.key,
                    value = entry.value
                )
            )
        }
        return uiList
    }

    /**
     * Request Query 값 UiModel 변환 처리 함수
     */
    fun parseQueryUiModel(fullQuery: String?): List<BaseTrackingUiModel> {
        if (fullQuery == null) return emptyList()
        val uiList = mutableListOf<BaseTrackingUiModel>()
        val uri = Uri.parse("https://host".plus(fullQuery))
        uri.queryParameterNames.forEach { key ->
            val parameterValue = uri.getQueryParameter(key) ?: ""
            uiList.add(
                TrackingQueryUiModel(
                    key = key,
                    value = URLDecoder.decode(parameterValue, Charsets.UTF_8.name())
                )
            )
        }
        return uiList
    }

    /**
     * BodyUiModel 변환 처리 함수
     */
    fun parseBodyUiModel(body: String?): BaseTrackingUiModel? {
        if (body.isNullOrEmpty()) return null
        val json = jsonFormat.parseToJsonElement(body)
        return TrackingBodyUiModel(json.toString())
    }

    internal class TrackingDetailAdapter : RecyclerView.Adapter<BaseTrackingViewHolder<*>>() {

        private val dataList = mutableListOf<BaseTrackingUiModel>()

        fun submitList(newList: List<BaseTrackingUiModel>?) {
            if (newList == null) return

            val diffResult =
                DiffUtil.calculateDiff(TrackingDetailDiffUtil(dataList, newList))
            dataList.clear()
            dataList.addAll(newList)
            diffResult.dispatchUpdatesTo(this)
        }

        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): BaseTrackingViewHolder<*> {
            return when (viewType) {
                R.layout.vh_tracking_header -> TrackingHeaderViewHolder(parent)
                R.layout.vh_tracking_path -> TrackingPathViewHolder(parent)
                R.layout.vh_tracking_query -> TrackingQueryViewHolder(parent)
                R.layout.vh_tracking_body -> TrackingBodyViewHolder(parent)
                else -> throw IllegalArgumentException("Invalid ViewType")
            }
        }

        override fun onBindViewHolder(holder: BaseTrackingViewHolder<*>, pos: Int) {
            runCatching {
                holder.onBindView(dataList[pos])
            }
        }

        override fun getItemViewType(pos: Int): Int {
            return if (dataList.size > pos) {
                dataList[pos].layoutId
            } else {
                return super.getItemViewType(pos)
            }
        }

        override fun getItemCount(): Int {
            return dataList.size
        }
    }
}
