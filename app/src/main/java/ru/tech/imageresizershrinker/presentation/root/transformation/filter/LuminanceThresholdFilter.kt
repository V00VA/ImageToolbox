package ru.tech.imageresizershrinker.presentation.root.transformation.filter


import android.content.Context
import android.graphics.Bitmap
import jp.co.cyberagent.android.gpuimage.filter.GPUImageFilter
import jp.co.cyberagent.android.gpuimage.filter.GPUImageLuminanceThresholdFilter
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue
import ru.tech.imageresizershrinker.R
import ru.tech.imageresizershrinker.domain.image.filters.Filter


@Parcelize
class LuminanceThresholdFilter(
    private val context: @RawValue Context,
    override val value: Float = 0.5f,
) : FilterTransformation<Float>(
    context = context,
    title = R.string.luminance_threshold,
    value = value,
    valueRange = 0f..1f
), Filter.LuminanceThreshold<Bitmap> {
    override val cacheKey: String
        get() = (value to context).hashCode().toString()

    override fun createFilter(): GPUImageFilter = GPUImageLuminanceThresholdFilter(value)
}